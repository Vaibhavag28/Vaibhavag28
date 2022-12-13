package com.market.controller;

import java.util.List;

//import org.aspectj.asm.AsmManager.ModelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

//import com.market.dto.LeadData;
import com.market.entities.Lead;
import com.market.services.LeadService;

@Controller	
public class LeadController {
		@Autowired
		private LeadService leadService;

		//Handler Methods have only string as return type
	
		//http://localhost:8080/create
	
		@RequestMapping("/create")
		public String viewCreateLeadForm() {
			return "createLeads";     // working as request dispatcher
		}
		
		//http://localhost:8080/saveLead
	//There are 3 ways to read data
		
		//1st by using @ModelAttribute
		// writing @ModelAttribute is not necessary
		
		@RequestMapping("/saveLead")
		public String saveLead(@ModelAttribute("lead") Lead lead,ModelMap model) {			//in this line spring boot works on its own only we have to create the lead object
			//in above line line entity class getting reference object
			model.addAttribute("msg", "record is saved!!"); //working a request.setAttribute
			leadService.saveOneLead(lead);
			return "createLeads";
		}
		
		//2nd way by using @RequestParam
		// use this only when there is no entity class
		
//		@RequestMapping("/saveLead")
//		public String saveLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName, @RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//			Lead lead =new Lead();
//			lead.setFirstName(firstName);
//			lead.setLastName(lastName);
//			lead.setEmail(email);
//			lead.setMobile(mobile);
//			leadService.saveOneLead(lead);
//			return"createLeads";
//		}
		
		//3rd way by using data transfer object (DTO)
		//use when no entity class present
		// use this when parameters are more then 5 otherwise use RequestParam
		
//		@RequestMapping("/saveLead")
//		public String saveLead(LeadData leadData) {
//			Lead lead =new Lead();
//			lead.setFirstName(leadData.getFirstName());
//			lead.setLastName(leadData.getLastName());
//			lead.setEmail(leadData.getEmail());
//			lead.setMobile(leadData.getMobile());
//			leadService.saveOneLead(lead);
//			return"createLeads";
//		}
		//http://localhost:8080/listAll
		
		@RequestMapping("/listAll")
		public String listLeads(Model model){
			List<Lead> leads=leadService.getAllLeads();
			model.addAttribute("leads", leads);
			return "list_Leads";
		}
		
		@RequestMapping("/delete")
		public String deleteOneMethod(@RequestParam("id") long id, Model model) {
			leadService.deleteLead(id);
			List<Lead> leads=leadService.getAllLeads();
			model.addAttribute("leads", leads);
			return "list_Leads";
			
		}
		
		@RequestMapping("/update")
		public String updateOneLead(@RequestParam("id") long id,Model model) {
			Lead lead = leadService.updateLead(id);
			model.addAttribute("lead", lead);
			return "updateLeads";
		}
		
		@RequestMapping("/updateLead")
		public String updateLead(@ModelAttribute("lead") Lead lead,ModelMap model) {			//in this line spring boot works on its own only we have to create the lead object
			leadService.saveOneLead(lead);
			List<Lead> leads=leadService.getAllLeads();
			model.addAttribute("leads", leads);
			return "list_Leads";
		}
}