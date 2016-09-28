package com.magizhchi.arch.communication.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The class Response
 * 
 * @author manisv
 *
 */
public class MagizhchiOutboundResponse extends AbstractMessage {

  /**
	 * 
	 */
  private static final long serialVersionUID = -6145526372228865404L;

  /** The content. */
  private Object content;

  /** Whether response represents exception (not successful) */
  private boolean exceptionResponse = false;

  /** The response session IDs. */
  private List<String> responseSessionIds = null;

  /** The client side duration. */
  private long clientSideDuration;

  /** The service execution duration. */
  private long serviceExecutionDuration;

  /**
   * Gets the content.
   * 
   * @return the content
   */
  public Object getContent() {
    return content;
  }

  /**
   * Sets the content.
   * 
   * @param content the new content
   */
  public void setContent(Object content) {
    this.content = content;
  }

  /**
   * Returns whether response object represents exception response
   * 
   * @return true - exception response, otherwise - false
   */
  public boolean isExceptionResponse() {
    return exceptionResponse;
  }

  /**
   * Sets that response object represents exception response
   */
  public void setExceptionResponse() {
    this.exceptionResponse = true;
  }

  /**
   * Gets the response session IDs.
   * 
   * @return the response session IDs
   */
  public List<String> getResponseSessionIds() {
    return responseSessionIds;
  }

  /**
   * Sets the response session IDs.
   * 
   * @param responseSessionIds the new response session IDs
   */
  public void setResponseSessionIds(List<String> responseSessionIds) {
    this.responseSessionIds = responseSessionIds;
  }

  /**
   * Creates the response session IDs list.
   */
  private void createResponseSessionIdsList() {
    responseSessionIds = new ArrayList<String>();
  }

  /**
   * Adds the response session ID.
   * 
   * @param sessionId the session ID
   */
  public void addResponseSessionId(String sessionId) {

    if (responseSessionIds == null) {
      createResponseSessionIdsList();
    }
    responseSessionIds.add(sessionId);
  }

  /**
   * Clear response session ID.
   */
  public void clearResponseSessionId() {
    if (responseSessionIds == null) {
      return;
    }
    responseSessionIds.clear();
  }

  /**
   * Gets the client side duration.
   * 
   * @return the client side duration
   */
  public long getClientSideDuration() {
    return clientSideDuration;
  }

  /**
   * Sets the client side duration.
   * 
   * @param clientSideDuration the new client side duration
   */
  public void setClientSideDuration(long clientSideDuration) {
    this.clientSideDuration = clientSideDuration;
  }

  /**
   * Gets the service execution duration.
   * 
   * @return the service execution duration
   */
  public long getServiceExecutionDuration() {
    return serviceExecutionDuration;
  }

  /**
   * Sets the service execution duration.
   * 
   * @param serviceExecutionDuration the new service execution duration
   */
  public void setServiceExecutionDuration(long serviceExecutionDuration) {
    this.serviceExecutionDuration = serviceExecutionDuration;
  }

}
