package com.apirestdio.apirestdio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apirestdio.apirestdio.controller.dto.AlunoDto;
import com.apirestdio.apirestdio.controller.dto.DetalhesDoAlunoDto;
import com.apirestdio.apirestdio.controller.form.AlunoForm;
import com.apirestdio.apirestdio.model.Aluno;
import com.apirestdio.apirestdio.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> consultarTodos() {
		List<Aluno> alunos = alunoRepository.findAll();
		
		return AlunoDto.converter(alunos);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = form.converter();
		alunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoAlunoDto> detalharAluno(@PathVariable Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoAlunoDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
