package nmdc.nmdc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Clases;
import nmdc.nmdc.repository.ClasesRepository;

@Service
public class ClasesService {
private  ClasesRepository repository;

@Autowired
public ClasesService (ClasesRepository repository) {
	this.repository=repository;
}//constructor
public List <Clases>getClas(){
	return repository.findAll();
}//getuser
public Clases getClas(Long id) {
	return repository.findById(id).orElseThrow(
			()->new IllegalArgumentException("La clase  con el Id[ "+ id
					+"] no existe"));
}//getclas
public Clases deleteClas(Long id) {
	Clases tmpcl=null;
	if(repository.existsById(id)) {
		tmpcl=repository.findById(id).get();
		repository.deleteById(id);
	}
	return tmpcl;
}//delete
public Clases addclas(Clases clases) {
	Optional<Clases> clas=
	repository.findByNombreClases(clases.getNombreClases());
	if(clas.isEmpty()) {
		repository.save(clases);
	}else {
		clases=null;
	}//else
	return clases;

}//add
public Clases updateclas(Long id, String imagen, String nombreClases, String edadAdmision, String maestro,
		String horario, String claseSuelta, String inscripcion) {
	Clases tmpcl=null;
	if(repository.existsById(id)) {
		Clases cl=repository.findById(id).get();
		if(imagen!=null)cl.setImagen(imagen);
		if(nombreClases!=null)cl.setNombreClases(nombreClases);
		if(edadAdmision!=null)cl.setEdadAdmision(edadAdmision);
		if(maestro!=null)cl.setMaestro(maestro);
		if(horario!=null)cl.setHorario(horario);
		if(claseSuelta!=null)cl.setClaseSuelta(claseSuelta);
		if(inscripcion!=null)cl.setInscripcion(inscripcion);
		repository.save(cl);
		 tmpcl=cl;
	}
	
	return tmpcl;
}



}
