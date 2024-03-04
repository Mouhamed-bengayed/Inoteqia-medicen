package com.test.Inoteqia.Entity;


import com.test.Inoteqia.DTO.RoleName;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;


@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;




}
