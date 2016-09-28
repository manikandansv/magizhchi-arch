package com.magizhchi.arch.security.auth.client.model.params;

import java.util.Map;

import org.apache.oltu.oauth2.common.utils.JSONUtils;

import com.magizhchi.arch.security.auth.client.model.AuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;

public class JSONBodyParametersApplier implements AuthParametersApplier {

  @Override
  public Object applyAuthParameters(Object authClientRequest, Map<String, Object> paramMap) {
    String json = null;

    json = JSONUtils.buildJSON(paramMap);
    if (authClientRequest instanceof AuthClientRequest) {

      ((AuthClientRequest) authClientRequest).setBody(json);

    } else if (authClientRequest instanceof MagizhchiOAuthClientRequest) {

      ((MagizhchiOAuthClientRequest) authClientRequest).setBody(json);

    }

    return authClientRequest;

  }

}
