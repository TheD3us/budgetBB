package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.TypeBll;
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
				objet.setDateCreation(rs.getDate("o.date_creation").toLocalDate());
				objet.setDateModification(rs.getDate("o.date_modification").toLocalDate());
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
		
		List<ObjetPourBebe> listObjet = new ArrayList<ObjetPourBebe>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM objet_bb AS o  LEFT JOIN type AS t ON o.type = t.id;");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				ObjetPourBebe objet = new ObjetPourBebe();
				objet.setId(rs.getInt("o.id"));
				objet.setNom(rs.getString("o.nom"));
				objet.setDateCreation(rs.getDate("o.date_creation").toLocalDate());
				objet.setDateModification(rs.getDate("o.date_modification").toLocalDate());
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
		TypeBll td = new TypeBll();
		boolean trouve = false;
		try {
			// Si l'objet n'a pas de type on créer juste sans type
			if(objet.getType() == null) {
				PreparedStatement ps2 = cnx.prepareStatement("INSERT INTO objet_bb (nom,valeur, date_creation, date_modification) VALUES (?,?,?,?);  ");
				ps2.setString(1, objet.getNom());
				ps2.setDouble(2, objet.getValeur());
				ps2.setDate(3, Date.valueOf(objet.getDateCreation()));
				ps2.setDate(4, Date.valueOf(objet.getDateModification()));
				ps2.executeUpdate();
			}else {
				for(Type current : td.selectAll())
				{
					// sinon si le type existe déjà on créer l'objet
					if(current.getNom().equalsIgnoreCase(objet.getType().getNom()))
					{
						PreparedStatement ps2 = cnx.prepareStatement(" INSERT INTO objet_bb (nom,type,date_creation, date_modification, valeur) VALUES (?,?,?,?,?);  ");
						ps2.setString(1, objet.getNom());
						ps2.setInt(2, current.getId() );
						ps2.setDate(3, Date.valueOf(objet.getDateCreation()));
						ps2.setDate(4, Date.valueOf(objet.getDateModification()));
						ps2.setDouble(5, objet.getValeur());
						ps2.executeUpdate();
						trouve = true;
					}	
				}
				// Sinon on créer le type
				if(trouve == false)
				{
					PreparedStatement ps = cnx.prepareStatement("INSERT INTO type (nom) VALUES (?);", PreparedStatement.RETURN_GENERATED_KEYS);
					
					ps.setString(1, objet.getType().getNom());
					ps.executeUpdate();
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next())
					{
						PreparedStatement ps2 = cnx.prepareStatement(" INSERT INTO objet_bb (nom,type,date_creation, date_modification,valeur) VALUES (?,?,?,?,?);  ");
						ps2.setString(1, objet.getNom());
						ps2.setInt(2, rs.getInt(1) );
						ps2.setDate(3, Date.valueOf(objet.getDateCreation()));
						ps2.setDate(4, Date.valueOf(objet.getDateModification()));
						ps2.setDouble(5, objet.getValeur());
						ps2.executeUpdate();
					}
				}
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ObjetPourBebe objet) {
		Connection cnx = ConnectionProvider.getConnection();
		TypeBll td = new TypeBll();
		boolean trouve = false;
			try {
				if(objet.getType() == null)
				{
				PreparedStatement ps = cnx.prepareStatement("UPDATE objet_bb SET nom = ?, valeur = ?, date_modification = ? WHERE id = ?;");
				ps.setString(1, objet.getNom());
				ps.setDouble(2, objet.getValeur());
				ps.setDate(3, Date.valueOf(objet.getDateModification()));
				ps.setInt(4, objet.getId());
				ps.executeUpdate();
				}else {
					for(Type current : td.selectAll())
					{
						// sinon si le type existe déjà on créer l'objet
						if(current.getNom().equals(objet.getType().getNom()))
						{
							PreparedStatement ps2 = cnx.prepareStatement(" UPDATE objet_bb SET nom = ?, valeur = ?, date_modification =? WHERE id = ?;  ");
							ps2.setString(1, objet.getNom());
							ps2.setDouble(2, objet.getValeur());
							ps2.setDate(3, Date.valueOf(objet.getDateModification()));
							ps2.setInt(4, current.getId() );
							
							ps2.executeUpdate();
							trouve = true;
						}	
					}
					// Sinon on créer le type
					if(trouve == false)
					{
						PreparedStatement ps = cnx.prepareStatement("INSERT INTO type (nom) VALUES (?);", PreparedStatement.RETURN_GENERATED_KEYS);
						
						ps.setString(1, objet.getType().getNom());
						ps.executeUpdate();
						ResultSet rs = ps.getGeneratedKeys();
						if(rs.next())
						{
							PreparedStatement ps2 = cnx.prepareStatement(" UPDATE objet_bb SET nom = ?, type = ?,valeur = ?, date_modification = ? WHERE id = ?;  ");
							ps2.setString(1, objet.getNom());
							ps2.setInt(2, rs.getInt(1) );
							ps2.setDouble(3, objet.getValeur());
							ps2.setDate(4, Date.valueOf(objet.getDateModification()));
							ps2.setInt(5, objet.getId());
							ps2.executeUpdate();
						}
					}
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
