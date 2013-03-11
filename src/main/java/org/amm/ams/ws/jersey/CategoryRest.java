package org.amm.ams.ws.jersey;

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
import org.amm.ams.domain.Language;
import org.amm.ams.service.interfaces.CategoryDefService;
import org.amm.ams.service.interfaces.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Path("/category")
@Scope("request")
public class CategoryRest {

	@Autowired
	CategoryDefService categoryDefService;

	@Autowired
	private LanguageService languagesService;
	
	public CategoryDefService getCategoryDefService() {
		return categoryDefService;
	}

	public void setCategoryDefService(CategoryDefService categoryDefService) {
		this.categoryDefService = categoryDefService;
	}

	@GET
	@Path("/all")
	@Produces({ "application/xml", "application/json" })
	public List<Category> savePayment() {
		return categoryDefService.findAllCategories();
	}

	@GET
	@Path("/lang")
	public Response lang() {
		String r = languagesService.findAll().get(0).getName();
		return Response.status(200).entity(r).build();
	}
	
	@GET
	@Path("/cat")
	@Produces(MediaType.APPLICATION_XML)
	public List<Language> index() {

		return languagesService.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postClichedMessage(String message) {
		// TODO
	}
}
