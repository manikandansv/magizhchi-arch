package com.magizhchi.arch.communication.services.provider;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.magizhchi.arch.communication.model.MessageType;
import com.magizhchi.arch.communication.services.api.MessageTypeResolverService;

@Component
@Service
public class MessageTypeResolverServiceImpl implements MessageTypeResolverService {

  @Override
  public MessageType resolve(String fullConstantPath) {
    // TODO Auto-generated method stub
    return null;
  }

}
