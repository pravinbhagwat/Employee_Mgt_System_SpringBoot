package com.digitox.Employee_Management_System.services;

import com.digitox.Employee_Management_System.models.Department;
import com.digitox.Employee_Management_System.respositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String id, Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found for this id :: " + id));

        department.setDepartmentName(departmentDetails.getDepartmentName());
        // Note: Handle createdAt and updatedAt appropriately

        final Department updatedDepartment = departmentRepository.save(department);
        return updatedDepartment;
    }

    public void deleteDepartment(String id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found for this id :: " + id));

        departmentRepository.delete(department);
    }
    public boolean doesDepartmentExist(String departmentId) {
        return departmentRepository.existsById(departmentId);
    }
}