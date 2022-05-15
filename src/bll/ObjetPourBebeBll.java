package bll;

import java.util.List;

import bo.ObjetPourBebe;
import dal.ObjetDAO;
import dal.ObjetPourBebeDAOjdbcImpl;

public class ObjetPourBebeBll {
		private ObjetDAO dao;
		
		public ObjetPourBebeBll() {
			dao = new ObjetPourBebeDAOjdbcImpl();
		}
		
		public List<ObjetPourBebe> selectAll(){
			return dao.selectAll();
		}
		
		public ObjetPourBebe select(int id) {
			if(id >= 0) {
				return dao.select(id);
			}
			
			
			return null;
			
		}
		
		public void insert(ObjetPourBebe objet) {
			if(objet.getNom().length() > 50 && objet.getValeur() <= 0)
			{
				return;
			}
			if(objet.getType().getNom().equals("") || objet.getType().getNom().equals("undefined")) {
				objet.setType(null);
			}
			dao.insert(objet);
		}
		
		public void update(ObjetPourBebe objet) {
			
			if(objet.getNom().length() > 50 && objet.getValeur() <= 0) {
				return;
			}
			if(objet.getType().getNom().equals("") || objet.getType().getNom().equals("undefined") ) {
				objet.setType(null);
			}
			
			dao.update(objet);
		}
		
		public void delete(int id) {
			if(id< 0)return;
			dao.delete(id);
		}
}
