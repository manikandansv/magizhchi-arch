package com.magizhchi.arch.exceptions.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;
import com.magizhchi.arch.exceptions.notifications.Notification;

/**
 * 
 * @author manisv
 *
 */
public class ValidationException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = -2649491438349769178L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /** Container for notifications handed over by a ValidationException */
  private List<Notification> notificationList;

  /**
   * The Class ValidationExceptionCode.
   */
  private static class ValidationExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new validation exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severityLevel
     * @param completionState completion state
     */
    public ValidationExceptionCode(String msgId, Level severityLevel, CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /** Error code: Input object did not pass VO validation. */
  public static final ValidationExceptionCode VALIDATION_FAILED = getValidationExceptionCode("VALIDATION_FAILED");

  // new ValidationExceptionCode(
  // "TTVAL001", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default exception code DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   */
  public ValidationException() {
    this(VALIDATION_FAILED, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default ValidationExceptionCode DEFAULT_EXCEPTION_CODE,
   * <LI>the exception context data contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independant messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public ValidationException(String[] contextData) {
    this(VALIDATION_FAILED, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default ValidationExceptionCode DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous catched Exception
   */
  public ValidationException(Throwable cause) {
    this(VALIDATION_FAILED, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default ValidationExceptionCode DEFAULT_EXCEPTION_CODE,
   * <LI>the exception context data contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independant messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause A previous catched Exception
   */
  public ValidationException(String[] contextData, Throwable cause) {
    this(VALIDATION_FAILED, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given ValidationExceptionCode,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public ValidationException(ValidationExceptionCode exceptionCode) {
    this(exceptionCode, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given ValidationExceptionCode,
   * <LI>the exception context data contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independant messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public ValidationException(ValidationExceptionCode exceptionCode, String[] contextData) {
    this(exceptionCode, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ValidationException(ValidationExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given ValidationExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous catched Exception
   */
  public ValidationException(ValidationExceptionCode exceptionCode, Throwable cause) {
    this(exceptionCode, null, cause);
  }

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously catched Throwable.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * TechnicalException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given ValidationExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * </PRE>
   * 
   * </P> with the following parameter:
   * <P>
   * <UL>
   * <LI>the given ValidationExceptionCode,
   * <LI>the exception context data contextData,
   * <LI>previously catched Throwable t
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independant messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  public ValidationException(ValidationExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  /**
   * Getter for Notification list
   * 
   * @return notificationList
   */
  public List<Notification> getNotificationList() {
    return notificationList;
  }

  /**
   * Setter for notificationList
   * 
   * @param notificationList list with elements type of Notification added to the local
   *        Notification-ArrayList
   */
  public void setNotificationList(Collection<Notification> notificationList) {
    if (this.notificationList == null) {
      this.notificationList = new ArrayList<Notification>();
    }
    this.notificationList.addAll(notificationList);
  }

  private static ValidationExceptionCode getValidationExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new ValidationExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
