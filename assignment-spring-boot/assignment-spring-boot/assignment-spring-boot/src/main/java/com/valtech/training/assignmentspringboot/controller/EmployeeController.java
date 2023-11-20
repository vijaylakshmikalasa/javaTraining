package com.valtech.training.assignmentspringboot.controller;


import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.assignmentspringboot.entity.Department;
import com.valtech.training.assignmentspringboot.models.DepartmentModels;
import com.valtech.training.assignmentspringboot.models.EmployeeModels;
import com.valtech.training.assignmentspringboot.service.EmployeeService;
 
 
@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {
 
	@Autowired
	private EmployeeService employeeService;
 
	private List<Department> departments;
 
	private DepartmentModels departmentModels;
 
	private int currentId;
	private int presentId;
 
	@GetMapping("/new")
	public String newEmployee(Model model) {
 
		model.addAttribute("employees", new EmployeeModels());
		return "employees/new";
	}
 
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("id") Integer id, Model model) {
 
		model.addAttribute("employees", new EmployeeModels(employeeService.getEmployee(id)));
		return "employees/edit";
	}
 
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Integer id, Model model) {
 
		employeeService.deleteEmployee(id);
		return "redirect:list";
	}
 
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEmployee(Model model) {
 
		departments = employeeService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department dept = departments.get(employeeService.getFirstId() - 1);
			departmentModels = new DepartmentModels(dept);
			model.addAttribute("departments", departmentModels);
		}
 
		model.addAttribute("employees", employeeService.getAllEmployees().stream().map(emp -> new EmployeeModels(emp))
				.collect(Collectors.toList()));
		return "employees/list";
	}
 
	@PostMapping(path = "/save", params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModels employeeModels, @RequestParam("submit") String submit,
			Model model) {
 
		if (submit.equals("Create")) {
			employeeService.createEmployee(employeeModels.getEmployee());
		}
		departments = employeeService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department dept = departments.get(employeeService.getFirstId() - 1);
			departmentModels = new DepartmentModels(dept);
			model.addAttribute("departments", departmentModels);
		}
		model.addAttribute("employees", employeeService.getAllEmployees().stream().map(emp -> new EmployeeModels(emp))
				.collect(Collectors.toList()));
		return "employees/list";
	}
	@GetMapping("/list")
	public String listEmployee(Model model) {
 
		departments = employeeService.getAllDepartments();
		if (!departments.isEmpty()) {
//			Department dept = departments.get(employeeService.getFirstId() - 1);
			Department dept=employeeService.getDepartment(employeeService.getFirstId());
			departmentModels = new DepartmentModels(dept);
			model.addAttribute("departments", departmentModels);
		}
		model.addAttribute("employees", employeeService.getAllEmployees().stream().map(emp -> new EmployeeModels(emp))
				.collect(Collectors.toList()));
		return "employees/list";
	}
 
	@PostMapping(path = "/list", params = "submit")
	public String listEmployee(@RequestParam("submit") String submit, Model model) {
 
		currentId = departmentModels.getId();
 
		if (submit.equals("Last")) {
//			Department dept = departments.get(employeeService.getLastId() - 1);
			Department  dept=employeeService.getDepartment(employeeService.getLastId());
			departmentModels = new DepartmentModels(dept);
			presentId = departmentModels.getId();
 
		} else if (submit.equals("Previous")) {
			if (currentId != employeeService.getFirstId()) {
//				Department dept = departments.get(employeeService.getPreviousId(currentId) - 1);
				Department dept=employeeService.getDepartment(employeeService.getPreviousId(currentId));
				departmentModels = new DepartmentModels(dept);
				presentId = departmentModels.getId();
 
			} 
				else {
//				Department dept = departments.get(employeeService.getFirstId() - 1);
				Department  dept=employeeService.getDepartment(employeeService.getLastId());
				departmentModels = new DepartmentModels(dept);
				presentId = departmentModels.getId();
			}
		} else if (submit.equals("Next")) {
			if (currentId != employeeService.getLastId()) {
//				Department dept = departments.get(employeeService.getNextId(currentId) - 1);
				Department dept=employeeService.getDepartment(employeeService.getNextId(currentId));
				departmentModels = new DepartmentModels(dept);
				presentId = departmentModels.getId();
 
			}
				else {
//				Department dept = departments.get(employeeService.getLastId() - 1);
				Department dept=employeeService.getDepartment(employeeService.getFirstId());
				departmentModels = new DepartmentModels(dept);
				presentId = departmentModels.getId();
			}
		} else if (submit.equals("First")) {
//			Department dept = departments.get(employeeService.getFirstId() - 1);
			Department dept=employeeService.getDepartment(employeeService.getFirstId());
			departmentModels = new DepartmentModels(dept);
			presentId = departmentModels.getId();
		}
		model.addAttribute("departments", departmentModels);
		model.addAttribute("employees", employeeService.getAllEmployeesByDepartmentId(presentId)
				.stream().map(emp -> new EmployeeModels(emp)).collect(Collectors.toList()));
		return "employees/list";
	}
 
}