package com.magizhchi.arch.communication.services.api;

import com.magizhchi.arch.communication.model.HttpClientResponse;

public interface HttpClientResponseService {

  boolean isSuccessfulResponse(HttpClientResponse commandResponse);

  String getResponseContent(HttpClientResponse commandResponse);

}
