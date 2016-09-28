package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

/**
 * 
 * @author manisv
 *
 */
public class UnspecificTechnicalException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1483113505745906711L;
  
  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class UnspecificTechnicalExceptionCode.
   */
  private static class UnspecificTechnicalExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new unspecific technical exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severity level
     * @param completionState completion state
     */
    public UnspecificTechnicalExceptionCode(String msgId, Level severityLevel,
        CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /** Error code: Other error: {0}. */
  public static final UnspecificTechnicalExceptionCode OTHER_ERROR = getUnspecificTechnicalExceptionCode("OTHER_ERROR");
      //new UnspecificTechnicalExceptionCode("TT000001", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default exceptionCode,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   */
  public UnspecificTechnicalException() {
    this(OTHER_ERROR, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default exceptionCode,
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
  public UnspecificTechnicalException(String[] contextData) {
    this(OTHER_ERROR, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default exceptionCode,
   * <LI>null for the contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous catched Exception
   */
  public UnspecificTechnicalException(Throwable cause) {
    this(OTHER_ERROR, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default exceptionCode,
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
  public UnspecificTechnicalException(String[] contextData, Throwable cause) {
    this(OTHER_ERROR, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * TOMGenericException(UnspecificTechnicalExceptionCode exceptionCode, String[]
	   * contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given UnspecificTechnicalExceptionCode,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public UnspecificTechnicalException(UnspecificTechnicalExceptionCode exceptionCode) {
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
	   * TOMGenericException(UnspecificTechnicalExceptionCode exceptionCode, String[]
	   * contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given UnspecificTechnicalExceptionCode,
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
  public UnspecificTechnicalException(UnspecificTechnicalExceptionCode exceptionCode,
      String[] contextData) {
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
	   * TOMGenericException(UnspecificTechnicalExceptionCode exceptionCode, String[]
	   * contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given UnspecificTechnicalExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously catched Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous catched Exception
   */
  public UnspecificTechnicalException(UnspecificTechnicalExceptionCode exceptionCode,
      Throwable cause) {
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
	   * TOMException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given UnspecificTechnicalExceptionCode,
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
   * <LI>the given UnspecificTechnicalExceptionCode,
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
  public UnspecificTechnicalException(AbstractExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }
  
  private static UnspecificTechnicalExceptionCode getUnspecificTechnicalExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new UnspecificTechnicalExceptionCode(abstractExceptionCode.getMsgId(),
        abstractExceptionCode.getSeverityLevel(), abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
