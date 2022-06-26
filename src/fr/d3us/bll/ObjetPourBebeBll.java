package fr.d3us.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.d3us.bo.ObjetPourBebe;
import fr.d3us.dal.ObjetDAO;



@Service
public class ObjetPourBebeBll {
		
	@Autowired
	private ObjetDAO dao;
	
	public List<ObjetPourBebe> selectAll() {
		return dao.findAll();
	}
	
	public ObjetPourBebe selectById(int id) {
		return dao.findById(id).get();
	}
	
	public void update(ObjetPourBebe objetPourBebe) {
		dao.save(objetPourBebe);
	}
	
	public void insert(ObjetPourBebe objetPourBebe) {
		dao.save(objetPourBebe);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean exist(int id) {
		return dao.existsById(id);
	}

		

}
