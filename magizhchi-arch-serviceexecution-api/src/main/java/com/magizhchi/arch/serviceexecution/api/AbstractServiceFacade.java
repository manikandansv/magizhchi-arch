package com.magizhchi.arch.serviceexecution.api;

import com.magizhchi.arch.communication.model.MagizhchiInboundRequest;
import com.magizhchi.arch.communication.model.MagizhchiMessage;
import com.magizhchi.arch.communication.model.MagizhchiOutboundResponse;
import com.magizhchi.arch.exceptions.exceptions.BaseException;

/**
 * Abstract service facade class that needs to be extended by all application specific service
 * facades.
 * 
 * @author manisv
 *
 */
public abstract class AbstractServiceFacade implements ServiceFacade {

  /** The response. */
  private MagizhchiOutboundResponse response;

  /** {@inheritDoc} */
  @Override
  public MagizhchiOutboundResponse getResponse() {
    return response;
  }

  /**
   * Sets the response.
   * 
   * @param response the new response
   */
  protected void setResponse(MagizhchiOutboundResponse response) {
    this.response = response;
  }

  /** {@inheritDoc} */
  @Override
  public abstract boolean isTransacted();

  /** {@inheritDoc} */
  @Override
  public abstract boolean needIdempotentProcessing();

  /** {@inheritDoc} */
  @Override
  public abstract void processRequest(MagizhchiInboundRequest request) ; // throws BaseException;

  /** {@inheritDoc} */
  @Override
  public abstract MagizhchiMessage getRequestMessage();

  /** {@inheritDoc} */
  @Override
  public abstract MagizhchiMessage getResponseMessage();

  /**
   * Compose response.
   * 
   * @param request the request
   * @return the response
   */
  public MagizhchiOutboundResponse composeResponse(MagizhchiInboundRequest request) {
    return createResponse(getResponseMessage(), request);
  }

  /**
   * Handles exception, by wrapping Exceptions into TOMExceptions
   * 
   * @param e Exception occurred
   * @throws BaseException new TOMException
   */
  public void handleException(Exception e) { //throws BaseException {
//    if (e instanceof FunctionalException) {
//      throw (FunctionalException) e;
//    }
//    if (e instanceof TechnicalException) {
//      throw (TechnicalException) e;
//    }
//    throw new ServiceException(ServiceException.UNKNOWN_ERROR, e);
  }

  /**
   * Build up the Response object.
   * 
   * @param messageType message type to be set
   * @param request Request object
   * @return Response object
   */
  private MagizhchiOutboundResponse createResponse(MagizhchiMessage message, MagizhchiInboundRequest request) {
    MagizhchiOutboundResponse response = new MagizhchiOutboundResponse();
    response.setMagizhchiMessage(message);
    response.setMessageId(request.getMessageId());
    response.setContent(null);
    response.setServiceExecutionDuration(System.currentTimeMillis() - request.getTimeSent());
    return response;
  }

}
