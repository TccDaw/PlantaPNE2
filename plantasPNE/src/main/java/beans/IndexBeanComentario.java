package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import entidades.Comentario;
import servicos.ComentarioServices;
import servicos.ServiceDacException;

@Named
@SessionScoped
public class IndexBeanComentario {

	@Inject
	private ComentarioServices service;
	private Comentario comentario;

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public void adicionarComentario() throws ServiceDacException {
		service.save(comentario);
		comentario = new Comentario();
	}

	public void editarComentario(Integer id) throws ServiceDacException {
		service.update(comentario);
	}

	public void removerComentario() throws ServiceDacException {
		service.delete(comentario);
	}

	public IndexBeanComentario() {
		comentario = new Comentario();
	}

}
