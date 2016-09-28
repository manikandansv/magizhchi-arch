package com.magizhchi.arch.communication.model;

/**
 * The super type for request/response message type implementation.
 * 
 * @author manisv
 *
 */
public class MagizhchiOutboundResponseType extends MessageType {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 5524224375703413249L;

  /**
   * @param id ID of given request type
   */
  public MagizhchiOutboundResponseType(int id) {
    super(id);
  }

}
