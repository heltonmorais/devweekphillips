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
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entity.FaixaEtaria;
import com.dio_class.devweek.repository.FaixaEtariaRepository;

@RestController
public class FaixaEtariaController {

	@Autowired
	FaixaEtariaRepository faixaEtariaRepository;

	@GetMapping("/faixaetaria")
	public ResponseEntity<?> findAllFaixaEtaria() {
		try {
			List<FaixaEtaria> lista = faixaEtariaRepository.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id) {
		try {
			Optional<FaixaEtaria> unidOptional = faixaEtariaRepository.findById(id);
			if (unidOptional.isPresent()) {
				FaixaEtaria faixaEtariaUnid = unidOptional.get();
				return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/faixaetaria/novo")
	public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria) {
		return faixaEtariaRepository.save(faixaEtaria);
	}

	@DeleteMapping("/faixaetaria/remover/{id}")
	public void deleteFaixaEtaria(@PathVariable Long id) {
		faixaEtariaRepository.deleteById(id);
	}

}
