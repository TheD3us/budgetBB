package controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import bll.TypeBll;
import bo.Type;

@Path("/types")
public class TypeController {
	TypeBll typeBll;
	
	@GET
	public List<Type> getListType(){
		typeBll = new TypeBll();
		return typeBll.selectAll();
	}
}
