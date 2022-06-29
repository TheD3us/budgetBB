package fr.d3us.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.d3us.bo.Type;
import fr.d3us.dal.TypeDAO;


@Service
public class TypeBll {
			
		@Autowired
		private TypeDAO dao;
		
		public List<Type> selectAll() {
			return dao.findAll();
		}
		
		public Type selectById(int id) {
			return dao.findById(id).get();
		}
		
		public void update(Type type) {
			dao.save(type);
		}
		
		public void insert(Type type) {
			dao.save(type);
		}
		
		public void delete(int id) {
			dao.deleteById(id);
		}
		
		public boolean exist(int id) {
			return dao.existsById(id);
		}

			
	
}
