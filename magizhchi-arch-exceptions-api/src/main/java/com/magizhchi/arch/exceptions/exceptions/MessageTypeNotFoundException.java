package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class MessageTypeNotFoundException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = -8562327365140955751L;
  
  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class MessageTypeNotFoundExceptionCode.
   */
  private static class MessageTypeNotFoundExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new persistence exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public MessageTypeNotFoundExceptionCode(String msgId, Level Level,
        CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  /** Error code: Database access error occurs. */
  public static final MessageTypeNotFoundExceptionCode MESSAGE_TYPE_NOT_FOUND = getMessageTypeNotFoundExceptionCode("MESSAGE_TYPE_NOT_FOUND");
     // new MessageTypeNotFoundExceptionCode("OTCCI001", Level.ERROR, CompletionState.OK);

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * MessageTypeNotFoundException(MessageTypeNotFoundException
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default MessageTypeNotFoundException DEFAULT_EXCEPTION_CODE,
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
  public MessageTypeNotFoundException(String[] contextData, Throwable cause) {
    this(MESSAGE_TYPE_NOT_FOUND, contextData, cause);
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
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given MessageTypeNotFoundExceptionCode,
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
  public MessageTypeNotFoundException(MessageTypeNotFoundExceptionCode exceptionCode,
      String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }
  
  private static MessageTypeNotFoundExceptionCode getMessageTypeNotFoundExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new MessageTypeNotFoundExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
