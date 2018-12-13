package servicos;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import util.TransacionalCdi;
import dao.PersistenciaDacException;
import dao.ComentarioDAO;
import entidades.Comentario;

@ApplicationScoped
public class ComentarioServices implements Serializable {

	private static final long serialVersionUID = -7803325791425670859L;

	@Inject
	private ComentarioDAO dao;

	@TransacionalCdi
	public void save(Comentario user) throws ServiceDacException {
		try {
			dao.save(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public void update(Comentario user) throws ServiceDacException {

		try {
			dao.update(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public void delete(Comentario id) throws ServiceDacException {
		try {
			dao.delete(id);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public Comentario getByID(int userId) throws ServiceDacException {
		try {
			return dao.getByID(userId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}
}
