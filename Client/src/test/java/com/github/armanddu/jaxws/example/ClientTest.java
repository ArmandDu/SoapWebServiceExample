package com.github.armanddu.jaxws.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.github.armanddu.jaxws.example.App;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ClientTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */

	App	app;

	public ClientTest(String testName) {
		super(testName);

		URL newEndpoint = null;
		try {
			newEndpoint = new URL("http://localhost:4242/WS/App");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("You should probably run the Server before calling the client");
		}
		QName qname = new QName("http://com.github.armanddu.jaxws.example/", "AppImplService");
		AppImplService service = new AppImplService(newEndpoint, qname);

		app = service.getAppImplPort();

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ClientTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testClient() {
		assertEquals("Hello John Doe !", app.grettings("John Doe"));
	}

	public void testCalculs() {
		double a;
		double b;

		for (a = -5; a < 5; a += 0.3666) {
			for (b = -5; b < 5; b += 0.3666) {
				assertEquals(a + b, app.doAddition(a, b));
				assertEquals(a - b, app.doSubstraction(a, b));
				assertEquals(a * b, app.doMultiplication(a, b));
				if (b != 0.0) {
					assertEquals(a / b, app.doDivision(a, b));
				}
			}
		}
	}
}
