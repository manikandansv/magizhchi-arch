package com.magizhchi.arch.exceptions.exceptions;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;
import com.magizhchi.arch.exceptions.utils.ExceptionUtils;

/**
 * 
 * @author manisv
 *
 */

public class BaseException extends Exception {

  /**
	 * 
	 */
  private static final long serialVersionUID = 6899206215456710521L;

  /** Completion state */
  private CompletionState completionState = CompletionState.UNDEFINED;

  /** Severity level */
  private Level severityLevel;

  private String messageId;

  /**
   * (Semi-)Unique exception ID which is different for every instance of this class
   */
  private String uniqueExceptionId;

  private String[] contextData;

  public BaseException() {}

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * @param msgId The unique 8-character message Id (e.g. "OT123456").
   * @param severityLevel The severity level.
   * @param completionState The completion state which marks whether correction is required or not.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  protected BaseException(String msgId, Level severityLevel, CompletionState completionState, String[] contextData,
      Throwable cause) {

    super(cause);

    this.messageId = msgId;
    this.contextData = contextData;
    this.severityLevel = severityLevel;
    this.completionState = completionState;

    if (ExceptionUtils.getInstance() != null) {
      this.uniqueExceptionId = ExceptionUtils.getInstance().createSemiUniqueId();
    }
  }

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * This constructor needs to be defined only for exceptions that can be extended.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	 * 
	 * CoreException(severity, message ID, String[] contextData,
	 * Throwable cause)
	 * 
	 * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given exceptionCode,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * </PRE>
   * 
   * </P> with the following parameter:
   * <P>
   * <UL>
   * <LI>the given exceptionCode,
   * <LI>the exception context data contextData,
   * <LI>previously caught Throwable t
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  protected BaseException(AbstractExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    this(exceptionCode.getMsgId(), exceptionCode.getSeverityLevel(), exceptionCode.getCompletionState(), contextData,
        cause);
  }

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param customSeverityLevel custom severity level (other than the modeled one)
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  protected BaseException(AbstractExceptionCode exceptionCode, Level customSeverityLevel, String[] contextData,
      Throwable cause) {
    this(exceptionCode.getMsgId(), customSeverityLevel, exceptionCode.getCompletionState(), contextData, cause);
  }

  /**
   * @return the severityLevel
   */
  public Level getSeverityLevel() {
    return severityLevel;
  }

  /**
   * Returns completion state.
   * 
   * @return completion state
   */
  public CompletionState getCompletionState() {
    return this.completionState;
  }

  /**
   * @return the uniqueExceptionId
   */
  public String getUniqueExceptionId() {
    return uniqueExceptionId;
  }

  public String[] getContextData() {
    return contextData;
  }

  public void setContextData(String[] contextData) {
    this.contextData = contextData;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public void setSeverityLevel(Level severityLevel) {
    this.severityLevel = severityLevel;
  }

  public void setUniqueExceptionId(String uniqueExceptionId) {
    this.uniqueExceptionId = uniqueExceptionId;
  }



}
