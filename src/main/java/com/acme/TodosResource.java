package com.acme;

import java.util.List;

import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/todos")
public class TodosResource {

	@Inject
	@RestClient
	TodosService todosService;

    @GET
    @Path("/")
    public List<Todos> list() {
        return todosService.list();
    }
    
    @GET
    @Path("/{id}")
    public Todos list(long id) {
        try {
            return todosService.listOne(id);
        } catch (Exception e) {
            if (e.getMessage().contains("404")) {
                throw new WebApplicationException("Todo with id " + id + " does not exist.", 404);
            }
            return null;
        }
    }
}