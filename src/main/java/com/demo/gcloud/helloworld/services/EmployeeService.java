package com.demo.gcloud.helloworld.services;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.gcloud.helloworld.dto.Employee;

@Service
public class EmployeeService {

	private final JdbcTemplate jdbcTemplate;

	public EmployeeService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createEmployee(Employee employee) {

		String insertSql = "INSERT INTO Personal_Details (f_name, m_name, l_name, age) " + "VALUES (?, ?, ?, ?,?)";

		Object[] params = new Object[] {"Nishakant","","Pandey",40};
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC };

		return jdbcTemplate.update(insertSql, params, types);
	}
	
	public List<Employee> getEmployee(){
		
		List<Employee> employees = new ArrayList<Employee>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from Personal_Details");
		
		for (Map<String, Object> row : rows) {
			Employee employee = new Employee();
            employee.setId(((Long) row.get("id")).longValue());
            employee.setFirstName((String)row.get("f_name"));
            employee.setMiddleName((String)row.get("m_name"));
            employee.setLastName((String)row.get("l_name"));
            employee.setAge(((Integer) row.get("AGE")).intValue());
            employees.add(employee);
        }
        return employees;
	}

}
