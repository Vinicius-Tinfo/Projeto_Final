package com.Mais_Saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@GetMapping("/")
	public String Home(Model model) {
		model.addAttribute("nome","Vinicius");
		return"home/inicio";
	}
	
}
