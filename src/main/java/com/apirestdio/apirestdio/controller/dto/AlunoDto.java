package com.apirestdio.apirestdio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.apirestdio.apirestdio.model.Aluno;

import lombok.Getter;

@Getter
public class AlunoDto {
	
	private String nome;
	
	public AlunoDto(Aluno aluno) {
		this.nome = aluno.getNome();
	}

	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

}
