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
public class PacientesController {
@Autowired
private PacienteRepository pacientesrepository;

@GetMapping("/pacientes")
public String Pacientes(Model model) {
	model.addAttribute("pacientes", pacientesrepository.findAll());
	return "/paciente/listar-pacientes";
}

@GetMapping ("/cadastro-paciente")
public String Novo(Model model) {
	return "/paciente/cadastro-paciente";
}
@PostMapping(value="pacientes/cadastrar-paciente")
public ModelAndView PacientesModel(PacientesModel pacientes) {
	ModelAndView mv = new ModelAndView("redirect:/pacientes");
	pacientesrepository.save(pacientes);
	
	return mv;
}
}
