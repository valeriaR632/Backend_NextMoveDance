package nmdc.nmdc.controller;

import java.time.LocalDate;
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

import nmdc.nmdc.model.Inscripcion;
import nmdc.nmdc.service.InscripcionService;

@RestController
@RequestMapping(path="/api/inscripcion")
public class InscripcionController {
	private final InscripcionService service;
	@Autowired
	public InscripcionController(InscripcionService service) {
		this.service = service;
	}//get
	
	@GetMapping
	public List<Inscripcion> getInscripcion(){
		return service.getInscription();
	}
	@GetMapping(path= "{insId}")
	public Inscripcion getInscripcion(@PathVariable("insId") Long id){
		return service.getInscription(id);
}
	@DeleteMapping(path="{insId}")
	public Inscripcion deleteInscripcion(@PathVariable("insId") Long id) {
		return service.deleteInscription(id);
	}
	@PostMapping
	public Inscripcion addInscripcion(@RequestBody Inscripcion inscripcion) {
		return service.addInscription(inscripcion);
	}//add
	@PutMapping(path="{insId}")
	public Inscripcion updateInscripcion(@PathVariable("insId") Long id,
			@RequestParam(required=false) LocalDate fechaInscripcion) {
		return service.updateInscription(id,fechaInscripcion);
	}
	
}
