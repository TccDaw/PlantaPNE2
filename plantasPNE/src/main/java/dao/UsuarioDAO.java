package dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Usuario;
import util.TransacionalCdi;


@ApplicationScoped
public class UsuarioDAO {

	@Inject
	private EntityManager manager;

	public void save(Usuario usuario) throws PersistenciaDacException {
		if (usuario.getId() == null) {
			manager.persist(usuario);
		} else {
			update(usuario);
		}
	}

	public Usuario update(Usuario usuario) throws PersistenciaDacException {
		Usuario resultado = usuario;
		resultado = manager.merge(usuario);
		return resultado;
	}

	@TransacionalCdi
	public void delete(Usuario usuario) throws PersistenciaDacException {
		usuario = getByID(usuario.getId());
		manager.remove(usuario);
	}

	public Usuario getByID(long usuarioId) throws PersistenciaDacException {
		return manager.find(Usuario.class, usuarioId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
}
