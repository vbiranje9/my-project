package com.cdac.StartupProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.StartupProject.model.Login;
import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Startup;
import com.cdac.StartupProject.service.LoginSevice;
import com.cdac.StartupProject.service.StartupService;



@Controller
public class StartupController 
{
	
	@Autowired
	private StartupService startupService;
	
	public void setStartUpService(StartupService startupService) {
		this.startupService = startupService;
	}

	@Autowired
	private LoginSevice loginService;
	

	public void setLoginService(LoginSevice loginService) {
		this.loginService = loginService;
	}


	public StartupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value= "/stpReg.htm" , method = RequestMethod.POST)
	public String save(@ModelAttribute("stp") Startup stp)
	{
		
		try {
		if(startupService.add(stp))
			return "login";
		else 
			return "registerStp";
		}catch(Exception e)
		{
			return "registerStp";
		}
		
	}
	
	@RequestMapping("/compStpLog.htm")
	public String startlog()
	{
			return "login";
	}
	
	@RequestMapping(value="/compStpLog.htm",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lg") Login lg,HttpSession session)
	{
		ModelAndView model; 
		
		try {
			Login lgn = loginService.login(lg);		
			if(lgn.getFlag() == 1){
				addUserInSession( lgn, session);
				List<Project>list = startupService.selectAll();
				model = new ModelAndView("startup_home");
				model.addObject("lists",list);
				System.out.println("returning model");
				return model;
				
			}
			else if (lgn.getFlag()==2) {
				addUserInSession( lgn, session);
				model=new ModelAndView("company_home");
				return model;
			}
			else
			{
				model = new ModelAndView("login");
				//modell.addAttribute("msg", "Incorrect username and password");
				return model;
			}
		}catch(Exception e)
		{
				System.out.println("catch login");
				model = new ModelAndView("login");
				return model;
		}
		
	}
	
	

	private void addUserInSession(Login l,HttpSession session)
	{
		session.setAttribute("uname",l.getUsername());
		session.setAttribute("pass", l.getPassword());
		session.setAttribute("role", l.getFlag());
	}
	
	@RequestMapping("/logout.htm")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/apply.htm")
	public String applyy()
	{
		return "demo";
	}

}
