package nmdc.nmdc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nmdc.nmdc.model.Maestros;
import nmdc.nmdc.service.MaestrosService;

@RestController
@RequestMapping(path="/api/maestros/")//http:localhost:8080/api/maestros/
public class MaestrosController {
	
	private final MaestrosService service;
	@Autowired
	public MaestrosController(MaestrosService service) {
		this.service = service;
	}
	@GetMapping
	public List<Maestros> getMaestros(){
		return service.getTeacher();
	}//getTeacher
	@GetMapping(path="{useT}")
	public Maestros getMaestros(@PathVariable("useT") Long id){
		return service.getTeacher(id);
	}
	@DeleteMapping (path="{useT}")
	public Maestros deleteMaestros(@PathVariable("useT") Long id){
		return service.deleteTeacher(id);
	}//deleteTeacher
	@PostMapping 
	public Maestros addMaestros(@RequestBody Maestros maestro){
		return service.addTeacher(maestro);
	}//addteacher
	@PutMapping(path="{useT}")
	public Maestros putMaestros(@PathVariable("useT") Long id, 
	@RequestParam (required=false) String nombre,
	@RequestParam (required=false) String apellido,
	@RequestParam (required=false) String telefono,
	@RequestParam (required=false) String redSocial) {
		return service.updateTeacher(id, nombre,apellido,telefono,redSocial);
	}
}
