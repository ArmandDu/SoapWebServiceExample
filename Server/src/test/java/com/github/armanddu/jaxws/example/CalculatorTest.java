package com.github.armanddu.jaxws.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import com.github.armanddu.jaxws.example.Calculator;
import com.github.armanddu.jaxws.example.CalculatorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CalculatorTest extends TestCase {

	private static final String	PACKAGE_URL		= "http://example.jaxws.armanddu.github.com/";
	private static final String	ENDPOINT_URL	= "http://localhost:4242/WS/Calculator";

	Calculator							calculator;
	Endpoint					endPoint;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 * @throws MalformedURLException
	 */
	public CalculatorTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CalculatorTest.class);
	}

	public void setUp() throws MalformedURLException {

		endPoint = Endpoint.publish(ENDPOINT_URL, new CalculatorImpl());
		assertTrue((endPoint.isPublished()));

		URL wsdlLocation = new URL(ENDPOINT_URL + "?wsdl");
		QName servineQName = new QName(PACKAGE_URL, "CalculatorImplService");
		QName portQName = new QName(PACKAGE_URL, "CalculatorImplPort");

		Service service = Service.create(wsdlLocation, servineQName);
		calculator = service.getPort(portQName, Calculator.class);
	}

	public void tearDown() {
		endPoint.stop();
		assertFalse(endPoint.isPublished());
	}

	/**
	 * Rigourous Test :-)
	 */

	public void testCalculs() {

		for (double a = -5; a < 5; a += 0.3666) {
			for (double b = -5; b < 5; b += 0.3666) {
				assertEquals(a + b, calculator.doAddition(a, b));
				assertEquals(a - b, calculator.doSubstraction(a, b));
				assertEquals(a * b, calculator.doMultiplication(a, b));
				if (b != 0.0) {
					assertEquals(a / b, calculator.doDivision(a, b));
				}
			}
		}
	}
}
