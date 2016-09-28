package com.magizhchi.arch.security.auth.client.provider;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import com.magizhchi.arch.security.auth.client.api.AuthClientResponseService;
import com.magizhchi.arch.security.auth.client.model.AuthClientResponse;
import com.magizhchi.arch.utilities.api.StringUtilities;

public class AuthClientResponseServiceImpl implements AuthClientResponseService {

  @Override
  public boolean isSuccessfulResponse(AuthClientResponse commandResponse) {
    
    boolean isSuccessful = false;

    // 1. Input validation

    // 2. Execution

    HttpResponse httpResponse = commandResponse.getResponse();

    int statusCode = httpResponse.getStatusLine().getStatusCode();

    if (statusCode == 200 || statusCode == 201 || statusCode == 202) isSuccessful = true;

    // 3. Return response
    return isSuccessful;
  }

  @Override
  public String getResponseContent(AuthClientResponse commandResponse) {
    
    String responseContent = StringUtils.EMPTY;

    // 1. Input validation

    // 2. Execution
    HttpEntity httpEntity = commandResponse.getResponse().getEntity();

    try {

      InputStream content = httpEntity.getContent();

      responseContent = StringUtilities.convertStreamToString(content);

    } catch (IOException e) {
      // TODO: Throw functional exception
      e.printStackTrace();
    }

    return responseContent;
  }

}
