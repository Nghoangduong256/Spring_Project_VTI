package com.vti.springdatajpa.service;

import com.vti.springdatajpa.dto.DepartmentDto;
import com.vti.springdatajpa.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    public List<DepartmentEntity> getAllDepertment();

    public DepartmentEntity getDepartmentById(int id);

    public List<DepartmentEntity> getDepartmentByName(String name);

    public DepartmentDto createDepartment(DepartmentDto departmentDto);

    public void updateDepartment(DepartmentDto departmentDto, int id);

    public void deleteDepartment(int id);
}
