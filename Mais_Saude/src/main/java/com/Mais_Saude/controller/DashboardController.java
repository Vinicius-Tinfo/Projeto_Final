package com.Mais_Saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping({"/Dashboard"})
		public String Home(Model model) {
		
		model.addAttribute("nome","vinicius");
		return"home/dashboard";
		
	}
}
