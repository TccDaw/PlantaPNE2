package dao;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import entidades.Planta;
import util.TransacionalCdi;

@ApplicationScoped
public class PlantaDAO {

	@Inject
	private EntityManager manager;

	@TransacionalCdi
	public void save(Planta planta) throws PersistenciaDacException {
		if (planta.getId() == null) {
			manager.persist(planta);
		} else {
			update(planta);
		}
	}

	@TransacionalCdi
	public Planta update(Planta planta) throws PersistenciaDacException {
		Planta resultado = planta;
		resultado = manager.merge(planta);
		return resultado;
	}

	@TransacionalCdi
	public void delete(Planta planta) throws PersistenciaDacException {
		planta = getByID(planta.getId());
		manager.remove(planta);
	}

	public Planta getByID(long plantaId) throws PersistenciaDacException {
		return manager.find(Planta.class, plantaId);
	}

	@SuppressWarnings("unchecked")
	public List<Planta> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Planta", Planta.class);
		return query.getResultList();
	}
}
