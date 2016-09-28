package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;

import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.message.types.TokenType;

import com.magizhchi.arch.security.auth.client.enums.ParameterStyle;

public class OAuthClientParams implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 118926171344296424L;

  private String clientId;
  private String clientSecret;
  private String redirectUri;
  private String authzEndpoint;
  private String tokenEndpoint;
  private String authzCode;
  private String accessToken;
  private Long expiresIn;
  private String refreshToken;
  private String scope;
  private String state;
  private String resourceUrl;
  private String resource;
  private String application;
  private String requestType;
  private String requestMethod;
  private String idToken;
  private String header;
  private String claimsSet;
  private String jwt;
  private boolean idTokenValid;
  private String errorMessage;
  private GrantType grantType;
  private ParameterStyle paramStyle;
  private ResponseType responseType;
  private TokenType tokenType;
  private String userName;
  private String password;

  public OAuthClientParams() {
    super();
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getClientId() {
    return clientId;
  }



  public String getClientSecret() {
    return clientSecret;
  }



  public String getRedirectUri() {
    return redirectUri;
  }



  public String getAuthzEndpoint() {
    return authzEndpoint;
  }



  public String getTokenEndpoint() {
    return tokenEndpoint;
  }



  public String getAuthzCode() {
    return authzCode;
  }



  public String getAccessToken() {
    return accessToken;
  }



  public Long getExpiresIn() {
    return expiresIn;
  }



  public String getRefreshToken() {
    return refreshToken;
  }



  public String getScope() {
    return scope;
  }



  public String getState() {
    return state;
  }



  public String getResourceUrl() {
    return resourceUrl;
  }



  public String getResource() {
    return resource;
  }



  public String getApplication() {
    return application;
  }



  public String getRequestType() {
    return requestType;
  }



  public String getRequestMethod() {
    return requestMethod;
  }



  public String getIdToken() {
    return idToken;
  }



  public String getHeader() {
    return header;
  }



  public String getClaimsSet() {
    return claimsSet;
  }



  public String getJwt() {
    return jwt;
  }



  public boolean isIdTokenValid() {
    return idTokenValid;
  }



  public String getErrorMessage() {
    return errorMessage;
  }



  public GrantType getGrantType() {
    return grantType;
  }



  public ParameterStyle getParamStyle() {
    return paramStyle;
  }



  public ResponseType getResponseType() {
    return responseType;
  }



  public TokenType getTokenType() {
    return tokenType;
  }

  public OAuthClientParams(OAuthClientParamsBuilder builder) {
    this.accessToken = builder.accessToken;
    this.application = builder.application;
    this.authzCode = builder.authzCode;
    this.authzEndpoint = builder.authzEndpoint;
    this.claimsSet = builder.claimsSet;
    this.clientId = builder.clientId;
    this.clientSecret = builder.clientSecret;
    this.errorMessage = builder.errorMessage;
    this.expiresIn = builder.expiresIn;
    this.grantType = builder.grantType;
    this.header = builder.header;
    this.idToken = builder.idToken;
    this.idTokenValid = builder.idTokenValid;
    this.jwt = builder.jwt;
    this.paramStyle = builder.paramStyle;
    this.password = builder.password;
    this.redirectUri = builder.redirectUri;
    this.refreshToken = builder.refreshToken;
    this.requestMethod = builder.requestMethod;
    this.requestType = builder.requestType;
    this.resource = builder.resource;
    this.resourceUrl = builder.resourceUrl;
    this.responseType = builder.responseType;
    this.scope = builder.scope;
    this.state = builder.state;
    this.tokenEndpoint = builder.tokenEndpoint;
    this.tokenType = builder.tokenType;
    this.userName = builder.userName;
  }


  public static class OAuthClientParamsBuilder {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String authzEndpoint;
    private String tokenEndpoint;
    private String authzCode;
    private String accessToken;
    private Long expiresIn;
    private String refreshToken;
    private String scope;
    private String state;
    private String resourceUrl;
    private String resource;
    private String application;
    private String requestType;
    private String requestMethod;
    private String idToken;
    private String header;
    private String claimsSet;
    private String jwt;
    private boolean idTokenValid;
    private String errorMessage;
    private GrantType grantType;
    private ParameterStyle paramStyle;
    private ResponseType responseType;
    private TokenType tokenType;
    private String userName;
    private String password;

    public OAuthClientParamsBuilder(String clientId, String clientSecret) {
      this.clientId = clientId;
      this.clientSecret = clientSecret;
    }

    public OAuthClientParamsBuilder setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public OAuthClientParamsBuilder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    public OAuthClientParamsBuilder setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    public OAuthClientParamsBuilder setRedirectUri(String redirectUri) {
      this.redirectUri = redirectUri;
      return this;
    }

    public OAuthClientParamsBuilder setAuthzEndpoint(String authzEndpoint) {
      this.authzEndpoint = authzEndpoint;
      return this;
    }

    public OAuthClientParamsBuilder setTokenEndpoint(String tokenEndpoint) {
      this.tokenEndpoint = tokenEndpoint;
      return this;
    }

    public OAuthClientParamsBuilder setAuthzCode(String authzCode) {
      this.authzCode = authzCode;
      return this;
    }

    public OAuthClientParamsBuilder setAccessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public OAuthClientParamsBuilder setExpiresIn(Long expiresIn) {
      this.expiresIn = expiresIn;
      return this;
    }

    public OAuthClientParamsBuilder setRefreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    public OAuthClientParamsBuilder setScope(String scope) {
      this.scope = scope;
      return this;
    }

    public OAuthClientParamsBuilder setState(String state) {
      this.state = state;
      return this;
    }

    public OAuthClientParamsBuilder setResourceUrl(String resourceUrl) {
      this.resourceUrl = resourceUrl;
      return this;
    }

    public OAuthClientParamsBuilder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    public OAuthClientParamsBuilder setApplication(String application) {
      this.application = application;
      return this;
    }

    public OAuthClientParamsBuilder setRequestType(String requestType) {
      this.requestType = requestType;
      return this;
    }

    public OAuthClientParamsBuilder setRequestMethod(String requestMethod) {
      this.requestMethod = requestMethod;
      return this;
    }

    public OAuthClientParamsBuilder setIdToken(String idToken) {
      this.idToken = idToken;
      return this;
    }

    public OAuthClientParamsBuilder setHeader(String header) {
      this.header = header;
      return this;
    }

    public OAuthClientParamsBuilder setClaimsSet(String claimsSet) {
      this.claimsSet = claimsSet;
      return this;
    }

    public OAuthClientParamsBuilder setJwt(String jwt) {
      this.jwt = jwt;
      return this;
    }

    public OAuthClientParamsBuilder setIdTokenValid(boolean idTokenValid) {
      this.idTokenValid = idTokenValid;
      return this;
    }

    public OAuthClientParamsBuilder setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
    }

    public OAuthClientParamsBuilder setGrantType(GrantType grantType) {
      this.grantType = grantType;
      return this;
    }

    public OAuthClientParamsBuilder setParamStyle(ParameterStyle paramStyle) {
      this.paramStyle = paramStyle;
      return this;
    }

    public OAuthClientParamsBuilder setResponseType(ResponseType responseType) {
      this.responseType = responseType;
      return this;
    }

    public OAuthClientParamsBuilder setTokenType(TokenType tokenType) {
      this.tokenType = tokenType;
      return this;
    }

    public OAuthClientParamsBuilder setPassword(String password) {
      this.password = password;
      return this;
    }

    public OAuthClientParams build() {
      return new OAuthClientParams(this);
    }

  }

}
