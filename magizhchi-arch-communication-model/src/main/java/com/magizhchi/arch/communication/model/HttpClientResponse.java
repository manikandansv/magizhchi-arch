package com.magizhchi.arch.communication.model;

import java.io.Serializable;

import org.apache.http.HttpResponse;

public class HttpClientResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 559308573527282812L;

  private HttpResponse response;

  public HttpClientResponse(HttpResponse response) {
    super();
    this.response = response;
  }

  public HttpClientResponse() {
    super();
  }

  public HttpResponse getResponse() {
    return response;
  }

}
