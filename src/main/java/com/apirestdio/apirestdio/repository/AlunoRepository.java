package com.apirestdio.apirestdio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestdio.apirestdio.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
