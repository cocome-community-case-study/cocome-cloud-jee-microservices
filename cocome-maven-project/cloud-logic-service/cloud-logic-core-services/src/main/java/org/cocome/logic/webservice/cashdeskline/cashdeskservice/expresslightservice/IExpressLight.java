package org.cocome.logic.webservice.cashdeskline.cashdeskservice.expresslightservice;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.cocome.cloud.logic.webservice.exception.UnhandledException;


@WebService(targetNamespace = "http://expresslight.cashdesk.cashdeskline.webservice.logic.cocome.org/")
public interface IExpressLight {
	@WebMethod
	public Set<Class<?>> turnExpressLightOn(@XmlElement(required = true) @WebParam(name = "cashDeskName") String cashDeskName,
			@XmlElement(required = true) @WebParam(name = "storeID") long storeID) throws UnhandledException;

	@WebMethod
	public Set<Class<?>> turnExpressLightOff(@XmlElement(required = true) @WebParam(name = "cashDeskName") String cashDeskName,
			@XmlElement(required = true) @WebParam(name = "storeID") long storeID) throws UnhandledException;

	@WebMethod
	public boolean isOn(@XmlElement(required = true) @WebParam(name = "cashDeskName") String cashDeskName,
			@XmlElement(required = true) @WebParam(name = "storeID") long storeID) throws UnhandledException;
	
	
}
