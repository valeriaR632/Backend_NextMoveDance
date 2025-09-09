package nmdc.nmdc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Clases;
import nmdc.nmdc.model.Usuario;
import nmdc.nmdc.repository.ClasesRepository;
@Service
public class ClasesService {
private ClasesRepository repository;
@Autowired
public ClasesService(ClasesRepository repository) {
	this.repository=repository;
	
}//constructor
public List<Clases>getClas(){
	return repository.findAll();
}//getUser
public Clases getClas(Long id) {
	return repository.findById(id).orElseThrow(
	()->new IllegalArgumentException("La clase con el Id[ "+ id
					+"] no existe")
			);
}//get clas
public Clases deleteClas(Long id) {
	Clases tmpCl=null;
	
		if(repository.existsById(id)) {
			tmpCl=repository.findById(id).get();
			repository.deleteById(id);
	}
	return tmpCl;
}
public Clases addClas(Clases clases) {
	Optional<Clases> cl=
	repository.findByNombreClases(clases.getNombreClases());
	if(cl.isEmpty()) {
		repository.save(clases);
	}else {
		clases=null;
	}//else
	return clases;
}//addclases
public Clases updateClas(Long id, String nombreClases, String ededAdmision, String horario) {
	Clases tmpCl=null;
		if(repository.existsById(id)) {
			Clases cl=repository.findById(id).get();
			
			if(nombreClases!=null)cl.setNombreClases(nombreClases);
			if(ededAdmision!=null)cl.setEdedAdmision(ededAdmision);
			if(horario!=null)cl.setHorario(horario);
			repository.save(cl);
			tmpCl=cl;
	}//if
	return tmpCl;
}//update

}
