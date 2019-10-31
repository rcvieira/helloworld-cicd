package me.rodrigovieira.helloworld_cicd;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {

	@GET
	public Response ping() {
		return Response.ok().entity("Estamos bem!").build();
	}
}