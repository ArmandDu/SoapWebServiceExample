package com.ws.soap.test;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ws.soap.test.App")
public class AppImpl implements App {

	private static final String	message	= "Hello {name} !";

	@Override
	public String grettings(String name) {
		return new String(message).replace("{name}", name);
	}

	@Override
	public double doAddition(double a, double b) {
		return a + b;
	}

	@Override
	public double doSubstraction(double a, double b) {
		return a - b;
	}

	@Override
	public double doMultiplication(double a, double b) {
		return a * b;
	}

	@Override
	public double doDivision(double a, double b) {
		return a / b;
	}

}
