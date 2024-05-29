package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.SuiviArthrodese;
import com.test.Inoteqia.Entity.Suivi_ttt_Dissect;
import com.test.Inoteqia.Services.SuiviArthrodeseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/SuiviArthrodese")
@RestController

public class SuiviArthrodeseController {

    @Autowired
    SuiviArthrodeseServices suiviArthrodeseServices;

    @PostMapping(value = "/register/Suivi_Arthodese")
    public ResponseEntity<SuiviArthrodese> registerSuiviArthrodese(@Validated @RequestBody SuiviArthrodese suiviArthrodese) throws Exception {
        return suiviArthrodeseServices.registerSuiviArthrodese(suiviArthrodese);
    }
}
