package com.test.Inoteqia.Services;


import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.FileStorageService;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocalFileStorageService implements FileStorageService {
@Autowired
    private UtilisateurRepository utilisateurRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String storeFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        try {
            Path filePath = Paths.get(uploadDir + File.separator + fileName);
            Files.copy(file.getInputStream(), filePath);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }
    }


    public List<String> getMatchingImagePaths(List<String> databaseImageNames) {
        List<String> matchingImagePaths = new ArrayList<>();
        File directory = new File(uploadDir);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fullFileName = file.getName();
                        String[] parts = fullFileName.split("_"); // Split the filename based on underscore
                        if (parts.length == 2) {
                            String actualFileName = parts[1]; // Extract the actual filename
                            if (databaseImageNames.get(0).contains(actualFileName)) {
                                matchingImagePaths.add(file.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
        return matchingImagePaths;
    }


}

