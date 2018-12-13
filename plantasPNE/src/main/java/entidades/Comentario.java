package entidades;

import java.io.File;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "comentario")
@Entity
public class Comentario implements Identificavel  {

	static private int cont;
	@Id
	private long id;
	private File audio;
	private String texto;
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;

	public Comentario() {
		this.id = cont;
		cont++;
	}

	public Comentario(long id, File audio, String texto, Usuario usuario) {
		super();
		this.id = id;
		this.audio = audio;
		this.texto = texto;
		this.usuario = usuario;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getAudio() {
		return audio;
	}

	public void setAudio(File audio) {
		this.audio = audio;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario clone() {
		return new Comentario(id, audio, texto, usuario);
	}

}
