package com.github.armanddu.jaxws.example;

import javax.jws.WebService;

@WebService(endpointInterface = "com.github.armanddu.jaxws.example.Calculator")
public class CalculatorImpl implements Calculator {

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
