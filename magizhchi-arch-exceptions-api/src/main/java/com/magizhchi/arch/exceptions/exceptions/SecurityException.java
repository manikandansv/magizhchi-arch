package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

/**
 * 
 * 
 * @author manisv
 *
 */
public class SecurityException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = -2675688515721849099L;
  
  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class SecurityExceptionCode.
   */
  private static class SecurityExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new security exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public SecurityExceptionCode(String msgId, Level Level,
        CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  /** The Constant DEFAULT_EXCEPTION_CODE. */
  public static final SecurityExceptionCode DEFAULT_EXCEPTION_CODE = getSecurityExceptionCode("DEFAULT_EXCEPTION_CODE"); 
  //new SecurityExceptionCode(
    //  "TTSEC001", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * SecurityException(SecurityException
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
  public SecurityException() {
    this(DEFAULT_EXCEPTION_CODE, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default SecurityException DEFAULT_EXCEPTION_CODE,
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
  public SecurityException(String[] contextData) {
    this(DEFAULT_EXCEPTION_CODE, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default SecurityException DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public SecurityException(Throwable cause) {
    this(DEFAULT_EXCEPTION_CODE, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default SecurityException DEFAULT_EXCEPTION_CODE,
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
  public SecurityException(String[] contextData, Throwable cause) {
    this(DEFAULT_EXCEPTION_CODE, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given SecurityException,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public SecurityException(SecurityExceptionCode exceptionCode) {
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
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given SecurityException,
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
  public SecurityException(SecurityExceptionCode exceptionCode, String[] contextData) {
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
	   * SecurityException(SecurityException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given SecurityException,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public SecurityException(SecurityExceptionCode exceptionCode, Throwable cause) {
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
	   * TechnicalException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given SecurityException,
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
   * <LI>the given SecurityException,
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
  public SecurityException(SecurityExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }
  
  private static SecurityExceptionCode getSecurityExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new SecurityExceptionCode(abstractExceptionCode.getMsgId(),
        abstractExceptionCode.getSeverityLevel(), abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
