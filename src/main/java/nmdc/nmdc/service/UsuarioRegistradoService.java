package nmdc.nmdc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nmdc.nmdc.dto.ChangeContrasena;
import nmdc.nmdc.model.UsuarioRegistrado;
import nmdc.nmdc.repository.UsuarioRegistradoRepository;

@Service
public class UsuarioRegistradoService {
private final UsuarioRegistradoRepository repository;

@Autowired
private PasswordEncoder encoder;	
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
	repository.findByCorreo(usuarioRegistrado.getCorreo());
	if(userReg.isEmpty()) {
		usuarioRegistrado.setContrasena(encoder.encode (usuarioRegistrado.getContrasena()));
	return repository.save(usuarioRegistrado);
	}else {
		usuarioRegistrado=null;
	}
	return usuarioRegistrado;
}//add

public UsuarioRegistrado updateUserReg(Long id, ChangeContrasena changecontrasena) {
	UsuarioRegistrado tmpUserReg=null;
	if(repository.existsById(id)) {
		tmpUserReg=repository.findById(id).get();
		if(tmpUserReg.getContrasena().equals(changecontrasena.getContrasena())) {
			return repository.save(tmpUserReg);
		}else {
			tmpUserReg=null;
		}
	}
	return null;
}
public boolean validateUserReg(UsuarioRegistrado usuarioRegistrado) {
    Optional<UsuarioRegistrado> userReg = repository.findByCorreo(usuarioRegistrado.getCorreo());
    if (userReg.isPresent()) {
        UsuarioRegistrado tmpUserReg = userReg.get();
        if (encoder.matches(usuarioRegistrado.getContrasena(), tmpUserReg.getContrasena())) {
            return true;
        }
    }
    return false;
}
}
