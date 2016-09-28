package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;
import java.util.Map;


public class AuthClientRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2533802678759440939L;


  private Map<String, String> headers;

  private String body;

  private String serverUrl;

  public AuthClientRequest() {
    super();
  }

  public AuthClientRequest(Map<String, String> headers, String body, String serverUrl) {
    super();
    this.headers = headers;
    this.body = body;
    this.serverUrl = serverUrl;
  }



  public AuthClientRequest(String serverUrl) {
    super();
    this.serverUrl = serverUrl;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getServerUrl() {
    return serverUrl;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  public void addHeader(String headerKey, String headerValue) {
    this.headers.put(headerKey, headerValue);
  }
  
  public String getHeader(String headerKey){
    return this.headers.get(headerKey);
  }

}
