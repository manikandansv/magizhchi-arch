package com.magizhchi.arch.security.auth.client.provider;



import java.io.IOException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.magizhchi.arch.security.auth.client.api.AuthClientResponseService;
import com.magizhchi.arch.security.auth.client.api.AuthHandler;
import com.magizhchi.arch.security.auth.client.model.AuthClientResponse;
import com.magizhchi.arch.security.auth.client.model.BasicAuthClientRequest;
import com.magizhchi.arch.utilities.api.PropertiesUtil;

public class BasicAuthHandler implements AuthHandler<BasicAuthClientRequest, AuthClientResponse>{

  private static final Logger log = LoggerFactory.getLogger(BasicAuthHandler.class);
  
  @Reference
  private AuthClientResponseService authClientResponseService;

  protected static final int DEFAULT_SESSION_TIMEOUT = 3600;

  @Property(label = "Session timeout", intValue = {3600}, description = "Session timeout in seconds")
  public static final String PROPERTY_SESSION_TIMEOUT = "basicauth.session_timeout";

  private int sessionTimeout;

  @Activate
  public void activate(ComponentContext ctx) {
    this.sessionTimeout = PropertiesUtil.toInteger(ctx.getProperties().get(PROPERTY_SESSION_TIMEOUT), 3600);
  }

  @Override
  public int getSessionTimeout() {
    return sessionTimeout;
  }

  @Override
  public AuthClientResponse authenticateUser(BasicAuthClientRequest commandRequest) {

    HttpResponse httpResponse = null;

    AuthClientResponse commandResponse = null;

    HttpGet request = null;

    CloseableHttpClient client = null;

    // 1. Validate AuthRequest. If validation fails, throw InputException

    // 2. Execution

    try {
                          
      request = new HttpGet(commandRequest.getServerUrl());

      request.setHeader(HttpHeaders.AUTHORIZATION, commandRequest.getHeader(HttpHeaders.AUTHORIZATION));

      client = HttpClientBuilder.create().build();

      httpResponse = client.execute(request);

      commandResponse = new AuthClientResponse(httpResponse);

      boolean isSuccessful = authClientResponseService.isSuccessfulResponse(commandResponse);

      if (!isSuccessful) {

        // Log unauthenticated

      }

    } catch (Exception e) {

      // TODO : Throw functional exception

      e.printStackTrace();

    } finally {

      try {
        
        request.releaseConnection();
        
        client.close();
        
      } catch (IOException e) {
        // TODO : Throw functional exception
        e.printStackTrace();
      }

    }

    return commandResponse;
  }
}
