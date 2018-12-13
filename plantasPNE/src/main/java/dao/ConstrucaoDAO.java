package dao;

import java.util.List;
import javax.persistence.Query;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import entidades.Construcao;

@ApplicationScoped
public class ConstrucaoDAO {

	@Inject
	private EntityManager manager;

	public void save(Construcao construcao) throws PersistenciaDacException {
		if (construcao.getId() == null) {
			manager.persist(construcao);
		} else {
			update(construcao);
		}
	}

	public Construcao update(Construcao construcao) throws PersistenciaDacException {
		Construcao resultado = construcao;
		resultado = manager.merge(construcao);
		return resultado;
	}

	public void delete(Construcao construcao) throws PersistenciaDacException {
		construcao = getByID(construcao.getId());
		manager.remove(construcao);
	}

	public Construcao getByID(long construcaoId) throws PersistenciaDacException {
		return manager.find(Construcao.class, construcaoId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Construcao> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Construcao", Construcao.class);
		return query.getResultList();
	}
}