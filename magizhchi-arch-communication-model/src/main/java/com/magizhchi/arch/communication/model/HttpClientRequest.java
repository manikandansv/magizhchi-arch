package com.magizhchi.arch.communication.model;

import java.io.Serializable;
import java.util.Map;


public class HttpClientRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7677179764418454788L;

  private Map<String, String> headers;

  private String body;

  private String serverUrl;

  public HttpClientRequest() {
    super();
  }

  public HttpClientRequest(Map<String, String> headers, String body, String serverUrl) {
    super();
    this.headers = headers;
    this.body = body;
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

  public String getHeader(String headerKey) {
    return this.headers.get(headerKey);
  }

}
