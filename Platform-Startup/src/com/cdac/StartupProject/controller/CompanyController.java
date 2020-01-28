package com.cdac.StartupProject.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.StartupProject.model.Bidding;
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
			
			List<Integer>sid = new ArrayList<Integer>();
			List<Funding> list=compserv.selectStp();
			
			for (Funding fund : list) {
				sid.add(fund.getStartupId());
			}
			List<String>sname = compserv.sname(sid);
			
			model.addObject("lists", list);
			model.addObject("startupname", sname);
			
			return model;
		}
		
		@RequestMapping(value = "/list_stp_apply_bidding.htm")
		public ModelAndView selectStpBid() {
			
			ModelAndView model =new ModelAndView("list_proj_apply_stp");
			List<Integer>sid = new ArrayList<Integer>();
			List<Integer>pid=new ArrayList<Integer>();
			
			//Get startup list from db
			List<Bidding> list=compserv.selectStpBid();
			
			//using startupID get startup name
			for (Bidding fund1 : list) {
				sid.add(fund1.getStartupId());
			}
			List<String>sname = compserv.sname(sid);
			
			//using projectId get project name
			for(Bidding bid : list) {
				pid.add(bid.getProjectId());
			}
			List<String> pname=compserv.pname(pid);
			
			
			model.addObject("lists", list);
			model.addObject("startupname", sname);
			model.addObject("projectname", pname);
			
			return model;
		}
		
		@RequestMapping(value = "/selectProject.htm")
		public String  selectedProject(@ModelAttribute("pid") Project pid) {
			
			compserv.selectProject(pid.getProjetcId());
			
			return "selectedProject";
		}
}
