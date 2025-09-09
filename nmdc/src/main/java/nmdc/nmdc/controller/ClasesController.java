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

import nmdc.nmdc.model.Clases;
import nmdc.nmdc.service.ClasesService;

@RestController
@RequestMapping(path="/api/clases/")//http:localhost:8080/api/clases/
public class ClasesController {

private final nmdc.nmdc.service.ClasesService service;
@Autowired
public ClasesController(ClasesService service) {
	this.service=service;
}//get
@GetMapping
public List<Clases>getClases(){
	return service.getClas();
}//getUser
@GetMapping(path="{clasId}")//http:localhost:8080/api/clases/1
public Clases getClases(@PathVariable("clasId") Long id) {
	return service.getClas(id);
}
@DeleteMapping(path="{clasId}")
public Clases deleteClases(@PathVariable("clasId") Long id) {
	return service.deleteClas(id);
}//delete
@PostMapping
public Clases addClases(@RequestBody Clases clases) {
	return service.addClas(clases);
}
@PutMapping(path="{clasId}")
		public Clases updateClases(@PathVariable("clasId") Long id,
		@RequestParam(required=false) String nombreClases,
		@RequestParam(required=false) String ededAdmision,
		@RequestParam(required=false) String horario) {
		return service.updateClas(id,nombreClases,ededAdmision, horario);
}
}
