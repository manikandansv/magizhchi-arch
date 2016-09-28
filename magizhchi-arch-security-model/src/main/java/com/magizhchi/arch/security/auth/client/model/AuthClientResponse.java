package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;

import org.apache.http.HttpResponse;

public class AuthClientResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6533795832603495034L;

  private HttpResponse response;

  public AuthClientResponse(HttpResponse response) {
    super();
    this.response = response;
  }

  public AuthClientResponse() {
    super();
  }

  public HttpResponse getResponse() {
    return response;
  }

}
