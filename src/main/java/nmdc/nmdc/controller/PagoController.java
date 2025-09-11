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

import nmdc.nmdc.model.Pago;
import nmdc.nmdc.service.PagoService;

@RestController
@RequestMapping(path="/api/pago/")
public class PagoController {
	private final PagoService service;
	@Autowired
	public PagoController(PagoService service) {
		this.service =service;
	}
	@GetMapping
	public  List<Pago>getPago(){
		return service.getPayment();
	}
	@GetMapping(path="{paId}")
	public Pago getPago(@PathVariable("paId") Long id){
		return service.getPayment(id);
	}
	@DeleteMapping(path="{paId}")
	public Pago deletePago(@PathVariable("paId") Long id){
		return service.deletePayment(id);
	}
	@PostMapping
	public Pago addPayment(@RequestBody Pago pago) {
		return service.addPayment(pago);
	}
	@PutMapping (path="{paId}")
	public Pago updatePago(@PathVariable("paId")Long id,
			@RequestParam ( required=false) String costo,
			@RequestParam ( required=false) String paquete,
			@RequestParam ( required=false) String fechaPago) {
		return service.updatePayment(id, costo, paquete, fechaPago);
}


}
