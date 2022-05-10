package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Type;

public class TypeDAOjdbcImpl implements TypeDAO {

	@Override
	public Type select(int id) {
		Type type = new Type();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM type WHERE id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				type.setId(id);
				type.setNom(rs.getString("nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public List<Type> selectAll() {
		Type type = new Type();
		List<Type> listType = new ArrayList<Type>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM type;");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				type.setId(rs.getInt("id"));
				type.setNom(rs.getString("nom"));
				
				listType.add(type);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listType;
	}

	@Override
	public void insert(Type objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Type objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
