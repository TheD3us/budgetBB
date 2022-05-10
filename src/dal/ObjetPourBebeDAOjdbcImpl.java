package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.ObjetPourBebe;
import bo.Type;

public class ObjetPourBebeDAOjdbcImpl implements ObjetDAO {

	@Override
	public ObjetPourBebe select(int id) {
		ObjetPourBebe objet = new ObjetPourBebe();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM objet_bb AS o  LEFT JOIN type AS t ON o.type = t.id WHERE o.id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next() != false) {
				objet.setId(id);
				objet.setNom(rs.getString("o.nom"));
				Type type = new Type(rs.getInt("t.id"), rs.getString("t.nom"));
				objet.setType(type);
				objet.setValeur(rs.getInt("o.valeur"));
				
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objet;
	}

	@Override
	public List<ObjetPourBebe> selectAll() {
		ObjetPourBebe objet = new ObjetPourBebe();
		List<ObjetPourBebe> listObjet = new ArrayList<ObjetPourBebe>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM objet_bb AS o  LEFT JOIN type AS t ON o.type = t.id;");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				objet.setId(rs.getInt("o.id"));
				objet.setNom(rs.getString("o.nom"));
				Type type = new Type(rs.getInt("t.id"), rs.getString("t.nom"));
				objet.setValeur(rs.getInt("o.valeur"));
				objet.setType(type);
				listObjet.add(objet);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listObjet;
	}

	@Override
	public void insert(ObjetPourBebe objet) {
		Connection cnx = ConnectionProvider.getConnection();
		try {
			if(objet.getType().getNom() != null) {
				PreparedStatement ps = cnx.prepareStatement("INSERT INTO type AS t (t.nom) VALUES (?);");
				
				ps.setString(1, objet.getType().getNom());
				ps.executeUpdate();
				PreparedStatement ps2 = cnx.prepareStatement(" INSERT INTO objet_bb (nom,type,valeur) VALUES (?,?,?);  ");
				ps2.setString(1, objet.getNom());
				ps2.setInt(2, objet.getType().getId() );
				ps2.setInt(3, objet.getValeur());
				ps2.executeUpdate();
			}else {
				PreparedStatement ps2 = cnx.prepareStatement("INSERT INTO objet_bb (nom,valeur) VALUES (?,?);  ");
				ps2.setString(1, objet.getNom());
				ps2.setInt(3, objet.getValeur());
				ps2.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(ObjetPourBebe objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		Connection cnx = ConnectionProvider.getConnection();
		try {

			PreparedStatement ps = cnx.prepareStatement("DELETE FROM objet_bb WHERE id = ?");
			
			ps.setInt(1, id);
			ps.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
