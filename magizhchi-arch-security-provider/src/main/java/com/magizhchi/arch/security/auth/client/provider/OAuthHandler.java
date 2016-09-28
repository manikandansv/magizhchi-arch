package com.magizhchi.arch.security.auth.client.provider;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;

import com.magizhchi.arch.security.auth.client.api.AbstractOAuthHandler;
import com.magizhchi.arch.security.auth.client.api.AuthHandler;
import com.magizhchi.arch.security.auth.client.enums.ParameterStyle;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest.MagizhchiAuthenticationRequestBuilder;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest.MagizhchiTokenRequestBuilder;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientResponse;
import com.magizhchi.arch.security.auth.client.model.OAuthClientParams;

public class OAuthHandler
    implements
      AuthHandler<MagizhchiOAuthClientRequest, MagizhchiOAuthClientResponse>,
      AbstractOAuthHandler {

  @Override
  public int getSessionTimeout() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public MagizhchiOAuthClientResponse authenticateUser(MagizhchiOAuthClientRequest authClientRequest) {

    MagizhchiOAuthClientResponse oAuthClientResponse = null;

    // 1. Validate authClientRequest

    // 2. Execution

    OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

    try {

      if (authClientRequest.getoAuthClientParams().getGrantType().equals(GrantType.PASSWORD)
          || authClientRequest.getoAuthClientParams().getGrantType().equals(GrantType.CLIENT_CREDENTIALS)
          || authClientRequest.getoAuthClientParams().getGrantType().equals(GrantType.REFRESH_TOKEN)
          || (authClientRequest.getoAuthClientParams().getGrantType().equals(GrantType.AUTHORIZATION_CODE) && !authClientRequest
              .getoAuthClientParams().getResponseType().equals(ResponseType.CODE))) {

        OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(authClientRequest);

        oAuthClientResponse =
            new MagizhchiOAuthClientResponse.MagizhchiOAuthClientResponseBuilder(oAuthResponse).build();


      }

    } catch (OAuthSystemException | OAuthProblemException e) {



    }


    // 3. Return
    return oAuthClientResponse;
  }

  @Override
  public MagizhchiOAuthClientRequest buildAuthClientRequest(OAuthClientParams oAuthClientParams) {

    MagizhchiOAuthClientRequest oauthClientRequest = null;

    if (oAuthClientParams == null) {

      // TODO: Throw input exception

    }
    try {
      GrantType grantType = oAuthClientParams.getGrantType();

      if (grantType.equals(GrantType.AUTHORIZATION_CODE)) {

        if (oAuthClientParams.getResponseType().equals(ResponseType.CODE)) {

          MagizhchiAuthenticationRequestBuilder authRequestBuilder =
              MagizhchiOAuthClientRequest.authorizeLocation(oAuthClientParams.getAuthzEndpoint(), oAuthClientParams)
                  .setResponseType(ResponseType.CODE.toString()).setClientId(oAuthClientParams.getClientId())
                  .setRedirectURI(oAuthClientParams.getRedirectUri()).setScope(oAuthClientParams.getScope())
                  .setState(oAuthClientParams.getState()); // TODO: Need to check about
                                                           // approval_prompt & access_type

          oauthClientRequest = authRequestBuilder.buildQueryMessage(oauthClientRequest);

        } else {

          oauthClientRequest =
              MagizhchiOAuthClientRequest.authTokenLocation(oAuthClientParams.getTokenEndpoint(), oAuthClientParams)
                  .setCode(oAuthClientParams.getAuthzCode()).setGrantType(grantType)
                  .setClientId(oAuthClientParams.getClientId()).setClientSecret(oAuthClientParams.getClientSecret())
                  .setRedirectURI(oAuthClientParams.getRedirectUri()).setCode(oAuthClientParams.getAuthzCode())
                  .buildBodyMessage(oauthClientRequest);


        }

      } else if (grantType.equals(GrantType.PASSWORD)) {

        MagizhchiTokenRequestBuilder tokenRequestBuilder =
            MagizhchiOAuthClientRequest.authTokenLocation(oAuthClientParams.getTokenEndpoint(), oAuthClientParams)
                .setClientId(oAuthClientParams.getClientId()).setClientSecret(oAuthClientParams.getClientSecret());

        oauthClientRequest = tokenRequestBuilder.buildHeaderMessage(oauthClientRequest);

        tokenRequestBuilder.setGrantType(grantType).setUsername(oAuthClientParams.getUserName())
            .setPassword(oAuthClientParams.getPassword()).setScope(oAuthClientParams.getScope());

        if (oAuthClientParams.getParamStyle().equals(ParameterStyle.BODY)) {

          oauthClientRequest = tokenRequestBuilder.buildBodyMessage(oauthClientRequest);


        } else if (oAuthClientParams.getParamStyle().equals(ParameterStyle.JSON_BODY)) {

          oauthClientRequest = tokenRequestBuilder.buildJsonBodyMessage(oauthClientRequest);

        }

      } else if (grantType.equals(GrantType.CLIENT_CREDENTIALS)) {

        MagizhchiTokenRequestBuilder tokenRequestBuilder =
            MagizhchiOAuthClientRequest.authTokenLocation(oAuthClientParams.getTokenEndpoint(), oAuthClientParams)
                .setClientId(oAuthClientParams.getClientId()).setClientSecret(oAuthClientParams.getClientSecret());

        oauthClientRequest = tokenRequestBuilder.buildHeaderMessage(oauthClientRequest);

        tokenRequestBuilder.setGrantType(grantType).setUsername(oAuthClientParams.getUserName())
            .setPassword(oAuthClientParams.getPassword()).setScope(oAuthClientParams.getScope())
            .setClientId(oAuthClientParams.getClientId()).setClientSecret(oAuthClientParams.getClientSecret());

        oauthClientRequest = tokenRequestBuilder.buildQueryMessage(oauthClientRequest);



      } else if (grantType.equals(GrantType.IMPLICIT)) {

        // TODO

      } else if (grantType.equals(GrantType.REFRESH_TOKEN)) {

        MagizhchiTokenRequestBuilder tokenRequestBuilder =
            MagizhchiOAuthClientRequest.authTokenLocation(oAuthClientParams.getTokenEndpoint(), oAuthClientParams)
                .setClientId(oAuthClientParams.getClientId()).setClientSecret(oAuthClientParams.getClientSecret());

        oauthClientRequest = tokenRequestBuilder.buildHeaderMessage(oauthClientRequest);

        tokenRequestBuilder.setGrantType(grantType).setScope(oAuthClientParams.getScope())
            .setRefreshToken(oAuthClientParams.getRefreshToken()).setRedirectURI(oAuthClientParams.getRedirectUri());

        if (oAuthClientParams.getParamStyle().equals(ParameterStyle.BODY)) {

          oauthClientRequest = tokenRequestBuilder.buildBodyMessage(oauthClientRequest);


        } else if (oAuthClientParams.getParamStyle().equals(ParameterStyle.JSON_BODY)) {

          oauthClientRequest = tokenRequestBuilder.buildJsonBodyMessage(oauthClientRequest);

        }


      }
    } catch (OAuthSystemException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return oauthClientRequest;
  }
}
