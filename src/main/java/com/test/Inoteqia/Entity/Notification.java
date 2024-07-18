package com.test.Inoteqia.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
//@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String title;
    private String message;
    private String rappel;
    private String file;

    @OneToMany
    private List<GroupeMed> groupeMeds=new ArrayList<>();
}
