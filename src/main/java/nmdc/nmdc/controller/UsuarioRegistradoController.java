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

import nmdc.nmdc.dto.ChangeContrasena;
import nmdc.nmdc.model.UsuarioRegistrado;
import nmdc.nmdc.service.UsuarioRegistradoService;

@RestController
@RequestMapping (path="/api/usuarioRegistrado/")
public class UsuarioRegistradoController {
private final UsuarioRegistradoService service;
@Autowired
public UsuarioRegistradoController(UsuarioRegistradoService service) {
	this.service=service;
}//get
@GetMapping
public List<UsuarioRegistrado>getUsuarioRegistrado(){
	return service.getUserReg();
}//getUserReg
@GetMapping(path="{UserRegId}")
public UsuarioRegistrado getUsuarioRegistrado(@PathVariable("UserRegId") Long id) {
	return service.getUserReg(id);
}//getUserReg
@DeleteMapping(path="{UserRegId}")
public UsuarioRegistrado deleteUsuarioRegistrado(@PathVariable ("UserRegId") Long id) {
	return service.deleteUserReg(id);
}
@PostMapping
public UsuarioRegistrado addUsuarioRegistrado(@RequestBody UsuarioRegistrado usuarioRegistrado) {
	return service.addUserReg(usuarioRegistrado);
}//add
@PutMapping(path="{UserRegId}")
public  UsuarioRegistrado updateUsuarioRegistrado(@PathVariable ("UserRegId") Long id, 
	@RequestBody ChangeContrasena changecontrasena) {
		return service.updateUserReg(id, changecontrasena);

}

}
