package nmdc.nmdc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Inscripcion;
import nmdc.nmdc.model.Usuario;
import nmdc.nmdc.repository.InscripcionRepository;

@Service
public class InscripcionService {
	private InscripcionRepository repository;
	@Autowired
	public InscripcionService(InscripcionRepository repository) {
		this.repository=repository;
	}//constructor
	public List<Inscripcion> getInscription(){
		return repository.findAll();
	}//get
	
	public Inscripcion getInscription(Long id){
		return repository.findById(id).orElseThrow(
				()->new IllegalArgumentException("La inscripcion con el Id[ "+ id
						+"] no existe")	
				);
	}//getInscription
	public Inscripcion deleteInscription(Long id) {
		Inscripcion tmpIns = null;
			if(repository.existsById(id)) {
				tmpIns=repository.findById(id).get();
				repository.deleteById(id);
		}
		return tmpIns;
	}//delete
	public Inscripcion addInscription(Inscripcion inscripcion) {
		Optional<Inscripcion> ins=
				repository.findByFechaInscripcion(inscripcion.getFechaInscripcion());
				if(ins.isEmpty()) {
					repository.save(inscripcion);
				}else {
					inscripcion=null;
				}//else
		return inscripcion;
	}//add
	public Inscripcion updateInscription(Long id, LocalDate fechaInscripcion) {
		Inscripcion tmpIns = null;
			if(repository.existsById(id)) {
				Inscripcion ins=repository.findById(id).get();
				if(fechaInscripcion!=null) ins.setFechaInscripcion(fechaInscripcion);
				repository.save(ins);
				tmpIns = ins;
			}//if
	
		return tmpIns;
	}
	
	

}
