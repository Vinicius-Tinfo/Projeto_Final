package com.Mais_Saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.Mais_Saude.repository.UsuarioRepository;
import com.Mais_Saude.model.UsuarioModel;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@GetMapping({"/usuarios"})
		public String Usuarios(Model model) {
			model.addAttribute("usuarios", usuariorepository.findAll());
		return"usuarios/listar-usuarios";
	}
	
	@GetMapping({"/cadastro-de-usuario"})
		public String NovoUsuario() {
		return"/usuarios/cadastro";
	}
	
	@PostMapping(value="/usuario/criar")
		public ModelAndView UsuarioModel(UsuarioModel usuarios) {
			ModelAndView mv = new ModelAndView("redirect:/usuarios");
			usuariorepository.save(usuarios);
			return mv;
	}
	
}
