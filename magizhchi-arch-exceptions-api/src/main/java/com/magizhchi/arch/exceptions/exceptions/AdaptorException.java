
package com.magizhchi.arch.exceptions.exceptions;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class AdaptorException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1759243709327604940L;

  /**
   * The Class AdaptorExceptionCode.
   */
  private static class AdaptorExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new adaptor exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severity level
     * @param completionState completion state
     */
    public AdaptorExceptionCode(String msgId, Level severityLevel,
        CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
   * 
   * AdaptorException(AdaptorExceptionCode
   * exceptionCode, String[] contextData, Throwable cause)
   * 
   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorException,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public AdaptorException(AdaptorExceptionCode exceptionCode) {
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
   * AdaptorException(AdaptorExceptionCode
   * exceptionCode, String[] contextData, Throwable cause)
   * 
   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorException,
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
  public AdaptorException(AdaptorExceptionCode exceptionCode, String[] contextData) {
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
   * AdaptorException(AdaptorExceptionCode
   * exceptionCode, String[] contextData, Throwable cause)
   * 
   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorException,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public AdaptorException(AdaptorExceptionCode exceptionCode, Throwable cause) {
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
   * TOMException(AbstractExceptionCode exceptionCode, String[] contextData,
   * Throwable cause)
   * 
   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AdaptorException,
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
   * <LI>the given AdaptorException,
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
  public AdaptorException(AdaptorExceptionCode exceptionCode, String[] contextData, Throwable cause) {
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
  protected AdaptorException(AbstractExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

}
