package com.magizhchi.arch.exceptions.models;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;

/**
 * 
 * @author manisv
 *
 */
public class AbstractExceptionCode {

  /** The message id. */
  private String msgId;

  /** The severity. */
  private Level severityLevel;

  /** The CompletionState */
  private CompletionState completionState;

  /**
   * Constructor.
   * 
   * @param msgId message id
   * @param severityLevel message severity level
   * @param completionState completion state
   */
  public AbstractExceptionCode(String msgId, Level severityLevel,
      CompletionState completionState) {
    this.msgId = msgId;
    this.severityLevel = severityLevel;
    this.completionState = completionState;
  }

  /**
   * Get message id.
   * 
   * @return message id
   */
  public String getMsgId() {
    return msgId;
  }

  /**
   * Get Log4J severity. Severity is not stored directly, but is a sub-part of
   * <code>severityLevel</code>.
   * 
   * @return severity
   */
  public Level getLevel() {
    return (severityLevel == null) ? null : severityLevel;
  }

  /**
   * Get severity level.
   * 
   * @return severity level
   */
  public Level getSeverityLevel() {
    return severityLevel;
  }

  /**
   * Get completion state
   * 
   * @return completionState
   */
  public CompletionState getCompletionState() {
    return this.completionState;
  }

  /**
   * Set completion state
   * 
   * @param completionState Completion state to set
   */
  public void setCompletionState(CompletionState completionState) {
    this.completionState = completionState;
  }

}
