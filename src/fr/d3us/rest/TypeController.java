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


import fr.d3us.bll.TypeBll;
import fr.d3us.bo.Type;


@RestController
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeBll bll;
	
	@GetMapping
	public ResponseEntity<List<Type>> findAll() {
		List<Type> forms = bll.selectAll();
		return new ResponseEntity<List<Type>>(forms, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Type> findById(@PathVariable("id") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<Type>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
		}
	
	}

	@PostMapping
	public ResponseEntity<Type> insert(@RequestBody Type type) {
		try {
			bll.insert(type);
			return new ResponseEntity<Type>(type, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Type>(HttpStatus.CONFLICT);
		}
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Type> update(
											@PathVariable("id") int id,
											@RequestBody Type type) {

		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			Type originalBDD = bll.selectById(id);
			originalBDD.setNom(type.getNom());
			
			
			bll.update(originalBDD);
			return new ResponseEntity<Type>(type, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Type>(HttpStatus.CONFLICT);
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
