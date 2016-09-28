package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;

import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthErrorResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;

public class MagizhchiOAuthClientResponse extends AuthClientResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -933183425413636345L;

  private OAuthAuthzResponse oAuthAuthzResponse;

  private OAuthJSONAccessTokenResponse oAuthJSONAccessTokenResponse;

  private OAuthErrorResponse oAuthErrorResponse;

  private OAuthResourceResponse oAuthResourceResponse;

  public OAuthAuthzResponse getOAuthAuthzResponse() {
    return oAuthAuthzResponse;
  }

  public OAuthJSONAccessTokenResponse getOAuthJSONAccessTokenResponse() {
    return oAuthJSONAccessTokenResponse;
  }

  public OAuthErrorResponse getOAuthErrorResponse() {
    return oAuthErrorResponse;
  }

  public OAuthResourceResponse getOAuthResourceResponse() {
    return oAuthResourceResponse;
  }

  public MagizhchiOAuthClientResponse(MagizhchiOAuthClientResponseBuilder builder) {
    this.oAuthAuthzResponse = builder.oAuthAuthzResponse;
    this.oAuthErrorResponse = builder.oAuthErrorResponse;
    this.oAuthJSONAccessTokenResponse = builder.oAuthJSONAccessTokenResponse;
    this.oAuthResourceResponse = builder.oAuthResourceResponse;
  }

  public static class MagizhchiOAuthClientResponseBuilder {

    private OAuthAuthzResponse oAuthAuthzResponse;

    private OAuthJSONAccessTokenResponse oAuthJSONAccessTokenResponse;

    private OAuthErrorResponse oAuthErrorResponse;

    private OAuthResourceResponse oAuthResourceResponse;

    public MagizhchiOAuthClientResponseBuilder(OAuthJSONAccessTokenResponse jsonResponse) {
      this.oAuthJSONAccessTokenResponse = jsonResponse;
    }

    public MagizhchiOAuthClientResponseBuilder(OAuthAuthzResponse jsonResponse) {
      this.oAuthAuthzResponse = jsonResponse;
    }

    public MagizhchiOAuthClientResponseBuilder(OAuthResourceResponse jsonResponse) {
      this.oAuthResourceResponse = jsonResponse;
    }

    public MagizhchiOAuthClientResponseBuilder oAuthAuthzResponse(OAuthAuthzResponse oAuthAuthzResponse) {
      this.oAuthAuthzResponse = oAuthAuthzResponse;
      return this;
    }

    public MagizhchiOAuthClientResponseBuilder oAuthErrorResponse(OAuthErrorResponse oAuthErrorResponse) {
      this.oAuthErrorResponse = oAuthErrorResponse;
      return this;
    }

    public MagizhchiOAuthClientResponseBuilder oAuthResourceResponse(OAuthResourceResponse oAuthResourceResponse) {
      this.oAuthResourceResponse = oAuthResourceResponse;
      return this;
    }

    public MagizhchiOAuthClientResponse build() {
      return new MagizhchiOAuthClientResponse(this);
    }

  }

}
