package org.bridgelabz.siddhu.cgemployeepayrollapp.repository;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<EmployeePayrollData,Long>{
    @Query(value = "SELECT ep.* FROM employee_payroll ep " +
            "JOIN employee_department ed ON ep.employeeid = ed.employee_id " +
            "WHERE ed.department = :department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeePayrollDataByDepartments(@Param("department") String department);

}
