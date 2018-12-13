package daw;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import entidades.Planta;
import servicos.PlantaServices;

@Path("/user")
public class PlantaServiceRS {

	@Inject
	private PlantaServices plantaService;
	
	// http://localhost:8080/ifoto/rest/user/nome/1
	@GET
	@Path("/nome/{id}")
	@Produces("text/html")
	public String getNome(@PathParam("id") Long id) {
		return "<h1>"+plantaService.getByID(id).getNome()+"</h1>";
	}
	// http://localhost:8080/ifoto/rest/user/list
	@GET
	@Path("/list")
	@Produces("text/html")
	public String list() {
		String retorno = "<ul>";
		List<Planta> users = plantaService.getAll();
		for(Planta u: users) {
			retorno += "<li>"+u.getNome()+"</li>";
		}
		return retorno + "</ul>";
	}
	
	// http://localhost:8080/ifoto/rest/user/add/user;nome=Hugo%20Feitosa;password=123;id=3;email=hg@hg.com;username=hugoff
	@GET
	@Path("/add/{user}")
	public String add(@PathParam("user") PathSegment atributos) {
		MultivaluedMap<String, String> matrixParameters = atributos.getMatrixParameters();
		String nome = matrixParameters.getFirst("nome");
		String email = matrixParameters.getFirst("email");
		String id = matrixParameters.getFirst("id");
		String password = matrixParameters.getFirst("password");
		String username = matrixParameters.getFirst("username");
		Planta u = new Planta();
		u.setEmail(email);
		u.setGrupo("OUTROS");
		u.setId(Long.parseLong(id));
		u.setNome(nome);
		u.setPassword(password);
		u.setUsername(username);
		plantaService.save(u);
		return "Salvo com sucesso";
	}
	
	public PlantaServices getPlantaService() {
		return plantaService;
	}
	
	public void setPlantaService(PlantaServices plantaService) {
		this.plantaService = plantaService;
	}
	
}