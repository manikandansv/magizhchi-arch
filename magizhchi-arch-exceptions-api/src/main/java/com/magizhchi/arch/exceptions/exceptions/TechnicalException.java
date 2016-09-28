package com.magizhchi.arch.exceptions.exceptions;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

/**
 * 
 * @author manisv
 *
 */
public class TechnicalException extends BaseRunTimeException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 4901183114368573356L;

  /**
   * The Class TechnicalExceptionCode.
   */
  private static class TechnicalExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new technical exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severity level
     * @param completionState completion state
     */
    public TechnicalExceptionCode(String msgId, Level severityLevel,
        CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /** The Constant EXPRESSION_PROCESS_ERROR. */
  public static final TechnicalExceptionCode EXPRESSION_PROCESS_ERROR = new TechnicalExceptionCode(
      "TTOCF001", Level.ERROR, CompletionState.OK);

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * TechnicalException(TOMTechnicalExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default TechnicalExceptionCode DEFAULT_EXCEPTION_CODE,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public TechnicalException(Throwable cause) {
    this(EXPRESSION_PROCESS_ERROR, null, cause);
  }

  /**
   * This constructor is defined to allow correct inheritance of exception classes.
   * 
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * Exception(TechnicalExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given TechnicalExceptionCode,
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
   * <LI>the given TechnicalExceptionCode,
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
  public TechnicalException(AbstractExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  /**
   * This constructor is defined to allow correct inheritance of exception classes.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param customSeverityLevel custom severity level
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  public TechnicalException(AbstractExceptionCode exceptionCode, Level customSeverityLevel,
      String[] contextData, Throwable cause) {
    super(exceptionCode, customSeverityLevel, contextData, cause);
  }

}
