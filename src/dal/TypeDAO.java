package dal;

import java.util.List;

import bo.Type;

public interface TypeDAO {
	Type select(int id);
	List<Type> selectAll();
	void insert(Type objet);
	void update(Type objet);
	void delete(int id);
}
