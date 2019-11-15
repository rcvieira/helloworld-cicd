package me.rodrigovieira.helloworld_cicd.util;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

public class SmokeIT extends ITTeste {

	@Test
	public void testPing() {

		String REST_URI = getAppURL().concat("/api/ping");
		Client clienteRest = ClientBuilder.newClient();
		
		String retorno = clienteRest.target(REST_URI).request(MediaType.TEXT_PLAIN_TYPE).get(String.class);

		assertEquals("Estamos bem!", retorno);
	}
	
	@Test
	public void testDatabasePing() {
		
		String REST_URI = getAppURL().concat("/api/db-ping");
		Client clienteRest = ClientBuilder.newClient();

		String retorno = clienteRest.target(REST_URI).request(MediaType.TEXT_PLAIN_TYPE).get(String.class);

		assertEquals("Database online", retorno);
	}
}
