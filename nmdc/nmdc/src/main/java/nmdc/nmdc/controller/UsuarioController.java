package nmdc.nmdc.controller;
import java.util.List;

import nmdc.nmdc.service.UsuarioService;
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

import nmdc.nmdc.model.Usuario;


@RestController
@RequestMapping(path="/api/usuario/")//http:localhost:8080/api/usuario/
public class UsuarioController {
	private final UsuarioService service;
	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service= service;
	}//get
	@GetMapping
	public  List<Usuario>getUsuario(){
		return service.getUser();
	}//getUser
	
	@GetMapping(path="{useId}")//http:localhost:8080/api/usuario/1
	public Usuario getUsuario(@PathVariable("useId") Long id) {
		return service.getUser(id);
	}
	@DeleteMapping(path="{useId}")//http:localhost:8080/api/usuario/1
	public Usuario deleteUsuario(@PathVariable("useId") Long id) {
		return service.deleteUser(id);
}//deleteUser
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return service.addUser(usuario);
}//addUser
	@PutMapping(path="{useId}")//http:localhost:8080/api/usuario/1
	public Usuario updateUsuario(@PathVariable("useId") Long id,
	@RequestParam (required=false) String nombre,
	@RequestParam (required=false) String apellido,
	@RequestParam (required=false) String telefono,
	@RequestParam (required=false) String correo,
	@RequestParam (required=false) String fechaRegistro) {
		return service.updateUser(id,nombre,apellido,telefono,correo,fechaRegistro);
		
	}
}