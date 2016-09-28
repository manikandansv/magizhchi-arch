package com.magizhchi.arch.exceptions.exceptions;

import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;
import com.magizhchi.arch.exceptions.utils.ExceptionUtils;

/**
 * 
 * @author manisv
 *
 */
public class BaseRunTimeException extends RuntimeException {

  /**
	 * 
	 */
  private static final long serialVersionUID = 5620775093758203528L;

  /** Completion state */
  private CompletionState completionState = CompletionState.UNDEFINED;

  /** Severity level */
  private Level severityLevel;

  /**
   * (Semi-)Unique exception ID which is different for every instance of this class
   */
  private String uniqueExceptionId;

  private String messageId;

  private String[] contextData;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class BaseRuntimeExceptionCode.
   */
  private static class BaseRuntimeExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new Base runtime exception code.
     * 
     * @param msgId the msg id
     * @param severityLevel the severity level
     * @param completionState completion state
     */
    public BaseRuntimeExceptionCode(String msgId, Level severityLevel, CompletionState completionState) {
      super(msgId, severityLevel, completionState);
    }
  }

  /** The Constant SERVICE_BEAN_LOAD_EXCEPTION. */
  public static final BaseRuntimeExceptionCode SERVICE_BEAN_LOAD_EXCEPTION =
      getBaseRunTimeCode("SERVICE_BEAN_LOAD_EXCEPTION");

  /** Undefined other error */
  public static final BaseRuntimeExceptionCode OTHER_ERROR = getBaseRunTimeCode("OTHER_ERROR");

  public BaseRunTimeException() {}

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * BaseException(AbstractExceptionCode exceptionCode, String[] contextData,
	   * Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>the given BaseRuntimeExceptionCode,
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
   * <LI>the given BaseRuntimeExceptionCode,
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
  public BaseRunTimeException(BaseRuntimeExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    this((AbstractExceptionCode) exceptionCode, contextData, cause);
  }

  /**
   * Call the parent constructor with a given exception code, given exception context data elements
   * and a previously caught Throwable.
   * 
   * @param exceptionCode The error code which refers to a message and a corresponding severity.
   * @param severityLevel severityLevel
   * @param contextData An array of exception context elements that is used in conjunction with
   *        language independent messages. Context arguments are arguments for the placeholders of
   *        the message referenced by the messageID.
   * @param cause the cause
   */
  public BaseRunTimeException(BaseRuntimeExceptionCode exceptionCode, Level severityLevel, String[] contextData,
      Throwable cause) {
    this((AbstractExceptionCode) exceptionCode, severityLevel, contextData, cause);
  }

  /**
   * Protected constructor.
   * 
   * @param exceptionCode exception code
   * @param contextData exception context data
   * @param cause root cause
   */
  protected BaseRunTimeException(AbstractExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    this(exceptionCode, exceptionCode.getSeverityLevel(), contextData, cause);
  }

  /**
   * Protected constructor.
   * 
   * @param exceptionCode exception code
   * @param severityLevel severityLevel
   * @param contextData exception context data
   * @param cause root cause
   */
  protected BaseRunTimeException(AbstractExceptionCode exceptionCode, Level severityLevel, String[] contextData,
      Throwable cause) {
    super(cause);

    this.messageId = exceptionCode.getMsgId();
    this.severityLevel = severityLevel;
    this.completionState = exceptionCode.getCompletionState();
    this.contextData = contextData;

    if (ExceptionUtils.getInstance() != null) {
      this.uniqueExceptionId = ExceptionUtils.getInstance().createSemiUniqueId();
    }
  }

  /**
   * @return the severityLevel
   */
  public Level getSeverityLevel() {
    return severityLevel;
  }

  /**
   * Returns completion state.
   * 
   * @return completion state
   */
  public CompletionState getCompletionState() {
    return this.completionState;
  }

  /**
   * @return the uniqueExceptionId
   */
  public String getUniqueExceptionId() {
    return uniqueExceptionId;
  }

  public String[] getContextData() {
    return contextData;
  }

  public void setContextData(String[] contextData) {
    this.contextData = contextData;
  }

  private static BaseRuntimeExceptionCode getBaseRunTimeCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new BaseRuntimeExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public void setCompletionState(CompletionState completionState) {
    this.completionState = completionState;
  }

  public void setSeverityLevel(Level severityLevel) {
    this.severityLevel = severityLevel;
  }

  public void setUniqueExceptionId(String uniqueExceptionId) {
    this.uniqueExceptionId = uniqueExceptionId;
  }



}
