package com.magizhchi.arch.exceptions.exceptions;



import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.config.ExceptionCodeConfigurationFacade;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

public class DataMappingException extends AdaptorException {

  /**
	 * 
	 */
  private static final long serialVersionUID = -4729584888448306165L;

  @Reference
  private static ExceptionCodeConfigurationFacade exceptionCodeConfigFacade;

  /**
   * The Class DataMappingExceptionCode.
   */
  private static class DataMappingExceptionCode extends AbstractExceptionCode {

    /**
     * Instantiates a new data mapping exception code.
     * 
     * @param msgId the msg id
     * @param Level the severity level
     * @param completionState completion state
     */
    public DataMappingExceptionCode(String msgId, Level Level, CompletionState completionState) {
      super(msgId, Level, completionState);
    }
  }

  // ****************************************************************************
  // ** GENERAL ERRORS **
  // ****************************************************************************

  /** Error code: Data Mapping: Error occurred. */
  public static final DataMappingExceptionCode DEFAULT_ERROR = getDataMappingExceptionCode("DEFAULT_ERROR");

  /** Error code: Data Mapping: Configuration not present. */
  public static final DataMappingExceptionCode CONFIGURATION_NOT_PRESENT =
      getDataMappingExceptionCode("CONFIGURATION_NOT_PRESENT");
  // new DataMappingExceptionCode("TTDMA002", Level.ERROR, CompletionState.OK);

  /** Error code: Data Mapping: Could not process mapping rule. */
  public static final DataMappingExceptionCode MAPPING_RULE = getDataMappingExceptionCode("MAPPING_RULE");
  // new DataMappingExceptionCode(
  // "TTDMA003", Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: Could not access property with name {0} from object of type {1}.
   */
  public static final DataMappingExceptionCode COULD_NOT_ACCESS_PROPERTY =
      getDataMappingExceptionCode("COULD_NOT_ACCESS_PROPERTY");
  // new DataMappingExceptionCode("TTDMA004",
  // Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: ValueAccessor of type {0} is not applicable for Object of type {1}.
   * Use different ValueAccessor or check input file for integrity.
   */
  public static final DataMappingExceptionCode VA_NOT_APPLICABLE = getDataMappingExceptionCode("VA_NOT_APPLICABLE");
  // new DataMappingExceptionCode("TTDMA005",Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: Cannot encode object to event message format.
   */
  public static final DataMappingExceptionCode EVENT_ENCODING_FAILED =
      getDataMappingExceptionCode("EVENT_ENCODING_FAILED");
  // new DataMappingExceptionCode("TTDMA006", Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: Cannot decode object from event message format.
   */
  public static final DataMappingExceptionCode EVENT_DECODING_FAILED =
      getDataMappingExceptionCode("EVENT_DECODING_FAILED");
  // new DataMappingExceptionCode("TTDMA007", Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: Invalid internal event property.
   */
  public static final DataMappingExceptionCode EVENT_INVALID_PROPERTY =
      getDataMappingExceptionCode("EVENT_INVALID_PROPERTY");
  // new DataMappingExceptionCode("TTDMA008",Level.ERROR, CompletionState.OK);

  /**
   * Error code: Data Mapping: Value {0} is unknown for enum {1}.
   */
  public static final DataMappingExceptionCode UNKNOWN_ENUM_VALUE = getDataMappingExceptionCode("UNKNOWN_ENUM_VALUE");

  // new DataMappingExceptionCode("TTDMA009", Level.ERROR, CompletionState.OK);

  /**
   * Default constructor. Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * DataMappingException(DataMappingExceptionCode
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
  public DataMappingException() {
    this(DEFAULT_ERROR, null, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * DataMappingException(DataMappingExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default default DataMappingExceptionCode,
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
  public DataMappingException(String[] contextData) {
    this(DEFAULT_ERROR, contextData, null);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * DataMappingException(DataMappingExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default DataMappingExceptionCode,
   * <LI>null for the contextData,
   * <LI>previously caught Throwable cause
   * </UL>
   * .
   * </P>
   * 
   * @param cause A previous caught Exception
   */
  public DataMappingException(Throwable cause) {
    this(DEFAULT_ERROR, null, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * DataMappingException(DataMappingExceptionCode
	   * exceptionCode, String[] contextData, Throwable cause)
	   * 
	   * </PRE>
   * 
   * </P>
   * with the following parameter:
   * <P>
   * <UL>
   * <LI>a default DataMappingExceptionCode,
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
  public DataMappingException(String[] contextData, Throwable cause) {
    this(DEFAULT_ERROR, contextData, cause);
  }

  /**
   * Instantiates a new exception with the given exception context data elements.
   * 
   * Calls the constructor
   * <P>
   * 
   * <PRE>
	   * 
	   * DataMappingException(DataMappingExceptionCode
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
  public DataMappingException(DataMappingExceptionCode exceptionCode) {
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
	   * DataMappingException(DataMappingExceptionCode
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
  public DataMappingException(DataMappingExceptionCode exceptionCode, String[] contextData) {
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
	   * DataMappingException(DataMappingExceptionCode
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
  public DataMappingException(DataMappingExceptionCode exceptionCode, Throwable cause) {
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
	   * AdaptorException(AbstractExceptionCode exceptionCode, String[] contextData,
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
  public DataMappingException(DataMappingExceptionCode exceptionCode, String[] contextData, Throwable cause) {
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
	   * AdaptorException(AbstractExceptionCode exceptionCode, String[] contextData,
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
  protected DataMappingException(AbstractExceptionCode exceptionCode, String[] contextData, Throwable cause) {
    super(exceptionCode, contextData, cause);
  }

  private static DataMappingExceptionCode getDataMappingExceptionCode(String exceptionCode) {

    AbstractExceptionCode abstractExceptionCode = exceptionCodeConfigFacade.getAbstractExceptionCode(exceptionCode);

    return new DataMappingExceptionCode(abstractExceptionCode.getMsgId(), abstractExceptionCode.getSeverityLevel(),
        abstractExceptionCode.getCompletionState());
    // return new BaseRuntimeExceptionCode("TTOSS001", Level.ERROR, CompletionState.OK);
  }

}
