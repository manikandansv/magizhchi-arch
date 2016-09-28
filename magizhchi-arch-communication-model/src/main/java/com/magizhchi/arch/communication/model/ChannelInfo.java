package com.magizhchi.arch.communication.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author manisv
 *
 */
public class ChannelInfo implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = -1842636721256552354L;

  /** Default channel name */
  public static final String DEFAULT_CHANNEL_NAME = "N/A";

  /** Default location */
  public static final String DEFAULT_LOCATION = "CH";

  /** Name of the channel */
  private String channelName;

  /** Location of the channel (e.g. CH, US or etc.) */
  private String location;

  /**
   * Default constructor
   */
  public ChannelInfo() {
    this.channelName = DEFAULT_CHANNEL_NAME;
    this.location = DEFAULT_LOCATION;
  }

  /**
   * Constructor
   * 
   * @param channelName channel name to be used
   */
  public ChannelInfo(String channelName) {
    this.channelName = channelName;
    this.location = DEFAULT_LOCATION;
  }

  /**
   * Returns channel name
   * 
   * @return channel name
   */
  public String getChannelName() {
    return channelName;
  }

  /**
   * Sets channel name
   * 
   * @param channelName channel name to be set
   */
  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  /**
   * Returns location
   * 
   * @return location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Sets location
   * 
   * @param location location to be set
   */
  public void setLocation(String location) {
    this.location = location;
  }

}
