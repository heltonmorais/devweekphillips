package com.dio_class.devweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entity.Regiao;
import com.dio_class.devweek.repository.RegiaoRepository;

@RestController
@RequestMapping("/api")
public class RegiaoController {

	@Autowired
	RegiaoRepository regiaoRepository;
	
	@GetMapping("/regiao")
	public List<Regiao> getRegiao() {
		return regiaoRepository.findAll();	
				
	}
	
	@GetMapping("/regiao/{id}")
	public ResponseEntity<?> getRegiaoById(@PathVariable Long Id) {
		Optional<Regiao> regiaoEscolhidaOptional = regiaoRepository.findById(Id);
		if (regiaoEscolhidaOptional.isPresent()) {
			Regiao regiaoEscolhida = regiaoEscolhidaOptional.get();
			return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/regiao/novo")
	public Regiao putRegiao(@RequestBody Regiao regiao) {
		return regiaoRepository.save(regiao);
	}
	
	@DeleteMapping
	public void deleteRegiao(@PathVariable Long id) {
		regiaoRepository.deleteById(id);
	}
	
}
