package com.magizhchi.arch.security.auth.client.model.params;

import java.util.Map;

import com.magizhchi.arch.security.auth.client.model.AuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;
import com.magizhchi.arch.utilities.api.AuthUtils;

public class BodyURLEncodedParametersApplier implements AuthParametersApplier {

  @Override
  public Object applyAuthParameters(Object authClientRequest, Map<String, Object> paramMap) {
    
    String body = AuthUtils.format(paramMap.entrySet(), "UTF-8");

    if (authClientRequest instanceof AuthClientRequest) {

      ((AuthClientRequest) authClientRequest).setBody(body);

    }else if (authClientRequest instanceof MagizhchiOAuthClientRequest){
      
      ((MagizhchiOAuthClientRequest) authClientRequest).setBody(body);
      
    }
    return authClientRequest;
  }
}
