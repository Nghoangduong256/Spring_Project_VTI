package com.vti.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Department")
public class DepartmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "totalMember")
    private int totalMember;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;
//    @OneToMany(mappedBy = "department")
//    private List<AccountEntity> accounts;

    public DepartmentEntity() {

    }

    // taọ enum type
    public enum Type {
        DEV("Dev"), TEST("Test"), SCRUM_MASTER("Scrum master"), PM ("Pm");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


}
