package com.github.armanddu.jaxws.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.armanddu.jaxws.example.Calculator;
import com.github.armanddu.jaxws.example.CalculatorImpl;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {

	private static final String	PACKAGE_URL		= "http://example.jaxws.armanddu.github.com/";
	private static final String	ENDPOINT_URL	= "http://localhost:4242/WS/Calculator";

	Calculator					calculator;
	Endpoint					endPoint;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 * @throws MalformedURLException
	 */
	public CalculatorTest(String testName) {
	}

	@BeforeTest
	public void setUp() throws MalformedURLException {

		/*
		 * endPoint = Endpoint.publish(ENDPOINT_URL, new CalculatorImpl());
		 * assertTrue((endPoint.isPublished()));
		 * 
		 * URL wsdlLocation = new URL(ENDPOINT_URL + "?wsdl"); QName
		 * servineQName = new QName(PACKAGE_URL, "CalculatorImplService"); QName
		 * portQName = new QName(PACKAGE_URL, "CalculatorImplPort");
		 * 
		 * Service service = Service.create(wsdlLocation, servineQName);
		 * calculator = service.getPort(portQName, Calculator.class);
		 */
		endPoint = Endpoint.publish(ENDPOINT_URL, new CalculatorImpl());
		Assert.assertTrue((endPoint.isPublished()));

		URL newEndpoint = new URL(ENDPOINT_URL);

		QName qname = new QName(PACKAGE_URL, "CalculatorImplService");
		CalculatorImplService service = new CalculatorImplService(newEndpoint,
				qname);
		calculator = service.getCalculatorImplPort();
		Assert.assertNotNull(calculator);
	}

	@AfterTest
	public void tearDown() {
		endPoint.stop();
		Assert.assertFalse(endPoint.isPublished());
	}

	/**
	 * Rigourous Test :-)
	 */

	@Test
	public void testCalculs() {

		for (double a = -5; a < 5; a += 0.3666) {
			for (double b = -5; b < 5; b += 0.3666) {
				Assert.assertEquals(a + b, calculator.doAddition(a, b));
				Assert.assertEquals(a - b, calculator.doSubstraction(a, b));
				Assert.assertEquals(a * b, calculator.doMultiplication(a, b));
				if (b != 0.0) {
					Assert.assertEquals(a / b, calculator.doDivision(a, b));
				}
			}
		}
	}
}
