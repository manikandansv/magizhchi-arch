package com.magizhchi.arch.security.auth.client.api;

import com.magizhchi.arch.security.auth.client.model.MagizhchiOAuthClientRequest;
import com.magizhchi.arch.security.auth.client.model.OAuthClientParams;

public interface AbstractOAuthHandler {

  MagizhchiOAuthClientRequest buildAuthClientRequest(OAuthClientParams oAuthClientParams);
 
  
}
