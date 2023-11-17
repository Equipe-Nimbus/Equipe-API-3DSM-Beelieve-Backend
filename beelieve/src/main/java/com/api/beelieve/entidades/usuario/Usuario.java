package com.api.beelieve.entidades.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD

import com.api.beelieve.entidades.analista_projeto.Analista_Projeto;

=======
>>>>>>> bb28bbcf66210be8300d49e95906445916461fce
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.beelieve.configuracoes.seguranca.Perfil;
import com.api.beelieve.entidades.nivelsubprojeto.NivelSubProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.usuario.dto.DadosUsuarioCadastro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
<<<<<<< HEAD
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
=======
import lombok.ToString;

@Entity
@ToString
>>>>>>> bb28bbcf66210be8300d49e95906445916461fce
@Data
@Table(name = "usuario")
public class Usuario implements UserDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

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
	
	@OneToMany(mappedBy = "chefe_projeto")
	private List<Projeto> projetosChefiados;
	
	@OneToMany(mappedBy = "chefe_sub_projeto")
	private List<SubProjeto> subProjetosAtrelados;
	
<<<<<<< HEAD

	@OneToMany(mappedBy = "analista")
	private List<Analista_Projeto> projetosAtribuidosAnalista;

	
	@ElementCollection
	private List<Perfil> listaPerfil = new ArrayList<>();

=======
	@ManyToMany
	@JoinTable(
			name="atribuicao_analista",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_projeto")
			)
	private List<Projeto> projetosAtribuidos;
	
	@ElementCollection
	private List<Perfil> listaPerfil = new ArrayList<>();
>>>>>>> bb28bbcf66210be8300d49e95906445916461fce

	public Usuario(){
		
	}
	
	public Usuario(DadosUsuarioCadastro dadosUsuario) {
		this.nome = dadosUsuario.nome();
		this.matricula = dadosUsuario.matricula();
		this.cpf = dadosUsuario.cpf();
		this.email = dadosUsuario.email();
		this.senha = new BCryptPasswordEncoder().encode(dadosUsuario.senha());
		this.cargo = dadosUsuario.cargo();
		this.departamento = dadosUsuario.departamento();
		this.telefone = dadosUsuario.telefone();
		this.is_active = dadosUsuario.is_active();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> listaAutorizacao = new ArrayList<>();
		for (Perfil perfil : this.listaPerfil) {
			SimpleGrantedAuthority autorizacao = new SimpleGrantedAuthority(perfil.toString());
			listaAutorizacao.add(autorizacao);
		}
		return listaAutorizacao;
		//return List.of(new SimpleGrantedAuthority("Role_User"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}