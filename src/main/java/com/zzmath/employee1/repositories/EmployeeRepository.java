package com.zzmath.employee1.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zzmath.employee1.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	 @Query(value = "SELECT * \n" + 
	 		"FROM   tb_employee \n" + 
	 		"WHERE  employee_age IN \n" + 
	 		"(SELECT Max(employee_age) FROM tb_employee \n" + 
	 		"UNION ALL \n" + 
	 		"SELECT Min(employee_age) FROM tb_employee); \n"+
	 		"SELECT AVG(employee_age) as average FROM tb_employee;", nativeQuery = true)
	 	Set<Employee> findByAge(Employee employee);
	 
	 @Query(value = "SELECT * \n" + 
	 		"FROM   tb_employee \n" + 
	 		"WHERE  employee_salary IN \n" + 
	 		"(SELECT Max(employee_salary) FROM tb_employee \n" + 
	 		"UNION ALL \n" + 
	 		"SELECT Min(employee_salary) FROM tb_employee); \n" + 
	 		"SELECT AVG(employee_salary) as average FROM tb_employee;", nativeQuery = true)
	 	Set<Employee> FindBySalary(Employee employee);
}
