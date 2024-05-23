package com.acme;

import java.util.Set;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

	@Inject
	private FruitService fruitService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Fruit> list() {
		return fruitService.list();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Fruit listOne(long id) {
		Fruit entity = fruitService.listOne(id);
		if (entity == null)
			throw new WebApplicationException("Fruit with id " + id + " does not exist.", 404);
		else
			return entity;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Fruit> add(Fruit fruit) {
		return fruitService.add(fruit);
	}

	@DELETE
	@Path("/{id}")
	public void delete(long id) {
		fruitService.delete(id);
	}
}
