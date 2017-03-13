package com.magizhchi.arch.communication.services.api;

import com.magizhchi.arch.communication.model.SftpClientConfiguration;

public interface SftpClientConfigFactory {

  SftpClientConfiguration getSftpClientConfiguration(String sftpClientId);
  
}
