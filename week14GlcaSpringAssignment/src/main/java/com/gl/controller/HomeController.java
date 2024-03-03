package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gl.bean.Employee;
import com.gl.service.EmployeeService;

@Controller
@EnableWebMvc
public class HomeController {
	
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/addEmplyee")
	public String addEmployee(Model model)
	{
		model.addAttribute("emp", new Employee());
		return "addEmplyee";
	}
	
	
	
	@RequestMapping("/processEmp")
	public String processEmployee(@ModelAttribute("emp") Employee emp)
	{
		es.addEmployee(emp);
		return "redirect:/employeePage";
	}
	
	@RequestMapping("/employeePage")
	public String employeePage(Model model)
	{
//		System.out.println(es.showEmployee());
		model.addAttribute("empList", es.showEmployee());
		return "employeePage";
	}
	
	
	
	@RequestMapping("/deleteEmpById")
	public String deleteEmpById(@RequestParam("id") int id)
	{
		es.deleteEmployeeById(id);
		return "redirect:/employeePage";
	}
	
	@RequestMapping("/editEmpById")
	public String editEmpById(@RequestParam("id") int id,Model model)
	{
		
		model.addAttribute("emp", es.showEmployeeById(id));
		return "updateEmp";
	}
	
	
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("emp") Employee emp, @RequestParam("id") int id)
	{
		
		es.updateEmployeeById(emp, id);
		return "redirect:/employeePage";
	}

}
