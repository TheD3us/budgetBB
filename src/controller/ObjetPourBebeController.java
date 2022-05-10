package controller;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bll.ObjetPourBebeBll;
import bo.ObjetPourBebe;
import bo.Type;

@Path("/objets")
public class ObjetPourBebeController {
	ObjetPourBebeBll objetBebe;
	@GET
	public List<ObjetPourBebe> getListObjetBebe() {
		objetBebe= new ObjetPourBebeBll();
		
		return objetBebe.selectAll();
		
	}
	
	@GET @Path("/{ cle : \\d+}")
	public ObjetPourBebe getObjetBebe(@PathParam("cle") int id) {
		objetBebe= new ObjetPourBebeBll();
		
		return objetBebe.select(id);
		
	}
	
	@POST
	public void ajouterObjetBebe(@FormParam("nom") String nom,
											@FormParam("type") String typeBrut,
											@FormParam("valeur") String valeurBrut) {
		objetBebe= new ObjetPourBebeBll();
		Type type = new Type();
		type.setNom(typeBrut);
		double valeur = Double.valueOf(valeurBrut);
		ObjetPourBebe objetPourBebe = new ObjetPourBebe(nom, type, valeur, LocalDate.now(), LocalDate.now());
		
		objetBebe.insert(objetPourBebe);
		
	}
	
	@PUT @Path("/{ cle : \\d+}")
	public void modifierObjetBebe(@PathParam("cle") int id,
											@FormParam("nom") String nom,
											@FormParam("type") String typeBrut,
											@FormParam("valeur") String valeurBrut){
											objetBebe= new ObjetPourBebeBll();	
											Type type = new Type();
											type.setNom(typeBrut);
											double valeur = Double.valueOf(valeurBrut);
											ObjetPourBebe objetPourBebe = new ObjetPourBebe(nom, type, valeur, LocalDate.now());
											objetPourBebe.setId(id);
											objetBebe.update(objetPourBebe);
											
											}
}
