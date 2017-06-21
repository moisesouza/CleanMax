package br.com.aplicativo.CleanMax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TipoServicoController {

	@RequestMapping("/exibirIncluirServico")
	public String exibirIncluirServico() {

		return "servico/incluirServico";
	}
}
