package com.demo.gcloud.helloworld.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gcloud.helloworld.dto.Employee;
import com.demo.gcloud.helloworld.services.EmployeeService;

@RestController
public class HelloController {

	@Autowired
	protected EmployeeService employeeService;

	@GetMapping("/welcome")
	public String welcome() throws UnknownHostException {
		InetAddress myIP = InetAddress.getLocalHost();
		return "Welcome to GCP " + myIP.getHostAddress();
	}

	@GetMapping("/get/employee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}

	@PostMapping("/create/employee")
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return "Record Inserted";
	}
}
