package com.github.armanddu.jaxws.example;

import com.github.armanddu.jaxws.example.App;
import com.github.armanddu.jaxws.example.AppImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	App	app;

	public AppTest(String testName) {
		super(testName);

		app = new AppImpl();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
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
}
