package org.bridgelabz.siddhu.cgemployeepayrollapp.repository;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeePayrollData,Long>{
}
