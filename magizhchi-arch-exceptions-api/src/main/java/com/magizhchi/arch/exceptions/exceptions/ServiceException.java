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
public class ServiceException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 8509104879007718318L;
  
  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class ServiceExceptionCode.
   */
  private static class ServiceExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new service exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severity level
     * @param completionState completion state
     */
    public ServiceExceptionCode(String msgId, Level severityLevel,
        CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /** Error code: No mapping for service found. */
  public static final ServiceExceptionCode NO_MAPPING_FOR_SERVICE_FOUND = getServiceExceptionCode("NO_MAPPING_FOR_SERVICE_FOUND");
  //new ServiceExceptionCode("TTSVE001", Level.ERROR, CompletionState.OK);

  /** Error code: No Service for name:{0} found. */
  public static final ServiceExceptionCode NO_SERVICE_FOR_NAME_FOUND = getServiceExceptionCode("NO_SERVICE_FOR_NAME_FOUND"); 
  //new ServiceExceptionCode("TTSVE002", Level.ERROR, CompletionState.OK);

  /** Error code: Request is null */
  public static final ServiceExceptionCode REQUEST_IS_NULL = getServiceExceptionCode("REQUEST_IS_NULL"); 
//  new ServiceExceptionCode("TTSVE003", Level.ERROR, CompletionState.OK);

  /** Error code: Message Type is null */
  public static final ServiceExceptionCode MESSAGE_TYPE_NULL = getServiceExceptionCode("MESSAGE_TYPE_NULL");
 // new ServiceExceptionCode("TTSVE004", Level.ERROR, CompletionState.OK);

  /** Error code: Unknown error occurs during process a request. */
  public static final ServiceExceptionCode UNKNOWN_ERROR = getServiceExceptionCode("UNKNOWN_ERROR");
  //new ServiceExceptionCode("TTSVE005", Level.ERROR, CompletionState.OK);

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
  public ServiceException() {
    this(NO_MAPPING_FOR_SERVICE_FOUND, null, null);
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
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   */
  public ServiceException(String[] contextData) {
    this(NO_MAPPING_FOR_SERVICE_FOUND, contextData, null);
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
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public ServiceException(Throwable cause) {
    this(NO_MAPPING_FOR_SERVICE_FOUND, null, cause);
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
  public ServiceException(String[] contextData, Throwable cause) {
    this(NO_MAPPING_FOR_SERVICE_FOUND, contextData, cause);
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
   * <LI>the given exceptionCode,
   * <LI>null for the contextData,
   * <LI>null for the cause
   * </UL>
   * .
   * </P>
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public ServiceException(ServiceExceptionCode exceptionCode) {
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
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given exceptionCode,
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
  public ServiceException(ServiceExceptionCode exceptionCode, String[] contextData) {
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
	   * ServiceException(ServiceExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
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
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public ServiceException(ServiceExceptionCode exceptionCode, Throwable cause) {
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
   * <LI>the given ServiceExceptionCode,
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
  public ServiceException(ServiceExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  private static ServiceExceptionCode getServiceExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new ServiceExceptionCode(abstractExceptionCode.getMsgId(),
        abstractExceptionCode.getSeverityLevel(), abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }
  
}
