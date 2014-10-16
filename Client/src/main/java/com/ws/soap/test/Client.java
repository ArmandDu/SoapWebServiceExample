package com.ws.soap.test;

/**
 * Hello world!
 *
 */
public class Client {
	public static void main(String[] args) {
		AppImplService service = new AppImplService();
		App app = service.getAppImplPort();

		System.out.println(app.grettings("John Doe"));
	}
}
