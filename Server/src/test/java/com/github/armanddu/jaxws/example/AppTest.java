package com.github.armanddu.jaxws.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import com.github.armanddu.jaxws.example.App;
import com.github.armanddu.jaxws.example.AppImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{

	private static final String	PACKAGE_URL	= "http://example.jaxws.armanddu.github.com/";
	private static final String	SERVICE_URL	= "http://localhost:4242/WS/App";

	App							app;
	Endpoint					endPoint;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 * @throws MalformedURLException 
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void setUp() throws MalformedURLException {

		endPoint = Endpoint.publish(SERVICE_URL, new AppImpl());
		assertTrue((endPoint.isPublished()));

		URL wsdlLocation = new URL(SERVICE_URL + "?wsdl");
		QName servineQName = new QName(PACKAGE_URL, "AppImplService");
		QName portQName = new QName(PACKAGE_URL, "AppImplPort");

		Service service = Service.create(wsdlLocation, servineQName);
		app = service.getPort(portQName, App.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testHello() {
		assertEquals("Hello John Doe !", app.grettings("John Doe"));
	}

	public void testCalculs() {

		for (double a = -5; a < 5; a += 0.3666) {
			for (double b = -5; b < 5; b += 0.3666) {
				assertEquals(a + b, app.doAddition(a, b));
				assertEquals(a - b, app.doSubstraction(a, b));
				assertEquals(a * b, app.doMultiplication(a, b));
				if (b != 0.0) {
					assertEquals(a / b, app.doDivision(a, b));
				}
			}
		}
	}

	public void tearDown() {
		endPoint.stop();
		assertFalse(endPoint.isPublished());
	}

}
