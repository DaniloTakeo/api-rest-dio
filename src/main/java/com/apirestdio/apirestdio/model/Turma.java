package com.apirestdio.apirestdio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Aluno> alunos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Professor> professores;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Disciplina> disciplinas;
}
