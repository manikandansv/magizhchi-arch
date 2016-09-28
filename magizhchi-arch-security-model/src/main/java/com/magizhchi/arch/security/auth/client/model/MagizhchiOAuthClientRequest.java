package com.magizhchi.arch.security.auth.client.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import com.magizhchi.arch.security.auth.client.model.params.AuthParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.BodyURLEncodedParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.ClientHeaderParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.JSONBodyParametersApplier;
import com.magizhchi.arch.security.auth.client.model.params.QueryParameterApplier;

public class MagizhchiOAuthClientRequest extends OAuthClientRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -9057823019830602786L;


  private OAuthClientParams oAuthClientParams;

  public static MagizhchiAuthenticationRequestBuilder authorizeLocation(String url, OAuthClientParams params) {
    return new MagizhchiAuthenticationRequestBuilder(url, params);
  }

  public static MagizhchiAuthenticationRequestBuilder authorizeProvider(OAuthProviderType provider,
      OAuthClientParams params) {
    return authorizeLocation(provider.getAuthzEndpoint(), params);
  }

  public static MagizhchiTokenRequestBuilder authTokenLocation(String url, OAuthClientParams params) {
    return new MagizhchiTokenRequestBuilder(url, params);
  }

  public static MagizhchiTokenRequestBuilder authTokenProvider(OAuthProviderType provider, OAuthClientParams params) {
    return authTokenLocation(provider.getTokenEndpoint(), params);
  }

  protected MagizhchiOAuthClientRequest(String url) {
    super(url);
  }

  protected MagizhchiOAuthClientRequest(String url, OAuthClientParams params) {
    super(url);
    this.oAuthClientParams = params;
  }

  public OAuthClientParams getoAuthClientParams() {
    return oAuthClientParams;
  }

  public MagizhchiOAuthClientRequest(MagizhchiOAuthRequestBuilder builder) {
    super(builder.url);
  }

  public static class MagizhchiOAuthRequestBuilder {

    protected AuthParametersApplier applier;

    protected Map<String, Object> parameters = new HashMap<String, Object>();

    protected OAuthClientParams oauthClientParams;

    protected String url;

    protected MagizhchiOAuthRequestBuilder(String url, OAuthClientParams oauthClientParams) {
      this.oauthClientParams = oauthClientParams;
      this.url = url;
    }

    public MagizhchiOAuthClientRequest buildQueryMessage(MagizhchiOAuthClientRequest request)
        throws OAuthSystemException {
      if (request == null) {
        request = new MagizhchiOAuthClientRequest(this.url, this.oauthClientParams);
      }
      this.applier = new QueryParameterApplier();
      return (MagizhchiOAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters);
    }

    public MagizhchiOAuthClientRequest buildBodyMessage(MagizhchiOAuthClientRequest request)
        throws OAuthSystemException {
      if (request == null) {
        request = new MagizhchiOAuthClientRequest(this.url);
      }
      this.applier = new BodyURLEncodedParametersApplier();
      return (MagizhchiOAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters);
    }

    public MagizhchiOAuthClientRequest buildJsonBodyMessage(MagizhchiOAuthClientRequest request)
        throws OAuthSystemException {
      if (request == null) {
        request = new MagizhchiOAuthClientRequest(this.url);
      }
      this.applier = new JSONBodyParametersApplier();
      return (MagizhchiOAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters);
    }

    public MagizhchiOAuthClientRequest buildHeaderMessage(MagizhchiOAuthClientRequest request)
        throws OAuthSystemException {
      if (request == null) {
        request = new MagizhchiOAuthClientRequest(this.url);
      }
      this.applier = new ClientHeaderParametersApplier();
      return (MagizhchiOAuthClientRequest) this.applier.applyAuthParameters(request, this.parameters);
    }
  }

  public static class MagizhchiAuthenticationRequestBuilder extends MagizhchiOAuthRequestBuilder {

    public MagizhchiAuthenticationRequestBuilder(String url, OAuthClientParams params) {
      super(url, params);
    }

    public MagizhchiAuthenticationRequestBuilder setResponseType(String type) {
      this.parameters.put(OAuth.OAUTH_RESPONSE_TYPE, type);
      return this;
    }

    public MagizhchiAuthenticationRequestBuilder setClientId(String clientId) {
      this.parameters.put(OAuth.OAUTH_CLIENT_ID, clientId);
      return this;
    }

    public MagizhchiAuthenticationRequestBuilder setRedirectURI(String uri) {
      this.parameters.put(OAuth.OAUTH_REDIRECT_URI, uri);
      return this;
    }

    public MagizhchiAuthenticationRequestBuilder setState(String state) {
      this.parameters.put(OAuth.OAUTH_STATE, state);
      return this;
    }

    public MagizhchiAuthenticationRequestBuilder setScope(String scope) {
      this.parameters.put(OAuth.OAUTH_SCOPE, scope);
      return this;
    }

    public MagizhchiAuthenticationRequestBuilder setParameter(String paramName, String paramValue) {
      this.parameters.put(paramName, paramValue);
      return this;
    }
  }

  public static class MagizhchiTokenRequestBuilder extends MagizhchiOAuthRequestBuilder {

    public MagizhchiTokenRequestBuilder(String url, OAuthClientParams params) {
      super(url, params);
    }

    public MagizhchiTokenRequestBuilder setGrantType(GrantType grantType) {
      this.parameters.put(OAuth.OAUTH_GRANT_TYPE, grantType == null ? null : grantType.toString());
      return this;
    }

    public MagizhchiTokenRequestBuilder setClientId(String clientId) {
      this.parameters.put(OAuth.OAUTH_CLIENT_ID, clientId);
      return this;
    }

    public MagizhchiTokenRequestBuilder setClientSecret(String secret) {
      this.parameters.put(OAuth.OAUTH_CLIENT_SECRET, secret);
      return this;
    }

    public MagizhchiTokenRequestBuilder setUsername(String username) {
      this.parameters.put(OAuth.OAUTH_USERNAME, username);
      return this;
    }

    public MagizhchiTokenRequestBuilder setPassword(String password) {
      this.parameters.put(OAuth.OAUTH_PASSWORD, password);
      return this;
    }

    public MagizhchiTokenRequestBuilder setScope(String scope) {
      this.parameters.put(OAuth.OAUTH_SCOPE, scope);
      return this;
    }

    public MagizhchiTokenRequestBuilder setCode(String code) {
      this.parameters.put(OAuth.OAUTH_CODE, code);
      return this;
    }

    public MagizhchiTokenRequestBuilder setRedirectURI(String uri) {
      this.parameters.put(OAuth.OAUTH_REDIRECT_URI, uri);
      return this;
    }

    public MagizhchiTokenRequestBuilder setAssertion(String assertion) {
      this.parameters.put(OAuth.OAUTH_ASSERTION, assertion);
      return this;
    }

    public MagizhchiTokenRequestBuilder setAssertionType(String assertionType) {
      this.parameters.put(OAuth.OAUTH_ASSERTION_TYPE, assertionType);
      return this;
    }

    public MagizhchiTokenRequestBuilder setRefreshToken(String token) {
      this.parameters.put(OAuth.OAUTH_REFRESH_TOKEN, token);
      return this;
    }

    public MagizhchiTokenRequestBuilder setParameter(String paramName, String paramValue) {
      this.parameters.put(paramName, paramValue);
      return this;
    }


  }

}
