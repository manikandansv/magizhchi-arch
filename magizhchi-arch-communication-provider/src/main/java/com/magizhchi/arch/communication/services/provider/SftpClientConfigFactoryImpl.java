package com.magizhchi.arch.communication.services.provider;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.cm.ConfigurationAdmin;

import com.magizhchi.arch.communication.model.SftpClientConfiguration;
import com.magizhchi.arch.communication.services.api.SftpClientConfigFactory;

public class SftpClientConfigFactoryImpl implements SftpClientConfigFactory {

  @Reference
  private ConfigurationAdmin configAdmin;

  private final static String KEY_PROPERTY = "sftp.clientId";

  private final Map<String, SftpClientConfiguration> map = new HashMap<String, SftpClientConfiguration>();

  @Override
  public SftpClientConfiguration getSftpClientConfiguration(String sftpClientId) {
    return null;
  }

  protected void bindSftpClientConfiguration(final SftpClientConfiguration config, final Map<String, Object> properties) {

    synchronized (this.map) {

      String key = (String) properties.get(KEY_PROPERTY);

      map.put(key, config);


    }
  }

  protected void unbindSftpClientConfiguration(final SftpClientConfiguration config) {

    synchronized (this.map) {

      map.remove(config);
    }

  }

}
