package br.com.aplicativo.CleanMax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

	@RequestMapping("/cadastro")
		public String CadastroCliente() {
	
			return "cadastro/cadastroCliente";
	}
	


	}
	

