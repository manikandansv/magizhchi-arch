package com.magizhchi.arch.serviceexecution.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.cm.ConfigurationAdmin;

import com.magizhchi.arch.communication.model.MagizhchiInboundRequest;
import com.magizhchi.arch.communication.model.MagizhchiOutboundResponse;


public class ServiceManager {

  private final static String KEY_PROPERTY = "svc.inbound.req.msg.code";

  @Reference
  private ConfigurationAdmin configAdmin;

  private final Map<String, String> serviceFacadeMap = new HashMap<String, String>();

  protected void bindServiceFacade(final ServiceFacade serviceFacade, final Map<String, Object> properties) {
    synchronized (this.serviceFacadeMap) {

      String key = (String) properties.get(KEY_PROPERTY);

      serviceFacadeMap.put(key, serviceFacade.getClass().getName());

    }

  }

  protected void unbindServiceFacade(final ServiceFacade serviceFacade) {

    synchronized (this.serviceFacadeMap) {

      serviceFacadeMap.remove(serviceFacade);

      serviceFacadeMap.remove(serviceFacade);

    }
  }

  public ServiceFacade getServiceFacade(MagizhchiInboundRequest magizhchiInboundRequest) {

    ServiceFacade serviceFacade = null;

    String msgCode = magizhchiInboundRequest.getMagizhchiMessage().getMessageCode();

    String serviceFacadeName = serviceFacadeMap.get(msgCode);

    serviceFacade = getServiceFacadeForName(serviceFacadeName);

    return serviceFacade;
  }

  public ServiceFacade getServiceFacadeForName(String serviceName) {
    Class<?> clazz;
    ServiceFacade service = null;
    try {
      try {
        clazz = Class.forName(serviceName);
        service = (ServiceFacade) clazz.newInstance();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }


    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return service;


  }


  public MagizhchiOutboundResponse executeService(MagizhchiInboundRequest request) {

    ServiceFacade serviceFacade = getServiceFacade(request);
    
    return executeServiceInternal(serviceFacade, request);

  }
  
  public MagizhchiOutboundResponse[] executeService(MagizhchiInboundRequest[] requests) {

    List<MagizhchiOutboundResponse> responsesList = new ArrayList<MagizhchiOutboundResponse>();
    
    for (int i = 0; i < requests.length; i++) {
      
      ServiceFacade service = getServiceFacade(requests[i]);
     
      MagizhchiOutboundResponse response = executeServiceInternal(service, requests[i]);
      
      responsesList.add(response);
      
    }
    
    return responsesList.toArray(new MagizhchiOutboundResponse[responsesList.size()]);

  }
  
  private MagizhchiOutboundResponse executeServiceInternal(ServiceFacade service, MagizhchiInboundRequest request){
    
    service.processRequest(request);
    
    MagizhchiOutboundResponse response = service.getResponse();
    
    return response;
    
  }
  
  private MagizhchiOutboundResponse handleException(Exception e, MagizhchiInboundRequest request) {
    
    return null;
    
  }
  
  private MagizhchiOutboundResponse convertExceptionToResponse(Exception e, MagizhchiInboundRequest request) {
    
    return null;
    
  }
  
  private boolean isExceptionResponse(MagizhchiOutboundResponse response) {
    
    return false;
    
  }
  
}
