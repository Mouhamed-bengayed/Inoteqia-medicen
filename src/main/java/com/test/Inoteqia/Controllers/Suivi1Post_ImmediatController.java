package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.Consultations1Post_Immediat;
import com.test.Inoteqia.Services.Suivi1PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/Suivi1")
@RestController
public class Suivi1Post_ImmediatController {



    @Autowired
    Suivi1PostServices suivi1PostServices;


    @PostMapping(value = "/register/suivi1Post-Immediatt/")
    public ResponseEntity<Consultations1Post_Immediat> registerSuivi1_Immediat(@Validated @RequestBody Consultations1Post_Immediat Suivi1Post_Immediat) throws Exception {
        return suivi1PostServices.registerSuivi1Post_Immediat(Suivi1Post_Immediat);
    }

}
