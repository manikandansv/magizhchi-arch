package com.magizhchi.arch.exceptions.exceptions;

import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

/**
 * 
 * @author manisv
 *
 */
public class FunctionalException extends BaseException {


  /**
	 * 
	 */
  private static final long serialVersionUID = 9114472241057512726L;

  public FunctionalException() {}

  /**
   * This constructor is defined to allow correct inheritance of exception classes.
   * 
   * @param msgId The unique 8-character message Id (e.g. "OT123456").
   * @param Level The severity level.
   * @param completionState The completion state which marks whether correction is required or not.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  public FunctionalException(String msgId, Level Level,
      CompletionState completionState, String[] contextData, Throwable cause) {
    super(msgId, Level, completionState, contextData, cause);
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
	   * FunctionalException(FunctionalExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given AbstractExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * </PRE>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  protected FunctionalException(AbstractExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  /**
   * This constructor is defined to allow correct inheritance of exception classes.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param customLevel custom severity level
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  protected FunctionalException(AbstractExceptionCode exceptionCode,
      Level customLevel, String[] contextData, Throwable cause) {
    super(exceptionCode, customLevel, contextData, cause);
  }

}
