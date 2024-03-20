package com.test.Inoteqia.Controllers;


import com.test.Inoteqia.DTO.OTP;
import com.test.Inoteqia.Interfaces.OTPInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/OTP")
public class OTPController {
    @Autowired
    OTPInterface otpInterface;
@PostMapping("/GenerateOTp")
    public OTP GenerateOTp() {
        return otpInterface.GenerateOTp();
    }
@PostMapping("/VerifOTP")
    public Boolean VerifOTP(@RequestBody OTP otp)  {
        return otpInterface.VerifOTP(otp);
    }
@PostMapping("/ResendOTP")
    public OTP ResendOTP(@RequestBody OTP existingOTP) {
        return otpInterface.ResendOTP(existingOTP);
    }
}
