package com.magizhchi.arch.exceptions.models;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;

public class ChannelBasedSeverityMapper {

  /** Channel name */
  private String channelName;

  /** Message ID */
  private String msgId;

  /** Severity */
  private Level severityLevel;

  /** Completion state */
  private CompletionState completionState = CompletionState.UNDEFINED;

  /**
   * Default constructor.
   */
  public ChannelBasedSeverityMapper() {}



  public Level getSeverityLevel() {
    return severityLevel;
  }



  public void setSeverityLevel(Level severityLevel) {
    this.severityLevel = severityLevel;
  }



  /**
   * Returns completion state.
   * 
   * @return completion state
   */
  public CompletionState getCompletionState() {
    return completionState;
  }

  /**
   * Sets completion state. Used by Spring DI.
   * 
   * @param completionState completion state
   */
  public void setCompletionState(CompletionState completionState) {
    this.completionState = completionState;
  }

  /**
   * Returns channel name.
   * 
   * @return channel name
   */
  public String getChannelName() {
    return channelName;
  }

  /**
   * Sets channel name. Used by Spring DI.
   * 
   * @param channelName channel name
   */
  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  /**
   * Returns message ID.
   * 
   * @return message ID
   */
  public String getMsgId() {
    return msgId;
  }

  /**
   * Sets message ID. Used by Spring DI.
   * 
   * @param msgId message ID
   */
  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

}
