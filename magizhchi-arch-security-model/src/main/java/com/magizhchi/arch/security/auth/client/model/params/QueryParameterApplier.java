package com.magizhchi.arch.security.auth.client.model.params;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.magizhchi.arch.security.auth.client.model.AuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;
import com.magizhchi.arch.utilities.api.AuthUtils;

public class QueryParameterApplier implements AuthParametersApplier {

  @Override
  public Object applyAuthParameters(Object authClientRequest, Map<String, Object> paramMap) {

    String messageUrl = StringUtils.EMPTY;

    if (authClientRequest instanceof AuthClientRequest) {
      AuthClientRequest genericAuthClientRequest = ((AuthClientRequest) authClientRequest);
      messageUrl = genericAuthClientRequest.getServerUrl();
      updateUrl(paramMap, messageUrl);
      genericAuthClientRequest.setServerUrl(messageUrl);
    } else if (authClientRequest instanceof MagizhchiOAuthClientRequest) {
      MagizhchiOAuthClientRequest oAuthClientRequest = ((MagizhchiOAuthClientRequest) authClientRequest);
      messageUrl = oAuthClientRequest.getLocationUri();
      updateUrl(paramMap, messageUrl);
      oAuthClientRequest.setLocationUri(messageUrl);
    }
    return authClientRequest;
  }

  private void updateUrl(Map<String, Object> paramMap, String messageUrl) {

    if (StringUtils.isNotEmpty(messageUrl)) {

      boolean containsQuestionMark = messageUrl.contains("?");

      StringBuilder url = new StringBuilder(messageUrl);

      StringBuilder query = new StringBuilder(AuthUtils.format(paramMap.entrySet(), "UTF-8"));

      if (!(AuthUtils.isEmpty(query.toString()))) {
        if (containsQuestionMark)
          url.append("&").append(query);
        else {
          url.append("?").append(query);
        }
      }

    }
  }

}
