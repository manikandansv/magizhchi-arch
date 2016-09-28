package com.magizhchi.arch.communication.model;

import java.util.Arrays;
import java.util.List;

/**
 * The Class Request. Container class for information concerning the actual request
 * 
 * @author manisv
 *
 */
public class MagizhchiInboundRequest extends AbstractMessage {

  /**
	 * 
	 */
  private static final long serialVersionUID = -2061739442137669136L;

  /** The content list. */
  private List<?> contentList;

  /** The session id. */
  private String sessionId;

  /** The set id. */
  private int setId = 0;

  /** The time sent. */
  private long timeSent = 0;

  /** Channel that initiated this request */
  private ChannelInfo channel;

  /**
   * @return the contentList
   */
  public List<?> getContentList() {
    return contentList;
  }

  /**
   * @param contentList the contentList to set
   */
  public void setContentList(List<?> contentList) {
    this.contentList = contentList;
  }

  /**
   * Gets the content of the first parameter.
   * 
   * @return the content
   */
  public Object getContent() {
    return getContent(0);
  }

  /**
   * Gets the content of the parameter with index idx. If parameter with the given index does not
   * exist null value is returned.
   * 
   * @param idx index of the parameter to be returned
   * @return the content
   */
  public Object getContent(int idx) {
    if (contentList == null || contentList.isEmpty()) {
      return null;
    }
    if (idx < 0 || idx >= contentList.size()) {
      return null;
    }
    return contentList.get(idx);
  }

  /**
   * Sets the content.
   * 
   * @param content the request content
   */
  public void setContent(Object content) {
    this.contentList = Arrays.asList(new Object[] {content});
  }

  /**
   * Gets the session id.
   * 
   * @return the session id
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Sets the session id.
   * 
   * @param sessionId the new session id
   */
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  /**
   * Gets the sets the id.
   * 
   * @return the sets the id
   */
  public int getSetId() {
    return setId;
  }

  /**
   * Sets the sets the id.
   * 
   * @param setId the new sets the id
   */
  public void setSetId(int setId) {
    this.setId = setId;
  }

  /**
   * Gets the time sent.
   * 
   * @return the time sent
   */
  public long getTimeSent() {
    return timeSent;
  }

  /**
   * Sets the time sent.
   * 
   * @param timeSent the new time sent
   */
  public void setTimeSent(long timeSent) {
    this.timeSent = timeSent;
  }

  /**
   * Returns current channel information identifying the channel initiated this request.
   * 
   * @return channel information
   */
  public ChannelInfo getChannel() {
    return channel;
  }

  /**
   * Sets current channel information identifying the channel initiated this request.
   * 
   * @param channel channel information
   */
  public void setChannel(ChannelInfo channel) {
    this.channel = channel;
  }

}
