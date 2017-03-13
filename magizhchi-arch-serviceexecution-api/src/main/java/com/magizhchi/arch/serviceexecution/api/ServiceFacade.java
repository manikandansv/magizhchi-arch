package com.magizhchi.arch.serviceexecution.api;

import com.magizhchi.arch.communication.model.MagizhchiInboundRequest;
import com.magizhchi.arch.communication.model.MagizhchiInboundRequestType;
import com.magizhchi.arch.communication.model.MagizhchiMessage;
import com.magizhchi.arch.communication.model.MagizhchiOutboundResponse;
import com.magizhchi.arch.communication.model.MagizhchiOutboundResponseType;
import com.magizhchi.arch.exceptions.exceptions.BaseException;

/**
 * 
 * This is base interface for the service facade
 * 
 * @author manisv
 *
 */
public interface ServiceFacade {
  
  String SVC_INBOUND_REQ_MSG_CODE = "svc.inbound.req.msg.code";
  
  String SVC_OUTBOUND_RESP_MSG_CODE = "svc.outbound.resp.msg.code";
  
  String SVC_NAME = "svc.name";

  /**
   * Process request.
   * 
   * @param request the request
   * @throws BaseException
   */
  public void processRequest(MagizhchiInboundRequest request); // throws BaseException;

  /**
   * Returns whether the service is transacted.
   * 
   * @return true, if is transacted
   */
  public boolean isTransacted();

  /**
   * Returns whether the service needs idempotent processing.
   * 
   * Idempotent services are services that can be executed several times with the same result
   * without any impact as if it was executed once. If the service is not idempotent by nature it
   * needs idempotent processing to avoid that it is executed more than once.
   * 
   * @return true, if service needs idempotent processing
   */
  public boolean needIdempotentProcessing();

  /**
   * Gets the response object which contains result of the service execution.
   * 
   * @return the response
   */
  public MagizhchiOutboundResponse getResponse();

  /**
   * Returns the request message type.
   * 
   * @return the request message type
   */
  public MagizhchiMessage getRequestMessage();

  /**
   * Returns the response message type.
   * 
   * @return the response message type
   */
  public MagizhchiMessage getResponseMessage();

  String getReqMsgCode();

  String getRespMsgCode();

}
