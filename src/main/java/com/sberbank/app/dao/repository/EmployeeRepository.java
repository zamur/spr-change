package com.sberbank.app.dao.repository;

import com.sberbank.app.dao.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
