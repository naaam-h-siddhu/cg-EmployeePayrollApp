package org.bridgelabz.siddhu.cgemployeepayrollapp.repository;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
