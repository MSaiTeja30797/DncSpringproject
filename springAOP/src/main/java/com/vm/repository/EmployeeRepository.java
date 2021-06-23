package com.vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository < Employee, Long > {

}
