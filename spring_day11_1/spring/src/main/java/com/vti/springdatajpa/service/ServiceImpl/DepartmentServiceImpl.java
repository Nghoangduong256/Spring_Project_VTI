package com.vti.springdatajpa.service.ServiceImpl;

import com.vti.springdatajpa.dto.DepartmentDto;
import com.vti.springdatajpa.entity.DepartmentEntity;
import com.vti.springdatajpa.repository.DepartmentRepository;
import com.vti.springdatajpa.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> getAllDepertment() {
        List<DepartmentEntity> departmentList = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (DepartmentEntity departmentEntity : departmentList){
            DepartmentDto departmentDto = modelMapper.map(departmentEntity, DepartmentDto.class);
            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow();
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity saved = departmentRepository.save(departmentEntity);
        return modelMapper.map(saved, DepartmentDto.class);
    }

    @Override
    public void updateDepartment(DepartmentDto departmentDto, int id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found")) ;

        // Thiết lập trường cần update
        departmentEntity.setName(departmentDto.getName());

        DepartmentEntity updated = departmentRepository.save(departmentEntity);
        modelMapper.map(updated, DepartmentDto.class);
    }

    @Override
    public void deleteDepartment(int id) {
        if (!departmentRepository.existsById(id)){
            throw new RuntimeException("Department not found");
        }

        departmentRepository.deleteById(id);
    }
}
