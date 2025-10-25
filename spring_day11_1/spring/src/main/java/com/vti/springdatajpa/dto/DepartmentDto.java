package com.vti.springdatajpa.dto;

import com.vti.springdatajpa.entity.AccountEntity;
import com.vti.springdatajpa.entity.DepartmentEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DepartmentDto {

    private String name;

    private int totalMember;

    private Type type;

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
