package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class AdaptorOutException extends AdaptorException {

  /**
	 * 
	 */
  private static final long serialVersionUID = -7086983677959739969L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class AdaptorOutExceptionCode.
   */
  private static class AdaptorOutExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new adaptor out exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public AdaptorOutExceptionCode(String msgId, Level Level, CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  // ****************************************************************************
  // ** GENERAL ERRORS **
  // ****************************************************************************

  /** Error code: Adaptor outbound: Error occurred. */
  public static final AdaptorOutExceptionCode DEFAULT_ERROR = getAdaptorOutExceptionCode("DEFAULT_ERROR");
  // new AdaptorOutExceptionCode(
  // "TTOAD001", Level.ERROR, CompletionState.OK);

  /** Error code: Adaptor outbound: Configuration not present. */
  public static final AdaptorOutExceptionCode CONFIGURATION_NOT_PRESENT =
      getAdaptorOutExceptionCode("CONFIGURATION_NOT_PRESENT");
  // new AdaptorOutExceptionCode("TTOAD002", Level.ERROR, CompletionState.OK);

  // ****************************************************************************
  // ** MQ ERRORS **
  // ****************************************************************************

  /** Error code: MQ Adaptor outbound: Configuration not present. */
  public static final AdaptorOutExceptionCode MQ_CONFIGURATION_NOT_PRESENT =
      getAdaptorOutExceptionCode("MQ_CONFIGURATION_NOT_PRESENT");
  // new AdaptorOutExceptionCode("TTOAD201", Level.ERROR, CompletionState.OK);

  /** Error code: MQ Adaptor outbound: Could not put new message to MQ. */
  public static final AdaptorOutExceptionCode MQ_PUT_MESSAGE_FAILED = getAdaptorOutExceptionCode("MQ_PUT_MESSAGE_FAILED");
  // new AdaptorOutExceptionCode(
  // "TTOAD202", Level.ERROR, CompletionState.OK);

  /** Error code: MQ Adaptor outbound: Could not initialize MQQueueManager {0}. */
  public static final AdaptorOutExceptionCode MQ_QUEUE_MNGR_INITIALIZATION =
      getAdaptorOutExceptionCode("MQ_QUEUE_MNGR_INITIALIZATION");
  // new AdaptorOutExceptionCode("TTOAD203", Level.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor outbound: Could not initialize Queue {0} on MQQueueManager {1}.
   */
  public static final AdaptorOutExceptionCode MQ_QUEUE_INITIALIZATION = getAdaptorOutExceptionCode("MQ_QUEUE_INITIALIZATION");
  // new AdaptorOutExceptionCode("TTOAD204", Level.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor outbound: Send of MQ message failed.
   */
  public static final AdaptorOutExceptionCode MQ_MSG_SEND_FAILED = getAdaptorOutExceptionCode("MQ_MSG_SEND_FAILED");
  // new AdaptorOutExceptionCode(
  // "TTOAD206", Level.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor outbound: Cannot connect in MQ outbound bean.
   */
  public static final AdaptorOutExceptionCode MQ_OUTBOUND_BEAN_CONNECT_FAILED =
      getAdaptorOutExceptionCode("MQ_OUTBOUND_BEAN_CONNECT_FAILED");
  // new AdaptorOutExceptionCode("TTOAD207", Level.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor outbound: Cannot disconnect in MQ outbound bean.
   */
  public static final AdaptorOutExceptionCode MQ_OUTBOUND_BEAN_DISCONNECT_FAILED =
      getAdaptorOutExceptionCode("MQ_OUTBOUND_BEAN_DISCONNECT_FAILED");

  // new AdaptorOutExceptionCode("TTOAD208", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorOut(AdaptorOutExceptionCode
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
  public AdaptorOutException() {
    this(DEFAULT_ERROR, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorOut DEFAULT_EXCEPTION_CODE,
   * <LI>the exception context data contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public AdaptorOutException(String[] contextData) {
    this(DEFAULT_ERROR, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorOut DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public AdaptorOutException(Throwable cause) {
    this(DEFAULT_ERROR, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorOut DEFAULT_EXCEPTION_CODE,
   * <LI>the exception context data contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause A previous caught Exception
   */
  public AdaptorOutException(String[] contextData, Throwable cause) {
    this(DEFAULT_ERROR, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorOut,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public AdaptorOutException(AdaptorOutExceptionCode exceptionCode) {
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
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorOut,
   * <LI>the exception context data contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public AdaptorOutException(AdaptorOutExceptionCode exceptionCode, String[] contextData) {
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
	   * AdaptorOut(AdaptorOutExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorOut,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public AdaptorOutException(AdaptorOutExceptionCode exceptionCode, Throwable cause) {
    this(exceptionCode, null, cause);
  }

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorOutExceptionCode,
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
   * <LI>the given AdaptorOut,
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
  public AdaptorOutException(AdaptorOutExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
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
	   * AdaptorException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
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
  protected AdaptorOutException(AbstractExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  private static AdaptorOutExceptionCode getAdaptorOutExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new AdaptorOutExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
