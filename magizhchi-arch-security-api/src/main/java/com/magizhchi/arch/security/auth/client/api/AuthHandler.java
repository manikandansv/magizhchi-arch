package com.magizhchi.arch.security.auth.client.api;

import com.magizhchi.arch.security.auth.client.model.AuthClientResponse;



public interface AuthHandler<T extends Object, V extends AuthClientResponse> {

  int getSessionTimeout();

   V authenticateUser(T authClientRequest);

}
