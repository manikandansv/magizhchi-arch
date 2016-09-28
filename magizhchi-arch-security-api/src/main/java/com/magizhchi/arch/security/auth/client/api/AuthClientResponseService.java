package com.magizhchi.arch.security.auth.client.api;

import com.magizhchi.arch.security.auth.client.model.AuthClientResponse;

public interface AuthClientResponseService {

  boolean isSuccessfulResponse(AuthClientResponse commandResponse);

  String getResponseContent(AuthClientResponse commandResponse);

}
