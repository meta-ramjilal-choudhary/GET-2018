package com.metacube.training.EmployeePortalWithSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortalWithSpringBoot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String login(){
		return "employee/login";
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("email") String email, 
			@RequestParam("password") String password){
		model.addAttribute("employee", employeeService.getAllEmployeeByEmail(email));
		return "/admin/employeeDashboard";
	}
	
	@RequestMapping(path="/forgot", method=RequestMethod.GET)
	public String forgot(Model model){
		return "/employee/forgot";
	}
	
	@RequestMapping(path="/forgot", method=RequestMethod.POST)
	public String forgot(Model model, @RequestParam("email") String email, @RequestParam("password") String pwd){
		model.addAttribute("employee", employeeService.updateEmployeePwd(email, pwd));
		return "employee/login";
	}
}
