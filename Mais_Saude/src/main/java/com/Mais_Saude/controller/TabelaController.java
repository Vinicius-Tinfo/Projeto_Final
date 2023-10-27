package com.Mais_Saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TabelaController {

	@GetMapping({"/tabela"})
		public String Tabela() {
		return "/tabela";
	}
	
}
