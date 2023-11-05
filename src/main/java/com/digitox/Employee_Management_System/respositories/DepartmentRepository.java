package com.digitox.Employee_Management_System.respositories;

import com.digitox.Employee_Management_System.models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}