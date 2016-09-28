package com.magizhchi.arch.communication.services.provider;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import com.magizhchi.arch.communication.model.HttpClientResponse;
import com.magizhchi.arch.communication.services.api.HttpClientResponseService;
import com.magizhchi.arch.utilities.api.StringUtilities;

@Component(immediate = true, enabled=true)
@Service
public class HttpClientResponseServiceImpl implements HttpClientResponseService {

  @Override
  public boolean isSuccessfulResponse(HttpClientResponse commandResponse) {

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
  public String getResponseContent(HttpClientResponse commandResponse) {

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
