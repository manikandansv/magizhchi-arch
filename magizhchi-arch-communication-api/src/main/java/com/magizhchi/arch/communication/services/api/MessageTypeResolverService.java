package com.magizhchi.arch.communication.services.api;

import com.magizhchi.arch.communication.model.MessageType;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface MessageTypeResolverService {

  MessageType resolve(String fullConstantPath);

}
