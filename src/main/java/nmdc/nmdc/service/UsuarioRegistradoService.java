package nmdc.nmdc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nmdc.nmdc.model.UsuarioRegistrado;
import nmdc.nmdc.repository.UsuarioRegistradoRepository;

@Service
public class UsuarioRegistradoService {
private final UsuarioRegistradoRepository repository;
	@Autowired
	public UsuarioRegistradoService(UsuarioRegistradoRepository repository) {
		this.repository=repository;
	}//constructor
public List<UsuarioRegistrado> getUserReg() {
		return repository.findAll();
	}//get UserReg
public UsuarioRegistrado getUserReg(Long id) {
	return repository.findById(id)
			.orElseThrow(()->new IllegalArgumentException("El usuario con el id [" + id + "] no existe"));
}
public UsuarioRegistrado deleteUserReg(Long id) {
	UsuarioRegistrado tmpUserReg=null;
	if (repository.existsById(id)) {
		tmpUserReg=repository.findById(id).orElse(null);
		repository.deleteById(id);
	}
	return tmpUserReg;
}//delete
public UsuarioRegistrado addUserReg(UsuarioRegistrado usuarioRegistrado) {
	Optional<UsuarioRegistrado>userReg=
	repository.findBycorreo(usuarioRegistrado.getCorreo());
	if(userReg.isEmpty()) {
	return repository.save(usuarioRegistrado);
	}else {
		usuarioRegistrado=null;
	}
	return usuarioRegistrado;
}
public UsuarioRegistrado updateUserReg(Long id, String correo, String contrasena) {
	UsuarioRegistrado tmpUserReg=null;
	if(repository.existsById(id)) {
		UsuarioRegistrado UserReg=repository.findById(id).get();
		if(correo!=null)UserReg.setCorreo(correo);
		if(contrasena!=null)UserReg.setContrasena(contrasena);
		repository.save(UserReg);
		tmpUserReg=UserReg;	
	}//if
	return tmpUserReg;
}





}
