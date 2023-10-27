package com.Mais_Saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.Mais_Saude.model.AdministradoresModel;
import com.Mais_Saude.repository.AdministradoresRepository;

@Controller
public class AdministradoresController {

	@Autowired
	private AdministradoresRepository admrepository;
	
	@GetMapping({"/administradores"})
		public String Administradores(Model model) {
		
		model.addAttribute("administradores",admrepository.findAll());
		
		return"/administradores/administradores";
	}
	
	
	@GetMapping({"/cadastro"})
		public String Novo() {
		
		return"/administradores/cadastro";
	}
	
	@PostMapping(value="/administradores/criar")
		public ModelAndView AdministradoresModel(AdministradoresModel administradores) {
		ModelAndView mv= new ModelAndView("redirect:/administradores");
		admrepository.save(administradores);
		return mv;
	}
	
}
