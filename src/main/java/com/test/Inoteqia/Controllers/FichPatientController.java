package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import com.test.Inoteqia.Entity.FichePatient;
import com.test.Inoteqia.Services.FichePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fichPatient")
public class FichPatientController {
@Autowired
FichePatientService patientService;
    @PostMapping(value = "/register-patient/{id}")
    public ResponseEntity<FichePatient> registerPatient(@RequestBody FichePatient p1 ) throws Exception {
        return patientService.registerPatient(p1);
    }

    @PutMapping(value = "/register-patient/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<FichePatient> registerfichePatient(@RequestBody FichePatient p1) throws Exception {
        return patientService.registerPatient(p1);
    }
    @PutMapping(value = "/update-patient/{id}")
    public ResponseEntity<FichePatient> updatePatient(@PathVariable   FichePatient FichePatient)  {
        return patientService.updatePatient(FichePatient);
    }
    @DeleteMapping(value = "/delete-patient/{id}")
    public ResponseEntity<FichePatient> deletePatient(@PathVariable  Long id)  {
        return patientService.deletePatient(id);
    }
@GetMapping(value = "/getPatientById/{id}")
    public FichePatient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
}
