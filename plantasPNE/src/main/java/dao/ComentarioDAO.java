package dao;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Comentario;

@ApplicationScoped
public class ComentarioDAO {

	@Inject
	private EntityManager manager;
	
	public void save(Comentario comentario) throws PersistenciaDacException {
		if (comentario.getId() == null) {
			manager.persist(comentario);
		} else {
			update(comentario);
		}
	}

	public Comentario update(Comentario comentario) throws PersistenciaDacException {
		Comentario resultado = comentario;
		resultado = manager.merge(comentario);
		return resultado;
	}

	public void delete(Comentario comentario) throws PersistenciaDacException {
		comentario = getByID(comentario.getId());
		manager.remove(comentario);
	}

	public Comentario getByID(long comentarioId) throws PersistenciaDacException {
		return manager.find(Comentario.class, comentarioId);
	}

	@SuppressWarnings("unchecked")
	public List<Comentario> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Comentario", Comentario.class);
		return query.getResultList();
	}
}
