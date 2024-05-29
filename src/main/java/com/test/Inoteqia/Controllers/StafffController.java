package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.Staff;
import com.test.Inoteqia.Entity.Suivi1Post_Immediat;
import com.test.Inoteqia.Services.StafffServices;
import com.test.Inoteqia.Services.Suivi1PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/api/staff")
@RestController
public class StafffController {


    @Autowired
    StafffServices stafffServices;


    @PostMapping(value = "/register/staff/")
    public ResponseEntity<Staff> registerStaff(@Validated @RequestBody Staff staffregi) throws Exception {
        return stafffServices.registerStaff(staffregi);
    }
}
