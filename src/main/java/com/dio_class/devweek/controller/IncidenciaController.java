package com.dio_class.devweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entity.Incidencia;
import com.dio_class.devweek.repository.IncidenciaRepository;

@RestController
@RequestMapping("/api")
public class IncidenciaController {

	@Autowired
	IncidenciaRepository incidenciaRepository;

	@GetMapping("/ocorrencias")
	public ResponseEntity<List<Incidencia>> findOcorrencias() {
		List<Incidencia> listaOcorrencia = incidenciaRepository.findAll();
		if (listaOcorrencia.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
	}

	@GetMapping("/ocorrencia/{id}")
	public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id) {
		Optional<Incidencia> ocorrenciaOptional = incidenciaRepository.findById(id);
		if (ocorrenciaOptional.isPresent()) {
			Incidencia ocorrenciaUnid = ocorrenciaOptional.get();
			return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
