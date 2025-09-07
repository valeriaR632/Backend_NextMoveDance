package nmdc.nmdc.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Maestros;
import nmdc.nmdc.repository.MaestrosRepository;
@Service
public class MaestrosService {
	private MaestrosRepository repository;
	@Autowired
	public MaestrosService(MaestrosRepository repository) {
		this.repository=repository;
	}//constructor
	public List<Maestros> getTeacher(){
		return repository.findAll();
	}//getTeacher
	public Maestros getTeacher(Long id) {
		return repository.findById(id).orElseThrow(
		()->new IllegalArgumentException("El maestro con el Id[ "+ id
						+"] no existe")
				);
		
	}//get
	public Maestros deleteTeacher(Long id) {
		Maestros tmpTea = null;
	        if(repository.existsById(id)) {
	        	tmpTea=repository.findById(id).get();
	        	repository.deleteById(id);
	    }
	    return tmpTea;
	}//delete
	public Maestros addTeacher(Maestros maestro) {
		Optional<Maestros>tea=
	    repository.findByNombre(maestro.getNombre());
		if(tea.isEmpty()) {
			repository.save(maestro);
		}else {
			maestro=null;
		}//else
		return maestro;
	}//add
	
	public Maestros updateTeacher(Long id, String nombre, String apellido, String telefono, String redSocial) {
		Maestros tmpTea=null;
		if(repository.existsById(id)){
		Maestros tea=repository.findById(id).get();
		if(nombre!=null)tea.setNombre(nombre);
		if(apellido!=null)tea.setApellido(apellido);
		if(telefono!=null)tea.setTelefono(telefono);
		if(redSocial!=null)tea.setRedSocial(redSocial);
		repository.save(tea);
		tmpTea=tea;
	}
		return tmpTea;
	}//update
}//class