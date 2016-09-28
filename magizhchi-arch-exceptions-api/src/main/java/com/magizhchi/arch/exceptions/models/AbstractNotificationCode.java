package com.magizhchi.arch.exceptions.models;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;

/**
 * AbstractNotificationCode represents the error code (msgId), the corresponding severity and the
 * completion state.
 * 
 * @author manisv
 *
 */
public class AbstractNotificationCode extends AbstractExceptionCode {

  /**
   * The Constructor.
   * 
   * @param msgId messageID which refers to the message in the message file.
   * @param severityLevel exception severity level
   * @param completionState completion state
   */
  public AbstractNotificationCode(String msgId, Level severityLevel,
      CompletionState completionState) {
    super(msgId, severityLevel, completionState);

  }

}
