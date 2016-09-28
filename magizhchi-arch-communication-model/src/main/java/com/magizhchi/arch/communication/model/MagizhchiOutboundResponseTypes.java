package com.magizhchi.arch.communication.model;

/**
 * Contains constants identifying architecture message types. MessageTypes are used to describe
 * which business service should be triggered for a specific message.
 * 
 * @author manisv
 *
 */
public class MagizhchiOutboundResponseTypes extends MagizhchiOutboundResponseType {

  /**
	 * 
	 */
  private static final long serialVersionUID = -7925788611022287294L;

  /** The Constant CONNECT_RSP. */
  public static final MagizhchiOutboundResponseTypes CONNECT_RSP = new MagizhchiOutboundResponseTypes(2);

  /** The Constant DISCONNECT_RSP. */
  public static final MagizhchiOutboundResponseTypes DISCONNECT_RSP = new MagizhchiOutboundResponseTypes(4);

  /** The Constant EXCEPTION_CONNECT_RSP. */
  public static final MagizhchiOutboundResponseTypes EXCEPTION_CONNECT_RSP = new MagizhchiOutboundResponseTypes(5);

  /** The Constant EXCEPTION_RSP. */
  public static final MagizhchiOutboundResponseTypes EXCEPTION_RSP = new MagizhchiOutboundResponseTypes(6);

  /** The Constant TEST_SVC_RSP. */
  public static final MagizhchiOutboundResponseTypes TEST_SVC_RSP = new MagizhchiOutboundResponseTypes(8);

  /** The Constant TEST_EXCEPTION_UTILS_RSP. */
  public static final MagizhchiOutboundResponseTypes TEST_EXCEPTION_UTILS_RSP = new MagizhchiOutboundResponseTypes(10);

  /**
   * Constructor.
   * 
   * @param id the message type's id
   */
  private MagizhchiOutboundResponseTypes(int id) {
    super(id);
  }

}
