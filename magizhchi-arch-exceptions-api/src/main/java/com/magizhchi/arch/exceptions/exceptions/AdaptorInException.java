package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class AdaptorInException extends AdaptorException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1587464055040173467L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class AdaptorInExceptionCode.
   */
  private static class AdaptorInExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new adaptor in exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public AdaptorInExceptionCode(String msgId, Level Level, CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  // ****************************************************************************
  // ** GENERAL ERRORS **
  // ****************************************************************************

  /** Error code: Adaptor incoming: Error occurred. */
  public static final AdaptorInExceptionCode DEFAULT_ERROR = getAdaptorInExceptionCode("DEFAULT_ERROR");
  // new AdaptorInExceptionCode("TTIAD001",
  // Level.ERROR, CompletionState.OK);

  /** Error code: Adaptor incoming: Configuration not present. */
  public static final AdaptorInExceptionCode CONFIGURATION_NOT_PRESENT = getAdaptorInExceptionCode("CONFIGURATION_NOT_PRESENT");
  //new AdaptorInExceptionCode("TTIAD002",
    //  Level.ERROR, CompletionState.OK);

  // ****************************************************************************
  // ** CORBA ERRORS **
  // ****************************************************************************

  /** Error code: CORBA Adaptor incoming: Configuration not present. */
  public static final AdaptorInExceptionCode CORBA_CONFIGURATION_NOT_PRESENT = getAdaptorInExceptionCode("CORBA_CONFIGURATION_NOT_PRESENT");
  //new AdaptorInExceptionCode("TTIAD101",    Level.ERROR, CompletionState.OK);

  // ****************************************************************************
  // ** MQ ERRORS **
  // ****************************************************************************

  /** Error code: MQ Adaptor incoming: Configuration not present. */
  public static final AdaptorInExceptionCode MQ_CONFIGURATION_NOT_PRESENT = getAdaptorInExceptionCode("MQ_CONFIGURATION_NOT_PRESENT");
  //new AdaptorInExceptionCode("TTIAD201",
    //  Level.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor inbound: Can NOT get service name from internal event message.
   */
  public static final AdaptorInExceptionCode MQ_INTERNAL_EVENT_NO_SERVICE_NAME = getAdaptorInExceptionCode("MQ_INTERNAL_EVENT_NO_SERVICE_NAME");
  //new AdaptorInExceptionCode("TTIAD202",
    //  Level.ERROR, CompletionState.OK);

  // taken from AdaptorPoisonMessageDetectedException.java:

  // /** Error code: MQ Adaptor inbound: Poison message detected. */
  // private static final AdaptorPoisonMessageDetectedExceptionCode
  // DEFAULT_ERROR = new AdaptorPoisonMessageDetectedExceptionCode(
  // "TTIAD203", ExceptionContext.ERROR, CompletionState.OK);

  /**
   * Error code: MQ Adaptor inbound: Received message is not of type TextMessage.
   */
  public static final AdaptorInExceptionCode MQ_MSG_NOT_TEXT = getAdaptorInExceptionCode("MQ_MSG_NOT_TEXT");
  //new AdaptorInExceptionCode("TTIAD204", Level.ERROR,
    //  CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * AdaptorInException(AdaptorInExceptionCode
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
  public AdaptorInException() {
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
	   * AdaptorInException(AdaptorInExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorIn DEFAULT_EXCEPTION_CODE,
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
  public AdaptorInException(String[] contextData) {
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
	   * AdaptorInException(AdaptorInExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorIn DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public AdaptorInException(Throwable cause) {
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
	   * AdaptorInException(AdaptorInExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default AdaptorIn DEFAULT_EXCEPTION_CODE,
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
  public AdaptorInException(String[] contextData, Throwable cause) {
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
	   * AdaptorInException(AdaptorInExceptionCode
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
  public AdaptorInException(AdaptorInExceptionCode exceptionCode) {
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
	   * AdaptorInException(AdaptorInExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorIn,
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
  public AdaptorInException(AdaptorInExceptionCode exceptionCode, String[] contextData) {
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
	   * AdaptorInException(AdaptorInExceptionCode
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
  public AdaptorInException(AdaptorInExceptionCode exceptionCode, Throwable cause) {
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
   * <LI>the given AdaptorInExceptionCode,
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
   * <LI>the given AdaptorInExceptionCode,
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
  public AdaptorInException(AdaptorInExceptionCode exceptionCode, String[] contextData, Throwable cause) {
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
  protected AdaptorInException(AbstractExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  private static AdaptorInExceptionCode getAdaptorInExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new AdaptorInExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
