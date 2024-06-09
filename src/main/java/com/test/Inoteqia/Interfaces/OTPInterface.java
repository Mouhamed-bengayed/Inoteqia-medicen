package com.test.Inoteqia.Interfaces;

import com.test.Inoteqia.DTO.OTP;

public interface OTPInterface {
    OTP GenerateOTp( );
    Boolean VerifOTP(String otp) ;

    OTP ResendOTP(String email);
    void  DeleteALLOTP();
    void userstatus(String emailuser, Boolean result);


}
