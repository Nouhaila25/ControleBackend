package ma.khabbachi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.khabbachi.entities.Servece;
import ma.khabbachi.services.ServiceService;



@RestController
@RequestMapping("/api/v1/services")
//@RequiredArgsConstructor
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
	

	@GetMapping
	public List<Servece> findAllService(){
		return serviceService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Servece service = serviceService.findById(id);
		if(service == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(service);
		}
	}
	
	@PostMapping
	public Servece createService(@RequestBody Servece service) {
		service.setId(0L);
		return serviceService.create(service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id,@RequestBody Servece service) {
//		Filiere filiere = filiereService.findById(id);
		if(serviceService.findById(id) == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			service.setId(id);
			return ResponseEntity.ok(serviceService.update(service));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable Long id){
		Servece service = serviceService.findById(id);
		if(service == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			serviceService.delete(service);
			return ResponseEntity.ok("Service has been deleted");
		}
	}
}
