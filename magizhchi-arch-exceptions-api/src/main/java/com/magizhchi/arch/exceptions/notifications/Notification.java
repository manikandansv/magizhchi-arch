package com.magizhchi.arch.exceptions.notifications;

import java.io.Serializable;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractNotificationCode;

/**
 * 
 * @author manisv
 *
 */
public class Notification implements Comparable<Notification>, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3453291501542389668L;

  /** completion state */
  private CompletionState completionState;

  /** severity level */
  private Level Level;

  /**
   * names of field which hold the data which is the reason of the notification
   */
  private String[] fieldNames;


  private String msgId;

  private long timestamp;

  private String[] contextData;

  /**
   * Notification code of the given notification.
   * 
   * @author OFIP TA
   */
  public static class NotificationCode extends AbstractNotificationCode {

    /**
     * Constructor.
     * 
     * @param msgId used message Id (example "OT12345")
     * @param Level severity level of the notification
     * @param completionState completion state of the notification
     */
    public NotificationCode(String msgId, Level Level, CompletionState completionState) {
      super(msgId, Level, completionState);

    }
  }

  /**
   * Constructor.
   * 
   * @param msgId The unique 8-character JAP message Id (e.g. "OT123456").
   * @param Level The severity level.
   * @param completionState The completion state which marks whether correction is required or not.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param fieldNames The names of data field which are related to the notification.
   */
  public Notification(String msgId, Level Level, CompletionState completionState,
      String[] contextData, String[] fieldNames) {

    this.msgId = msgId;
    this.contextData = contextData;
    this.Level = Level;
    this.completionState = completionState;
    this.fieldNames = fieldNames;
  }

  /**
   * Constructor.
   * 
   * @param notificationCode notification code
   */
  public Notification(NotificationCode notificationCode) {
    this(notificationCode.getMsgId(), notificationCode.getLevel(), notificationCode.getCompletionState(), null);
  }

  /**
   * Constructor.
   * 
   * @param notificationCode notification code
   * @param contextData notification context
   */
  public Notification(NotificationCode notificationCode, String[] contextData) {
    this(notificationCode.getMsgId(), notificationCode.getLevel(), notificationCode.getCompletionState(), contextData);
  }

  /**
   * Constructor.
   * 
   * @param notificationCode notification code
   * @param contextData notification context
   * @param fieldNames field names
   */
  public Notification(NotificationCode notificationCode, String[] contextData, String[] fieldNames) {
    this(notificationCode.getMsgId(), notificationCode.getLevel(), notificationCode.getCompletionState(), contextData,
        fieldNames);
  }

  /**
   * Constructor.
   * 
   * @param msgId The unique 8-character JAP message Id (e.g. "OT123456").
   * @param Level The severity level.
   * @param completionState The completion state which marks whether correction is required or not.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public Notification(String msgId, Level Level, CompletionState completionState, String[] contextData) {
    this(msgId, Level, completionState, contextData, null);
  }


  @Override
  public int compareTo(Notification o) {

    // Compare message ID's
    int messageIdDiff = this.getMsgId().compareTo(o.getMsgId());
    if (messageIdDiff != 0) {
      return messageIdDiff;
    }

    // message ID's are equal, compare severity TODO
    // int severityDiff = this.getLevel().toInt().compareTo(o.getLevel());
    // if (severityDiff != 0) {
    // return severityDiff;
    // }
    // Message ID's and severity are equal, compare completion state
    return completionState.compareTo(o.getCompletionState());
  }

  public CompletionState getCompletionState() {
    return completionState;
  }

  public void setCompletionState(CompletionState completionState) {
    this.completionState = completionState;
  }

  public Level getLevel() {
    return Level;
  }

  public void setLevel(Level Level) {
    this.Level = Level;
  }

  public String[] getFieldNames() {
    return fieldNames;
  }

  public void setFieldNames(String[] fieldNames) {
    this.fieldNames = fieldNames;
  }

  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String[] getContextData() {
    return contextData;
  }

  public void setContextData(String[] contextData) {
    this.contextData = contextData;
  }



}
