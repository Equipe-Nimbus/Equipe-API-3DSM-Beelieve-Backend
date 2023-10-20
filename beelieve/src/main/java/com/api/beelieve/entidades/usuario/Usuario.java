package com.api.beelieve.entidades.usuario;

import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column
	private String nome;
	
	@Column
	private String matricula;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private String cargo;
	
	@Column
	private String departamento;

	public Usuario(){
		
	}
	
	public Usuario(DadosUsuarioCadastro dadosUsuario) {
		this.nome = dadosUsuario.nome();
		this.matricula = dadosUsuario.matricula();
		this.email = dadosUsuario.email();
		this.senha = dadosUsuario.senha();
		this.cargo = dadosUsuario.cargo();
		this.departamento = dadosUsuario.departamento();
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}