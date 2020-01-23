package com.cdac.StartupProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.StartupProject.model.Company;
import com.cdac.StartupProject.service.CompanyServiceImple;

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
		
}
