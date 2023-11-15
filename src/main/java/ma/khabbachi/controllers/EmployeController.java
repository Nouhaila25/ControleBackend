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

import ma.khabbachi.entities.Employe;
import ma.khabbachi.services.EmployeService;



@RestController
@RequestMapping("/api/v1/employes")
public class EmployeController {
    @Autowired
    private EmployeService service;

    @GetMapping
    public List<Employe> findAllEmployes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
    	Employe employe = service.findById(id);
        if (employe == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

        } else {
            return ResponseEntity.ok(employe);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletEmploye(@PathVariable Long id) {
    	 Employe employe = service.findById(id);
        if (employe == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
        } else {
            service.delete(employe);
            return ResponseEntity.ok("Employe avec id " + id + " suprime");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmploye(@PathVariable Long id, @RequestBody Employe newemploye) {

    	Employe oldEmploye = service.findById(id);
        if (oldEmploye == null) {
            return new ResponseEntity<Object>("Employe avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

        } else {
            newemploye.setId(id);
            return ResponseEntity.ok(service.update(newemploye));
        }
    }

    @PostMapping
    public Employe creatEmploye(@RequestBody Employe employe) {
    	employe.setId(0L);
        return service.create(employe);
    }
}
