package com.Mais_Saude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="permissoes", schema = "mais_saude")
public class PermissoesModel {

@Id
@Column(name ="id")
private Long id;

@Column(name ="descricao")
private String descricao;
	
	
}
