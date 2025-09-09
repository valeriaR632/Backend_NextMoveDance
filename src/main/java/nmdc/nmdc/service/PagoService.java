package nmdc.nmdc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nmdc.nmdc.model.Pago;
import nmdc.nmdc.repository.PagoRepository;

@Service
public class PagoService {
	private PagoRepository repository;
	@Autowired
	public PagoService(PagoRepository repository) {
		this.repository=repository;
	}//constructor
	public List<Pago> getPayment(){
		return repository.findAll();
	}//getPago
	public Pago getPayment(Long id) {
		return repository.findById(id).orElseThrow(
	()->new IllegalArgumentException("El pago con el Id[ "+ id
						+"] no existe")
				);
	}
	public Pago deletePayment(Long id) {
		Pago tmpCash = null;
	        if(repository.existsById(id)) {
	            tmpCash = repository.findById(id).get();
	            repository.deleteById(id);
	        }
	    return tmpCash;
		
	}
	public Pago addPayment(Pago pago) {
		Optional<Pago> pa=
		repository.findByFechaPago(pago.getFechaPago());
		if(pa.isEmpty()) {
		repository.save(pago);
		}else {
		pago=null;
		}//else
		return pago;
	}
	
	public Pago updatePayment(Long id, String costo, String paquete, String fechaPago) {
		Pago tmpPayment=null;
			if(repository.existsById(id)) {
				Pago pa=repository.findById(id).get();
				if(costo!=null)pa.setCosto(costo);
				if(paquete!=null)pa.setPaquete(paquete);
				if(fechaPago!=null)pa.setFechaPago(fechaPago);
				repository.save(pa);
				tmpPayment=pa;	
			}//if
		return tmpPayment;
	}

}
