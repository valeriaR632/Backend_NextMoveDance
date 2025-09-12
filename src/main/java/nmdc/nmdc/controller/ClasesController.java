package nmdc.nmdc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nmdc.nmdc.model.Clases;
import nmdc.nmdc.service.ClasesService;

@CrossOrigin(origins = "http://127.0.0.1:5502")
@RestController
@RequestMapping(path="/api/clases/")
public class ClasesController {
	private final ClasesService service;
	@Autowired
	public ClasesController(ClasesService service) {
		this.service=service;
	}
	@GetMapping
	public List<Clases>getClases(){
		return service.getClas();
	}//get
	@GetMapping (path="{claId}")
	public Clases getClases(@PathVariable("claId") Long id) {
		return service.getClas(id);
	}
	
	@DeleteMapping(path="{claId}")
	public Clases deleteClases(@PathVariable("claId") Long id) {
		return service.deleteClas(id);
	}
	@PostMapping
	public Clases addClases(@RequestBody Clases clases) {
		return service.addclas(clases);
	}
	@PutMapping(path="{claId}")
	public Clases updateClases(@PathVariable("claId") Long id,
	@RequestParam (required=false) String imagen,
	@RequestParam (required=false) String nombreClases,
	@RequestParam (required=false) String edadAdmision,
	@RequestParam (required=false) String maestro,
	@RequestParam (required=false) String horario,
	@RequestParam (required=false) String claseSuelta,
	@RequestParam (required=false) String inscripcion) {
		return service.updateclas(id,imagen,nombreClases,edadAdmision,maestro,horario,claseSuelta,inscripcion);
	}
	

}
