package org.amm.ams.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.service.interfaces.CategoryDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/category")
public class CategoryRest {

	@Autowired
	CategoryDefService categoryDefService;
 
	@GET
	@Path("/all")
	public Response savePayment() {
 
		List<CategoryDef> result = categoryDefService.findAll();
 
		return Response.status(200).entity(result).build();
 
	}
	
	@GET
	@Path("/cat")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> index(){
		
		
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postClichedMessage(String message) {
	    // TODO
	}
}
