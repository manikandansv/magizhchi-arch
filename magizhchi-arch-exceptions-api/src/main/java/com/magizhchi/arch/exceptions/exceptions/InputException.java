package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class InputException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 653926808187146933L;
  
  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class InputExceptionCode.
   */
  private static class InputExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new persistence exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public InputExceptionCode(String msgId, Level Level,
        CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  /** Error code: Invalid input: {0}. */
  public static final InputExceptionCode NULL_VALUE_PASSED = getDataMappingExceptionCode("NULL_VALUE_PASSED");
  //new InputExceptionCode("TTCMN001",    Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * InputException(InputExceptionCode
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
  public InputException() {
    this(NULL_VALUE_PASSED, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default InputException DEFAULT_EXCEPTION_CODE,
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
  public InputException(String[] contextData) {
    this(NULL_VALUE_PASSED, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default InputExceptionCode DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public InputException(Throwable cause) {
    this(NULL_VALUE_PASSED, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default InputException DEFAULT_EXCEPTION_CODE,
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
  public InputException(String[] contextData, Throwable cause) {
    this(NULL_VALUE_PASSED, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given InputException,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public InputException(InputExceptionCode exceptionCode) {
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
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given InputException,
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
  public InputException(InputExceptionCode exceptionCode, String[] contextData) {
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
	   * InputException(InputExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given InputExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public InputException(InputExceptionCode exceptionCode, Throwable cause) {
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
   * <LI>the given InputException,
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
   * <LI>the given InputException,
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
  public InputException(InputExceptionCode exceptionCode, String[] contextData, Throwable cause) {
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
	   * TechnicalException(AbstractExceptionCode exceptionCode, String[] contextData,
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
  protected InputException(AbstractExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }
  
  private static InputExceptionCode getDataMappingExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new InputExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
