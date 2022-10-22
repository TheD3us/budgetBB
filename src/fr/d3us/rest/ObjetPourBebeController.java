package fr.d3us.rest;


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

import fr.d3us.bll.ObjetPourBebeBll;
import fr.d3us.bo.ObjetPourBebe;



@RestController
@RequestMapping("/objetbebe")
public class ObjetPourBebeController {
	@Autowired
	private ObjetPourBebeBll bll;
	
	@GetMapping
	public ResponseEntity<List<ObjetPourBebe>> findAll() {
		List<ObjetPourBebe> forms = bll.selectAll();
		return new ResponseEntity<List<ObjetPourBebe>>(forms, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObjetPourBebe> findById(@PathVariable("id") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<ObjetPourBebe>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<ObjetPourBebe>(HttpStatus.NOT_FOUND);
		}
	
	}

	@PostMapping
	public ResponseEntity<ObjetPourBebe> insert(@RequestBody ObjetPourBebe objetPourBebe) {
		try {
			System.out.println("Coucou je fonctionne");
			bll.insert(objetPourBebe);
			return new ResponseEntity<ObjetPourBebe>(objetPourBebe, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ObjetPourBebe>(HttpStatus.CONFLICT);
		}
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<ObjetPourBebe> update(
											@PathVariable("id") int id,
											@RequestBody ObjetPourBebe objetPourBebe) {

		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			ObjetPourBebe originalBDD = bll.selectById(id);
			
			originalBDD.setNom(objetPourBebe.getNom());
			originalBDD.setType(objetPourBebe.getType());
			originalBDD.setValeur(objetPourBebe.getValeur());
			originalBDD.setDateCreation(objetPourBebe.getDateModification().now());
			
			bll.update(originalBDD);
			return new ResponseEntity<ObjetPourBebe>(objetPourBebe, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ObjetPourBebe>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			bll.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	
}
