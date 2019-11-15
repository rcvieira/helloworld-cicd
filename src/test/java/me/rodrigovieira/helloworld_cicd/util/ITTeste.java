package me.rodrigovieira.helloworld_cicd.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

public class ITTeste {

	private static final Logger LOOGER = Logger.getLogger(ITTeste.class);
	
	private static final String DEFAULT_APP_URL = "http://localhost:8080/helloworld-cicd";
	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_APP_PORT = 8080;
	private static final String APP_PROTOCOL = "http";

	private String getHost() {
		String appHost = System.getProperty("APP_HOST_URL");

		if (appHost == null || appHost.isEmpty()) {
			return DEFAULT_HOST;
		}

		return appHost;
	}

	private int getAppPort() {
		String appPort = System.getProperty("PORT");

		if (appPort == null || appPort.isEmpty()) {
			return DEFAULT_APP_PORT;
		}

		return Integer.valueOf(appPort);
	}

	public String getAppURL() {
		String appURL = null;
		
		try {
			URI appUri = new URI(APP_PROTOCOL, null, getHost(), getAppPort(), "/helloworld-cicd", null, null);
			appURL = appUri.toString();
			
		} catch (URISyntaxException e) {
			LOOGER.info("URL malformada. Usando o valor padrao=" + DEFAULT_APP_URL);
			appURL = DEFAULT_APP_URL;
		}
		return appURL;
// 		return APP_PROTOCOL.concat(getBaseAppURL()).concat(":").concat(getAppPort()).concat("/helloworld-cicd");
	}
}
