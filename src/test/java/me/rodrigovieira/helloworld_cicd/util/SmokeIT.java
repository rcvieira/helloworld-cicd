package me.rodrigovieira.helloworld_cicd.util;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

public class SmokeIT {

	@Test
	public void testPing() {

		String REST_URI = "http://localhost:8080/helloworld-cicd/api/ping";

		Client clienteRest = ClientBuilder.newClient();

		String retorno = clienteRest.target(REST_URI).request(MediaType.TEXT_PLAIN_TYPE).get(String.class);

		assertEquals("Estamos bem!", retorno);
	}
}
