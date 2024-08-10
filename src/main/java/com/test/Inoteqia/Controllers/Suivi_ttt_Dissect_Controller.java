package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.DTO.ConsultationsDto;
import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import com.test.Inoteqia.Services.Suivi_ttt_Dissect_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/Suivi1")
@RestController
public class Suivi_ttt_Dissect_Controller {



    @Autowired
    Suivi_ttt_Dissect_Services suivi_ttt_dissect_services;



    @PutMapping(value = "/register/Suivi_ttt_Dissect/{patientId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Consultations_ttt_Dissect> registerSuivi_ttt_Dissect(@RequestBody ConsultationsDto suivi_ttt_Dissect, @PathVariable ("patientId") Long patientId) throws Exception {
        return suivi_ttt_dissect_services.registerSuivittt_Dissect(suivi_ttt_Dissect,patientId);
    }
}
