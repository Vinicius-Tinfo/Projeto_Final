package com.Mais_Saude.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mais_Saude.model.ConsultaModel;
import com.Mais_Saude.model.PacientesModel;
import com.Mais_Saude.repository.ConsultaRepository;
import com.Mais_Saude.repository.PacienteRepository;


@Controller
public class ConsultaController {
@Autowired
private ConsultaRepository consultarepository;
@Autowired
private PacienteRepository pacienterepository;

	@GetMapping({"/consultas"})
	public String Consulta(Model model) {
		model.addAttribute("consulta", consultarepository.findAll());
	return "/consulta/listar-consultas";
	}

@GetMapping ("/consultar-{id}")
public String consultar(@PathVariable long id, Model model) {
	Optional<PacientesModel> pacientes = pacienterepository.findById(id);
	try {
		model.addAttribute("pacientes", pacientes.get());
	}
	catch(Exception err) { return "redirect:/pacientes";}
	
	return "/consulta/consultar";
	}

@PostMapping(value="consulta/realizar-consulta")
	public ModelAndView ConsultaModel(ConsultaModel consulta) {
	ModelAndView mv = new ModelAndView("redirect:/consultas");
	consultarepository.save(consulta);
	return mv;
}



}