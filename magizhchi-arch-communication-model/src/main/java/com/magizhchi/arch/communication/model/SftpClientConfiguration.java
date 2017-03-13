package com.magizhchi.arch.communication.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.utilities.api.PropertiesUtil;

public class SftpClientConfiguration {
  
  public static final String SFTP_CLIENTID = "sftp.clientId";

  public static final String SFTP_HOST = "sftp.host";

  public static final String SFTP_PORT = "sftp.port";

  public static final String SFTP_USERNAME = "sftp.userName";

  public static final String SFTP_PASSWORD = "sftp.password";

  public static final String SFTP_RESOURCE_PATH = "sftp.resourcePath";

  public static final String SFTP_FILENAME = "sftp.fileName";

  public static final String KEY_TIMEOUT = "sftp.keyTimeOut";

  public static final String CONNECT_TIMEOUT = "sftp.connectTimeOut";

  public static final String MAX_BUFFER = "sftp.maxBuffer";
  
  private String sftpHost;
  
  private Integer sftpPort;
  
  private String sftpUsername;
  
  private String sftpPassword;
  
  private String sftpResourcePath;
  
  private String sftpFileName;
  
  private Integer sftpKeyTimeout;
  
  private Integer sftpConnectTimeout;
  
  private Integer sftpMaxBuffer;
  
  private String sftpClientId;
  
  @Activate
  protected void activate(ComponentContext ctx){
    this.sftpClientId = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_CLIENTID), StringUtils.EMPTY);
    this.sftpHost = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_HOST), StringUtils.EMPTY);
    this.sftpPort = PropertiesUtil.toInteger(ctx.getBundleContext().getProperty(SFTP_PORT), 0);
    this.sftpUsername = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_USERNAME), StringUtils.EMPTY);
    this.sftpPassword = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_PASSWORD), StringUtils.EMPTY);
    this.sftpResourcePath = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_RESOURCE_PATH), StringUtils.EMPTY);
    this.sftpFileName = PropertiesUtil.toString(ctx.getBundleContext().getProperty(SFTP_RESOURCE_PATH), StringUtils.EMPTY);
    this.sftpKeyTimeout = PropertiesUtil.toInteger(ctx.getBundleContext().getProperty(KEY_TIMEOUT), 0);
    this.sftpConnectTimeout = PropertiesUtil.toInteger(ctx.getBundleContext().getProperty(CONNECT_TIMEOUT), 0);
    this.sftpMaxBuffer = PropertiesUtil.toInteger(ctx.getBundleContext().getProperty(MAX_BUFFER), 0);
  }
  
  public String getSftpClientId() {
    return sftpClientId;
  }

  public String getSftpHost() {
    return sftpHost;
  }

  public Integer getSftpPort() {
    return sftpPort;
  }

  public String getSftpUsername() {
    return sftpUsername;
  }

  public String getSftpPassword() {
    return sftpPassword;
  }

  public String getSftpResourcePath() {
    return sftpResourcePath;
  }

  public String getSftpFileName() {
    return sftpFileName;
  }

  public Integer getSftpKeyTimeout() {
    return sftpKeyTimeout;
  }

  public Integer getSftpConnectTimeout() {
    return sftpConnectTimeout;
  }

  public Integer getSftpMaxBuffer() {
    return sftpMaxBuffer;
  }

}
