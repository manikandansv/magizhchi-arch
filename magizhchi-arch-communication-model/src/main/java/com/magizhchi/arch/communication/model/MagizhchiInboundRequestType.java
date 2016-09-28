package com.magizhchi.arch.communication.model;

/**
 * The super type for request/response message type implementation.
 * 
 * @author manisv
 *
 */
public class MagizhchiInboundRequestType extends MessageType {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -1604909864495062539L;

  /**
   * @param id ID of given request type
   */
  public MagizhchiInboundRequestType(int id) {
    super(id);
  }

}
