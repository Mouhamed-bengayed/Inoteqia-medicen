package com.test.Inoteqia.DTO;

import lombok.Data;

@Data
public class ResetPass {
    String oldPassword;
    String newPassword;
    String code;
}
