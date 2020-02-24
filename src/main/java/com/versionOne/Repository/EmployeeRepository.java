package com.versionOne.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.versionOne.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value = "Select number from employeeCard where number not in (select card from employee)", nativeQuery =true)
	List<String> getFreeCards();
	
	@Query(value = "SELECT concat(e1.first_name,' ',e1.last_name) as first_name, e1.position, e1.card  FROM employee e1 left join employee e2 on e1.branch = e2.branch where e1.employee_id != e2.employee_id order by first_name , length(e1.position) desc", nativeQuery = true)
	List<List<Object>> getProductiveEmployees();
}
