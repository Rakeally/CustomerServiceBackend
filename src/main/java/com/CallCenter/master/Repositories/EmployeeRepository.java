package com.CallCenter.master.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CallCenter.master.Entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmailIgnoreCase(String email);

}
