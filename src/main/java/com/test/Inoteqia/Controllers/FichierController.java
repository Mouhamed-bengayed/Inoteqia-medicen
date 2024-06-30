package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.FileStorageService;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
public class FichierController {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/images/{imageName:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        // Extract the actual filename from the request path
        // String actualFileName = imageName.substring(imageName.indexOf("_") + 1);

        // Construct the full path to the image file
        Path imagePath = Paths.get(uploadDir, imageName);

        // Read the image bytes from the file
        byte[] imageBytes = Files.readAllBytes(imagePath);

        // Determine the MIME type of the image based on its file extension
        String contentType = Files.probeContentType(imagePath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(contentType));

        // Return the image bytes along with appropriate headers
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @PostMapping("uploadimage")
    public ResponseEntity<?> uploadImage(@RequestPart("image") MultipartFile file) {


        String fileName = fileStorageService.storeFile(file);
        if(!fileName.isEmpty()){
            return ResponseEntity.ok().body(fileName);}

        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("image not uploaded");
        }
    }


    @PostMapping("/uploadpdf")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }

        try {

            String fileName = fileStorageService.storeFile(file);
            return "File uploaded successfully: " + fileName;
        } catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
    @PostMapping(value = "/upload_photo_profile/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadPhoto(@PathVariable Long userId, @RequestPart("photo") MultipartFile file) {
        // Vérifier si le userId existe
        Optional<Utilisateur> user = utilisateurRepository.findById(userId);
        if (user.isPresent()) {
            //Utilisateur user = user.get();
            String fileName = fileStorageService.storeFile(file);
            if (!fileName.isEmpty()) {
                // Mettre à jour le champ photo du cuser
                user.get().setImage(fileName);
                utilisateurRepository.save(user.get());
                return ResponseEntity.status(HttpStatus.OK).body("Photo uploaded successfully for user.get(): " + user.get().getId());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/candidats/{userId}/photo")
    public ResponseEntity<byte[]> getCandidatPhoto(@PathVariable Long userId) {
        // Récupérer le candidat à partir de la base de données
        Optional<Utilisateur> optionalCandidat = utilisateurRepository.findById(userId);
        if (optionalCandidat.isPresent()) {
            Utilisateur user = optionalCandidat.get();
            String photoFileName = user.getImage();
            // Construire l'URL de l'image en utilisant le nom du fichier photo
            Path photoPath = Paths.get(uploadDir, photoFileName);
            try {
                byte[] photoBytes = Files.readAllBytes(photoPath);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG); // ou MediaType.IMAGE_PNG selon le type de l'image
                return new ResponseEntity<>(photoBytes, headers, HttpStatus.OK);
            } catch (IOException e) {
                // Gérer l'erreur de lecture du fichier
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Gérer le cas où le candidat n'est pas trouvé
        }
    }

}
