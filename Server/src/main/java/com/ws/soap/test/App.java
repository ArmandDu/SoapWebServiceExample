package com.ws.soap.test;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Hello world!
 *
 */

@WebService
public interface App {
	@WebMethod
	String grettings(String name);

	@WebMethod
	double doAddition(double a, double b);

	@WebMethod
	double doSubstraction(double a, double b);

	@WebMethod
	double doMultiplication(double a, double b);

	@WebMethod
	double doDivision(double a, double b);
}
