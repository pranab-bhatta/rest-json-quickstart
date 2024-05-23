package com.acme;

import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/todos")
@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com")
public interface TodosService {

	@GET
	@Path("/")
	public List<Todos> list();
	
	@GET
	@Path("/{id}")
	public Todos listOne(long id);
}