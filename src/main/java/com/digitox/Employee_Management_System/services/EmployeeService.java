package com.digitox.Employee_Management_System.services;

import com.digitox.Employee_Management_System.exceptions.DepartmentNotFoundException;
import com.digitox.Employee_Management_System.models.Employee;
import com.digitox.Employee_Management_System.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitox.Employee_Management_System.services.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        // Note: Handle createdAt and updatedAt appropriately

        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + id));

        employeeRepository.delete(employee);
    }

    public List<Employee> getEmployeesByDepartmentId(String departmentId) {
        if (!departmentService.doesDepartmentExist(departmentId)) {
            throw new DepartmentNotFoundException("Department not found with id: " + departmentId);
        }
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
