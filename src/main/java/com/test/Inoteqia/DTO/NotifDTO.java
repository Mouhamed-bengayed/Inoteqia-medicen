package com.test.Inoteqia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifDTO {
    private Date date;
    private String title;
    private String description;
    private String reminder;
    private String file;
    private List<Long> medecins;
}
