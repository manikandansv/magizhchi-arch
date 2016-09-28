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
public class ServiceAccessException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 9124000666500339523L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;
  
  /**
   * The Class ServiceAccessExceptionCode.
   */
  private static class ServiceAccessExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new service access exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public ServiceAccessExceptionCode(String msgId, Level Level,
        CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  /** Error Code for connection between service layers failure. */
  public static final ServiceAccessExceptionCode SERVICE_EXEC_WITHOUT_CONNECT = getServiceAccessExceptionCode("SERVICE_EXEC_WITHOUT_CONNECT");
      //new ServiceAccessExceptionCode("TTSVL001", Level.ERROR, CompletionState.OK);

  /** Error Code when sender class could not be found. */
  public static final ServiceAccessExceptionCode SENDER_CLASS_NOT_FOUND = getServiceAccessExceptionCode("SENDER_CLASS_NOT_FOUND");
     // new ServiceAccessExceptionCode("TTSVL002", Level.ERROR, CompletionState.OK);

  /** Maximum number of request re-sending exceeded. */
  public static final ServiceAccessExceptionCode MAX_RETRY_RESEND_EXCEEDED = getServiceAccessExceptionCode("MAX_RETRY_RESEND_EXCEEDED");
    //  new ServiceAccessExceptionCode("TTSVL003", Level.ERROR, CompletionState.OK);

  /** Could not establish connections to all servers. */
  public static final ServiceAccessExceptionCode CONNECT_TO_ALL_SERVERS_FAILED = getServiceAccessExceptionCode("CONNECT_TO_ALL_SERVERS_FAILED");
    //  new ServiceAccessExceptionCode("TTSVL004", Level.ERROR, CompletionState.OK);

  /** No connection to any server. */
  public static final ServiceAccessExceptionCode NO_CONNECTION_TO_ANY_SERVER = getServiceAccessExceptionCode("NO_CONNECTION_TO_ANY_SERVER");
    //  new ServiceAccessExceptionCode("TTSVL005", Level.ERROR, CompletionState.OK);

  /** Response includes an exception. */
  public static final ServiceAccessExceptionCode EXCEPTION_RESPONSE = getServiceAccessExceptionCode("EXCEPTION_RESPONSE");
    //  new ServiceAccessExceptionCode("TTSVL006", Level.ERROR, CompletionState.OK);

  /** No communication class found for a destination on the server. */
  public static final ServiceAccessExceptionCode DEST_COMM_CLASS_NOT_FOUND = getServiceAccessExceptionCode("DEST_COMM_CLASS_NOT_FOUND");
   //   new ServiceAccessExceptionCode("TTSVL007", Level.ERROR, CompletionState.OK);

  /** No logical destination found for server. */
  public static final ServiceAccessExceptionCode NO_LOGICAL_DEST_NAME = getServiceAccessExceptionCode("NO_LOGICAL_DEST_NAME");
    //  new ServiceAccessExceptionCode("TTSVL008", Level.ERROR, CompletionState.OK);

  /** Local caller interface could not be retrieved. */
  public static final ServiceAccessExceptionCode LOC_CALLER_CLASS_NOT_FOUND = getServiceAccessExceptionCode("LOC_CALLER_CLASS_NOT_FOUND");
    //  new ServiceAccessExceptionCode("TTSVL009", Level.ERROR, CompletionState.OK);

  /** Configuration is not of type <code>RMIDestination</code>. */
  public static final ServiceAccessExceptionCode CONNECT_DESTINATIONS_NULL = getServiceAccessExceptionCode("CONNECT_DESTINATIONS_NULL");
  //    new ServiceAccessExceptionCode("TTSVL010", Level.ERROR, CompletionState.OK);

  /** Could not retrieve home or remote interface of EJB. */
  public static final ServiceAccessExceptionCode EJB_CONNECTION_FAILED = getServiceAccessExceptionCode("EJB_CONNECTION_FAILED");
   //   new ServiceAccessExceptionCode("TTSVL011", Level.ERROR, CompletionState.OK);

  /** Sending to EJB on server failed. */
  public static final ServiceAccessExceptionCode EJB_SEND_FAILED = getServiceAccessExceptionCode("EJB_SEND_FAILED");
// new ServiceAccessExceptionCode("TTSVL012", Level.ERROR, CompletionState.OK);

  /** Initialization of request sender failed. */
  public static final ServiceAccessExceptionCode INIT_REQUEST_SENDER_FAILED = getServiceAccessExceptionCode("INIT_REQUEST_SENDER_FAILED");
   //   new ServiceAccessExceptionCode("TTSVL013", Level.ERROR, CompletionState.OK);

  /** Request object is null */
  public static final ServiceAccessExceptionCode REQUEST_IS_NULL = getServiceAccessExceptionCode("REQUEST_IS_NULL");
  //new ServiceAccessExceptionCode("TTSVL014", Level.ERROR, CompletionState.OK);

  /** Message Type is null */
  public static final ServiceAccessExceptionCode MESSAGE_TYPE_NULL = getServiceAccessExceptionCode("MESSAGE_TYPE_NULL");
   //   new ServiceAccessExceptionCode("TTSVL015", Level.ERROR, CompletionState.OK);

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   */
  public ServiceAccessException(ServiceAccessExceptionCode exceptionCode) {
    this(exceptionCode, null, null);
  }

  /**
   * This constructor is defined to allow correct inheritance of exception classes.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the place holders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  public ServiceAccessException(ServiceAccessExceptionCode exceptionCode, String[] contextData,
      Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param cause A previous caught Exception
   */
  public ServiceAccessException(ServiceAccessExceptionCode exceptionCode, Throwable cause) {
    this(exceptionCode, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the place holders of
   *        the message referenced by the messageID.
   */
  public ServiceAccessException(ServiceAccessExceptionCode exceptionCode, String[] contextData) {
    this(exceptionCode, contextData, null);
  }
  
  private static ServiceAccessExceptionCode getServiceAccessExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new ServiceAccessExceptionCode(abstractExceptionCode.getMsgId(),
        abstractExceptionCode.getSeverityLevel(), abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
