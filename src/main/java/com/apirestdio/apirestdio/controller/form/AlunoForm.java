package com.apirestdio.apirestdio.controller.form;

import com.apirestdio.apirestdio.model.Aluno;

import lombok.Data;

@Data
public class AlunoForm {
	
	private String nome;

	public Aluno converter() {
		return new Aluno(this.nome);
	}

}
