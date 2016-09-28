package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.magizhchi.arch.security.auth.client.model.params.AuthParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.BodyURLEncodedParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.ClientHeaderParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.QueryParameterApplier;

public class BasicAuthClientRequest extends AuthClientRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7075195600926156753L;

  public BasicAuthClientRequest() {
    super();
  }

  public BasicAuthClientRequest(String serverUrl) {
    super(serverUrl);
  }

  public BasicAuthClientRequest(Map<String, String> headers, String body, String serverUrl) {
    super(headers, body, serverUrl);
  }



  public static final class AuthenticationRequestBuilder extends BasicAuthClientRequest.BasicAuthClientRequestBuilder {

    protected AuthenticationRequestBuilder(String url) {
      super(url);
    }

    public AuthenticationRequestBuilder setUserName(String userName) {
      this.parameters.put("username", userName);
      return this;
    }

    public AuthenticationRequestBuilder setPassword(String password) {
      this.parameters.put("password", password);
      return this;
    }

    public AuthenticationRequestBuilder setParameter(String paramName, String paramValue) {
      this.parameters.put(paramName, paramValue);
      return this;
    }

  }

  public static class BasicAuthClientRequestBuilder {

    protected AuthParametersApplier applier;

    protected Map<String, Object> parameters = new HashMap<String, Object>();

    protected String url;

    protected BasicAuthClientRequestBuilder(String url) {
      this.url = url;
    }

    public BasicAuthClientRequest buildQueryMessage()  {
      BasicAuthClientRequest request = new BasicAuthClientRequest(this.url);
      this.applier = new QueryParameterApplier();
      return ((BasicAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters));
    }

    public BasicAuthClientRequest buildBodyMessage() {
      BasicAuthClientRequest request = new BasicAuthClientRequest(this.url);
      this.applier = new BodyURLEncodedParametersApplier();
      return ((BasicAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters));
    }

    public BasicAuthClientRequest buildHeaderMessage()  {
      BasicAuthClientRequest request = new BasicAuthClientRequest(this.url);
      this.applier = new ClientHeaderParametersApplier();
      return ((BasicAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters));
    }


  }

}
