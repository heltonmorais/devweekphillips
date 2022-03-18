package com.dio_class.devweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regiao")
public class Regiao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	private String regiao;
	
	private Long qnt_exames;

			
	public Regiao(Long id, String regiao, Long qnt_exames) {	
		this.regiao = regiao;
		this.qnt_exames = qnt_exames;
	}

	public Long getId() {
		return id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Long getQnt_exames() {
		return qnt_exames;
	}

	public void setQnt_exames(Long qnt_exames) {
		this.qnt_exames = qnt_exames;
	}
	
	public Regiao() {
		
	}
	
}
