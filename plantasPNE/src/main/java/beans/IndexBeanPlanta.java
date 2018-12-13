package beans;

import java.util.Date;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Planta;
import servicos.PlantaServices;
import servicos.ServiceDacException;

@Named
@SessionScoped
public class IndexBeanPlanta {

	@Inject
	private PlantaServices service;
	private Planta planta;

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public void adicionarPlanta() throws ServiceDacException {
		service.save(planta);
		planta = new Planta();
	}

	public void editarPlanta() throws ServiceDacException {
		service.update(planta);
	}

	public void removerPlanta() throws ServiceDacException {
		service.delete(planta);
	}

	public IndexBeanPlanta() {
		planta = new Planta();
		Date data = new Date(System.currentTimeMillis());
		// InputStream stream =
		// FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg");
		// file = new DefaultStreamedContent(stream, "image/jpg",
		// "downloaded_boromir.jpg");
	}

	// public StreamedContent getFile() {
	// return file;
	// }
}
