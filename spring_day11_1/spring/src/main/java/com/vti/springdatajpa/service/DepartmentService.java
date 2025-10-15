package com.vti.springdatajpa.service;

import com.vti.springdatajpa.dto.DepartmentDto;
import com.vti.springdatajpa.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    public List<DepartmentDto> getAllDepertment ();

    public DepartmentDto getDepartmentById(int id);

    public DepartmentDto createDepartment (DepartmentDto departmentDto);

    public void updateDepartment(DepartmentDto departmentDto, int id);

    public void deleteDepartment(int id);
}
