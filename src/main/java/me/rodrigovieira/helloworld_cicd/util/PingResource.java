package me.rodrigovieira.helloworld_cicd.util;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

@Path("/")
public class PingResource {

	static final Logger LOGGER = Logger.getLogger(PingResource.class);

    @Inject
    DBUtil dbutil;
	
	@GET
	@Path("/ping")
	public Response ping() {
		return Response.ok().entity("Estamos bem!").build();
	}
	
	@GET
	@Path("/db-ping")
	public Response pingDB() {

		if (dbutil.isAlive()) {
			return Response.ok().entity("Database online").build();			
		}
		
		return Response.ok().entity("Database offline").build();
	}
}