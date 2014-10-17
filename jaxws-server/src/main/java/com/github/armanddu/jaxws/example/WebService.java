package com.github.armanddu.jaxws.example;

import javax.xml.ws.Endpoint;

public class WebService {
	private static final String	HTTP_LOCALHOST_4242_WS_APP	= "http://localhost:4242/WS/Calculator";

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.publish(HTTP_LOCALHOST_4242_WS_APP, new CalculatorImpl());
		if (endpoint.isPublished()) {
			System.out.println("webService published");
		}
		else {
			System.err.println("Cannot publish webservice !");
		}
	}
}
