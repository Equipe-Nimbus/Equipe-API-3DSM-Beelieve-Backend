package com.api.beelieve.entidades.usuario;

import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@ToString
@Table(name = "usuario")
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column
	private String nome;
	
	@Column
	private String matricula;
	
	@Column
	private String cpf;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private String cargo;
	
	@Column
	private String departamento;
	
	@Column
	private String telefone;
	
	@Column
	private Boolean is_active;

	public Usuario(){
		
	}
	
	public Usuario(DadosUsuarioCadastro dadosUsuario) {
		this.nome = dadosUsuario.nome();
		this.matricula = dadosUsuario.matricula();
		this.cpf = dadosUsuario.cpf();
		this.email = dadosUsuario.email();
		this.senha = dadosUsuario.senha();
		this.cargo = dadosUsuario.cargo();
		this.departamento = dadosUsuario.departamento();
		this.telefone = dadosUsuario.telefone();
		this.is_active = dadosUsuario.is_active();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}