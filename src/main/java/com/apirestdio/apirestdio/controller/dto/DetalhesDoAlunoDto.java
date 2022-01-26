package com.apirestdio.apirestdio.controller.dto;

import com.apirestdio.apirestdio.model.Aluno;

import lombok.Getter;

@Getter
public class DetalhesDoAlunoDto {
	
	private String nome;
	
	private EnderecoDto endereco;

	public DetalhesDoAlunoDto(Aluno aluno) {
		
	}
}
