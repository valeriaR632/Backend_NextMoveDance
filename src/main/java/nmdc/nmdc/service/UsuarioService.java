package nmdc.nmdc.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Usuario;
import nmdc.nmdc.repository.UsuarioRepository;
@Service
public class UsuarioService {
	private UsuarioRepository repository;
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository=repository;
	}//constructor
	public List<Usuario>getUser(){
		return repository.findAll();
	}//getUser
	public Usuario getUser(Long id) {
		return repository.findById(id).orElseThrow(
	()->new IllegalArgumentException("El ususario con el Id[ "+ id
			+"] no existe")
				);
	}//getUser
	public Usuario deleteUser(Long id) {
		Usuario tmpUse=null;
		if(repository.existsById(id)) {
			tmpUse=repository.findById(id).get();
			repository.deleteById(id);
			
		}
		return tmpUse;
	}//deleteUser
	public Usuario addUser(Usuario usuario) {
		Optional<Usuario> user=
		repository.findByNombre(usuario.getNombre());
		if(user.isEmpty()) {
			repository.save(usuario);
		}else {
			usuario=null;
		}//else
		return usuario;
	}//addUser
	public Usuario updateUser(Long id, String nombre, String apellido, String telefono, String correo,
			String fechaRegistro) {
		Usuario tmpUser=null;
			if(repository.existsById(id)) {
				Usuario use=repository.findById(id).get();
				if(nombre!=null)use.setNombre(nombre);
				if(apellido!=null)use.setApellido(apellido);
				if(telefono!=null)use.setTelefono(telefono);
				if(correo!=null)use.setCorreo(correo);
				if(fechaRegistro!=null)use.setFechaRegistro(fechaRegistro);
				repository.save(use);
				tmpUser=use;
		}//foreach
		return tmpUser;
	}
}
