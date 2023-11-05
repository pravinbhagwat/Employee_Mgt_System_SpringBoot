package com.digitox.Employee_Management_System.controllers;

import com.digitox.Employee_Management_System.models.Department;
import com.digitox.Employee_Management_System.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department departmentDetails) {
        try {
            Department updatedDepartment = departmentService.updateDepartment(id, departmentDetails);
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        } catch (RuntimeException ex) {
            // Ideally, you would have a custom exception here
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable String id) {
        try {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            // Ideally, you would have a custom exception here
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

