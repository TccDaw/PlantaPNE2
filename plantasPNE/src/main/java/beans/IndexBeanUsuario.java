package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Usuario;
import servicos.ServiceDacException;
import servicos.UsuarioServices;

@ViewScoped
@Named
public class IndexBeanUsuario implements Serializable {

	@Inject
	private UsuarioServices service;
	private List<Usuario> usuarios;
	private Usuario usuario;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setService(UsuarioServices service) {
		this.service = service;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public UsuarioServices getService() {
		return service;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void adicionarUsu() throws ServiceDacException {
		service.save(usuario);
		usuarios = service.list();
		usuario = new Usuario();
	}

	public void editarUsu() throws ServiceDacException {
		service.update(usuario);
	}

	public void removerUsu() throws ServiceDacException {
		service.delete(usuario);
	}

	public IndexBeanUsuario() {
		usuario = new Usuario();
	}

}
