package com.dailycodebuffer.department.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    @Setter(AccessLevel.PRIVATE)
    private Long version;
    private String name;
    private String address;
    private String code;
}
