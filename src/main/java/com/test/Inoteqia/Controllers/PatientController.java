package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.ServiceIMP.UserServiceIMP;
import com.test.Inoteqia.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/patient")
@RestController
public class PatientController {

//    @Autowired
//    PatientService patientService;
//    @Autowired
//    UserServiceIMP userServiceIMP;
//
////    @GetMapping("/list-patient")
////    public List<Patient> ListPatient() throws Exception {
////        return patientService.getAllPatient();
////    }
//    @DeleteMapping("/delete-patient/{idUser}")
//    public void deletePatient(@PathVariable("idUser") Long idUser) {
//        patientService.deletePatient(idUser);
//    }
//
////    @PostMapping(value = "/register-patient/")
////    public ResponseEntity<Patient> registerPatient(@Validated @RequestBody Patient p1) throws Exception {
////        return patientService.registerPatient(p1);
////    }
////    @PostMapping(value = "/registerFichepatient/")
}
