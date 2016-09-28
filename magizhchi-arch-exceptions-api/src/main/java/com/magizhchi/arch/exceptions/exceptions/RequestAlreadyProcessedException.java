package com.magizhchi.arch.exceptions.exceptions;



import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class RequestAlreadyProcessedException extends TechnicalException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1694926246365093983L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /** The Class RequestAlreadyProcessedExceptionCode. */
  private static class RequestAlreadyProcessedExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new exception code.
     * 
     * @param msgId the message id
     * @param Level the severity level
     * @param completionState completion state
     */
    public RequestAlreadyProcessedExceptionCode(String msgId, Level Level, CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  /** Error code: Request already processed exception code. */
  public static final RequestAlreadyProcessedExceptionCode DEFAULT_REQUEST_ALREADY_PROCESSED_EXCEPTION = getRequestAlreadyProcessedExceptionCode("DEFAULT_REQUEST_ALREADY_PROCESSED_EXCEPTION");
      //new RequestAlreadyProcessedExceptionCode("TTSVL016", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor.
   */
  public RequestAlreadyProcessedException() {
    super(DEFAULT_REQUEST_ALREADY_PROCESSED_EXCEPTION, null, null);
  }

  /**
   * Instantiates a new exception with the given throwable cause.
   * 
   * @param cause A previously caught Exception
   */
  public RequestAlreadyProcessedException(Throwable cause) {
    super(DEFAULT_REQUEST_ALREADY_PROCESSED_EXCEPTION, null, cause);
  }

  private static RequestAlreadyProcessedExceptionCode getRequestAlreadyProcessedExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new RequestAlreadyProcessedExceptionCode(abstractExceptionCode.getMsgId(),
        abstractExceptionCode.getSeverityLevel(), abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
