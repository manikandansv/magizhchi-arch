package com.magizhchi.arch.security.auth.client.model.params;

import java.util.Map;

import org.apache.http.HttpHeaders;

import com.magizhchi.arch.security.auth.client.model.AuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;
import com.magizhchi.arch.utilities.api.AuthUtils;

public class ClientHeaderParametersApplier implements AuthParametersApplier {

  @Override
  public Object applyAuthParameters(Object authClientRequest, Map<String, Object> paramMap) {

    String header = AuthUtils.encodeAuthorizationBearerHeader(paramMap);
    if (authClientRequest instanceof AuthClientRequest) {
      
      ((AuthClientRequest) authClientRequest).addHeader(HttpHeaders.AUTHORIZATION, header);
      
    } else if (authClientRequest instanceof MagizhchiOAuthClientRequest) {

      ((MagizhchiOAuthClientRequest) authClientRequest).addHeader(HttpHeaders.AUTHORIZATION, header);

    }

    return authClientRequest;
  }

}
