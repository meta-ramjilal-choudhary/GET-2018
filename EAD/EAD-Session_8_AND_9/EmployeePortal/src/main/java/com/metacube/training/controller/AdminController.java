package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobTitleService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProjectService projectService;
	
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private JobTitleService jobTitleService;

	@Autowired
	private EmployeeService employeeService;
	
	//Login page controlling
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}
	
	//Projects Page controlling
	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}
	
	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}
	
	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getProject_id() == null) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") Long id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	//Skills Page Controlling
	@RequestMapping(path="/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model){
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}
	
	@RequestMapping(path="/skills/add", method = RequestMethod.GET)
	public String createSkill(Model model){
		model.addAttribute("skill", new Skill());
		return "admin/editSkill";
	}
	
	@RequestMapping(path="/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill){
		if(skill != null && skill.getSkill_id() == null){
			skillService.createSkill(skill);
		}
		else{
			skillService.updateSkill(skill);
		}
		return "redirect:/admin/skills";
	}
	
	@RequestMapping(path="/skills/edit", method=RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") Long id){
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editSkill";
	}
	
	@RequestMapping(path = "/skills/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("id") Long id){
		skillService.deleteSkill(id);
		return "redirect:/admin/skills";
	}
	
	// Job title controlling
	@RequestMapping(path="/jobtitles", method=RequestMethod.GET)
	public String getAllJobTitles(Model model){
		model.addAttribute("jobtitles", jobTitleService.getAllJobTitles());
		return "admin/jobtitles";
	}
	
	@RequestMapping(path="/jobtitles/add", method=RequestMethod.GET)
	public String createJobTitle(Model model){
		model.addAttribute("jobtitle", new JobTitle());
		return "admin/editJobtitle";
	}
	
	@RequestMapping(path="/jobtitles/edit", method=RequestMethod.GET)
	public String editJobtitle(Model model, @RequestParam("id") Long id){
		model.addAttribute("jobtitle", jobTitleService.getJobTitleById(id));
		return "admin/editJobtitle";
	}
	
	@RequestMapping(path="/jobtitles", method=RequestMethod.POST)
	public String saveJobtitle(@ModelAttribute("jobtitle") JobTitle jobTitle){
		if(jobTitle != null && jobTitle.getJob_code() == null){
			jobTitleService.createJobTitle(jobTitle);
		}else{
			jobTitleService.updateJobTitle(jobTitle);
		}
		return "redirect:/admin/jobtitles";
	}
	
	@RequestMapping(path="/jobtitles/delete", method=RequestMethod.GET)
	public String deleteJobtitle(@RequestParam("id") Long id){
		jobTitleService.deleteJobTitle(id);
		return "redirect:/admin/jobtitles";
	}
	
	//Employee page controller..
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public String getAllEmployees(Model model){
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "/admin/employees";
	}
	
	@RequestMapping(path="/employees/add", method = RequestMethod.GET)
	public String createEmployee(Model model){
		model.addAttribute("employee", new Employee());
		return "/admin/editEmployee";
	}
	
	@RequestMapping(path="/employees/edit", method=RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") Long id){
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "admin/editEmployee";
	}
	
	@RequestMapping(path="/employees", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		if(employee != null && employee.getEmp_code() == null){
			employeeService.createEmployee(employee);
		}else{
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employees";
	}
	
	@RequestMapping(path="/employees/delete", method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") Long id){
		employeeService.deleteEmployee(id);
		return "redirect:/admin/employees";
	}
}
