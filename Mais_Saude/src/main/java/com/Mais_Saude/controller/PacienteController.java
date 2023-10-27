package com.Mais_Saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mais_Saude.repository.PacienteRepository;
import com.Mais_Saude.model.PacientesModel;

@Controller
public class PacienteController {

	
	@Autowired
	private PacienteRepository pacienterepository;
	
	@GetMapping({"/pacientes"})
		public String Usuario(Model model) {
		
		model.addAttribute("paciente",pacienterepository.findAll());
		
		return"/paciente/listar-pacientes";
	}
	
	@GetMapping({"/cadastro-de-paciente"})
		public String NovoPaciente() {
		
		return"/paciente/cadastro";
	}
	
	@PostMapping(value="/paciente/criar")
		public ModelAndView PacienteModel(PacientesModel paciente) {
			ModelAndView mv = new ModelAndView("redirect:/pacientes");
			pacienterepository.save(paciente);
			return mv;
	}
}
