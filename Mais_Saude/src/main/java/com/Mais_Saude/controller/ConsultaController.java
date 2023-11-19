package com.Mais_Saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mais_Saude.repository.ConsultaRepository;
import com.Mais_Saude.model.ConsultaModel;

@Controller
public class ConsultaController {
@Autowired
private ConsultaRepository consultarepository;
	@GetMapping({"/consultas"})
	public String Consulta(Model model) {
		model.addAttribute("consulta", consultarepository.findAll());
	return "/consulta/listar-consultas";
	}

@GetMapping ("/consultar")
public String consultar(Model model) {
	return "/consulta/consultar";
	}

@PostMapping(value="consulta/realizar-consulta")
	public ModelAndView ConsultaModel(ConsultaModel consulta) {
	ModelAndView mv = new ModelAndView("redirect:/consultas");
	consultarepository.save(consulta);
	return mv;
}



}