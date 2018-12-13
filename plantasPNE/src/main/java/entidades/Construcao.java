package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Construcao implements Identificavel {

	static private int cont;
	@Id
	private long id;
	private String finalidade;
	private String endereco;
	private String nome;
	@OneToOne
	@JoinColumn(name = "id")
	private Usuario dono;
	@OneToOne
	@JoinColumn(name = "id")
	private Planta planta;

	public Construcao() {
		this.id = cont;
		cont++;
	}

	public Construcao(long id, String finalidade, String endereco, String nome, Usuario dono, Planta planta) {
		this.id = id;
		this.finalidade = finalidade;
		this.endereco = endereco;
		this.nome = nome;
		this.dono = dono;
		this.planta = planta;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Construcao clone() {
		return new Construcao(id, finalidade, endereco, nome, dono, planta);
	}

}
