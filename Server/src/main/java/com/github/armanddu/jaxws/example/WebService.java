package com.github.armanddu.jaxws.example;

import javax.xml.ws.Endpoint;

public class WebService {
	private static final String	HTTP_LOCALHOST_4242_WS_APP	= "http://localhost:4242/WS/App";

	public static void main(String[] args) {
		Endpoint.publish(HTTP_LOCALHOST_4242_WS_APP, new AppImpl());
		System.out.println("webService published");
	}
}
