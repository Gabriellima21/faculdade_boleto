package br.com.faculdade.boleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.faculdade.boleto.entity.Aluno;
import br.com.faculdade.boleto.service.AlunoService;

@RestController
@RequestMapping(path = "aluno")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@PostMapping
	public Aluno salvar(Aluno aluno) {
		return alunoService.salvar(aluno);
	}

}
