package com.cdac.StartupProject.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.StartupProject.model.Company;
import com.cdac.StartupProject.model.Funding;
import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.service.CompanyServiceImple;



import com.cdac.StartupProject.model.Login;;

@Controller
public class CompanyController {
	
		@Autowired
		private CompanyServiceImple compserv;

		public void setCompserv(CompanyServiceImple compserv) {
			this.compserv = compserv;
		}


		@RequestMapping("/startupp.htm")
		public String Login(ModelMap model) {
			
			return "login";
		}
		
		
		@RequestMapping(value="/compReg.htm",method=RequestMethod.POST)
		public String insert(@ModelAttribute("comp")Company comp ,ModelMap model) {
			
			
			System.out.println("hey"+comp.getCompName());
			try {
				compserv.insert(comp);
				return "login";
			}catch(Exception e){
				return "registerComp";
			}
		}
		@RequestMapping(value = "/comProjectAdd.htm", method = RequestMethod.POST)
		public String addProject(@ModelAttribute("pro") Project pro ,HttpSession session ) {
			
			
			System.out.println("inside the cntr");
			Login lg= new Login();
			lg.setUsername(session.getAttribute("uname").toString());
			
			System.out.println("username is  "+lg.getUsername());
			
			lg.setFlag(Integer.parseInt((session.getAttribute("role").toString())));	
			
			
			
			compserv.addProject(pro,lg);
			
			return "project_added_msg";
		}
		
		@RequestMapping(value = "/list_stp_comp_cntr.htm", method = RequestMethod.GET)
		public ModelAndView selectStpFunds( HttpSession session ) {
			
			System.out.println("inside the cntr");
			
			ModelAndView model = new ModelAndView("list_stp_comp"); 
			
			List<Funding> list=compserv.selectStp();
			
			model.addObject("lists", list);
			
			return model;
		}
}
