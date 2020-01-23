package com.cdac.StartupProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping(value="/compStpLog.htm",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lg") Login lg,ModelMap modell)
	{
		ModelAndView model; 
		
		System.out.println("inside cntr"+lg.getUsername());
		
		try {
			Login lgn = loginService.login(lg);
			System.out.println(lgn.getFlag());
		
			if(lgn.getFlag() == 1)
		{
			  //List<Project>list = startUpService.selectAll();
			model = new ModelAndView("startup_home");
			//model.addObject("lists",list);
			System.out.println("starthome");
			return model;
		}
		else if (lgn.getFlag()==2) {
			model=new ModelAndView("company_home");
			return model;
		}
		else
		{
			model = new ModelAndView("login");
			modell.addAttribute("msg", "Incorrect username and password");
			return model;
		}
		}catch(Exception e)
		{
			System.out.println("catch login");
			model = new ModelAndView("login");
			return model;
		}
		
	}
	

}
