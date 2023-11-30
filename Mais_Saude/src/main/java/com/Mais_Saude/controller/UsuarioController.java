package com.Mais_Saude.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mais_Saude.model.UsuarioModel;
import com.Mais_Saude.repository.UsuarioRepository;




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
	
	@GetMapping("/deletar-usuario/{id}")
	public String Deletar(UsuarioModel usuario,@PathVariable("id") long id ) {
	usuario = (UsuarioModel)this.usuariorepository.getOne(id);
	this.usuariorepository.delete(usuario);

	return"redirect:/usuarios";
}
	  @GetMapping("usuario-{id}")
	  public String busca(@PathVariable long id, Model model){
	    Optional<UsuarioModel> usuarios = usuariorepository.findById(id);
	    try{
	      model.addAttribute("usuarios", usuarios.get());
	    }
	    catch(Exception err){ return "redirect:/"; }

		return ("usuarios/alterar");
	  }

	
	
	  @PostMapping("/{id}/atualizar")
	  public String atualizar(@PathVariable long id, UsuarioModel usuarios){
	    // if(!repo.exist(id)){
	    if(!usuariorepository.existsById(id)){
	      return "redirect:/";
	    }

	    usuariorepository.save(usuarios);

	    return "redirect:/usuarios";
	  }
	  
	
	
}
