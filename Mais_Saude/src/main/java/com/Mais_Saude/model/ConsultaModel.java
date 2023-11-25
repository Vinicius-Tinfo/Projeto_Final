package com.Mais_Saude.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consulta", schema = "mais_saude")
public class ConsultaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "id_usuario")
	private String id_usuario;
	
	@Column(name = "id_paciente")
	private String id_paciente;
	
	@Column(name = "sintomas")
	private String sintomas;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "prontuario")
	private String prontuario;

	@Column(name = "nome_medico")
	private String nome_medico;
	
	@Column(name = "cpf_paciente")
	private String cpf;
	
	public Long getId() {
		return id;
	}

	public String getNome_medico() {
		return nome_medico;
	}

	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(String id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
}
