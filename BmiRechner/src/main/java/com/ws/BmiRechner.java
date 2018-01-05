package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface BmiRechner {
	@WebMethod String getHello();
	@WebMethod double getBmi(@WebParam(name="gewicht")double gewicht, @WebParam(name="groesse")double groesse);
	@WebMethod void createDB();
}
