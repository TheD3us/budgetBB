package bll;

import java.util.List;

import bo.Type;
import dal.TypeDAO;
import dal.TypeDAOjdbcImpl;

public class TypeBll {
	private TypeDAO dao;

	public TypeBll() {
		dao = new TypeDAOjdbcImpl();
	}
	
	public Type select(int id)
	{
		if(id >= 0) {
			return dao.select(id);
		}
		return null;
		
	}
	
	public List<Type> selectAll()
	{
		return dao.selectAll();
	}
	
}
