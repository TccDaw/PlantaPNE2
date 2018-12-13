package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity
public class Usuario implements Identificavel {

	static private int cont;

	@Id
	private long id;
	private String nome;
	private String deficiente;
	private String email;
	private String senha;
	private String username;
	private String password;
	private String grupo;

	public Usuario() {
		this.id = cont;
		cont++;
	}

	public Usuario(long id, String nome, String deficiente, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.deficiente = deficiente;
		this.email = email;
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDeficiente() {
		return deficiente;
	}

	public void setDeficiente(String deficiente) {
		this.deficiente = deficiente;
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

	public Usuario clone() {
		return new Usuario(id, nome, deficiente, email, senha);
	}

}
