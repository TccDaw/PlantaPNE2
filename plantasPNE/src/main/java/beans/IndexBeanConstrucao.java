package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Construcao;
import servicos.ConstrucaoServices;
import servicos.ServiceDacException;

@Named
@SessionScoped
public class IndexBeanConstrucao {

	@Inject
	private ConstrucaoServices service;
	private Construcao construcao;

	public Construcao getConstrucao() {
		return construcao;
	}

	public void setConstrucao(Construcao construcao) {
		this.construcao = construcao;
	}

	public void adicionarConstrucao() throws ServiceDacException {
		service.save(construcao);
		construcao = new Construcao();
	}

	public void editarConstrucao() throws ServiceDacException {
		service.update(construcao);
	}

	public void removerConstrucao() throws ServiceDacException {
		service.delete(construcao);
	}

	public IndexBeanConstrucao() {
		construcao = new Construcao();
	}

}
