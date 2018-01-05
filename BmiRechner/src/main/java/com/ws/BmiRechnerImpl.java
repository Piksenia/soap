package com.ws;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.ws.BmiRechner")
public class BmiRechnerImpl  implements BmiRechner{

	public String getHello() {
		return "Hello World JAX-WS";
	}

	public double getBmi(double gewicht, double groesse) {
		double ergebnis = 0.0;
		ergebnis = gewicht/ (groesse * groesse);
		return ergebnis;
	}

}
