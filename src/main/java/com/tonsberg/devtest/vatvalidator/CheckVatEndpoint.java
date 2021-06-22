package com.tonsberg.devtest.vatvalidator;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;
import eu.europa.ec.taxud.vies.services.checkvat.types.CheckVat;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceException;
import java.util.Arrays;
import java.util.Date;

@Endpoint
public class CheckVatEndpoint  {


}
