package dal;

import java.util.List;

import bo.ObjetPourBebe;


public interface ObjetDAO {
	ObjetPourBebe select(int id);
	List<ObjetPourBebe> selectAll();
	void insert(ObjetPourBebe objet);
	void update(ObjetPourBebe objet);
	void delete(int id);
}
