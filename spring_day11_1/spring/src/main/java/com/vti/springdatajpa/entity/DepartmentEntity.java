package com.vti.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Department", catalog = "TestingSystem3")
public class DepartmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;


//    @OneToMany(mappedBy = "department")
//    private List<AccountEntity> accounts;

    public DepartmentEntity() {

    }

}
