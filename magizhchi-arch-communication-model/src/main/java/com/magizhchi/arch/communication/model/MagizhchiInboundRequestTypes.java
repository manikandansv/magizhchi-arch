package com.magizhchi.arch.communication.model;

/**
 * Contains constants identifying architecture message types. MessageTypes are used to describe
 * which business service should be triggered for a specific message
 * 
 * @author manisv
 *
 */
public class MagizhchiInboundRequestTypes extends MagizhchiInboundRequestType {

  /**
	 * 
	 */
  private static final long serialVersionUID = 6963323535199465868L;

  /** The Constant CONNECT_RQ. */
  public static final MagizhchiInboundRequestTypes CONNECT_RQ = new MagizhchiInboundRequestTypes(1);

  /** The Constant DISCONNECT_RQ. */
  public static final MagizhchiInboundRequestTypes DISCONNECT_RQ = new MagizhchiInboundRequestTypes(3);

  /** The Constant TEST_SVC_RQ. */
  public static final MagizhchiInboundRequestTypes TEST_SVC_RQ = new MagizhchiInboundRequestTypes(7);

  /** The Constant TEST_EXCEPTION_UTILS_RQ. */
  public static final MagizhchiInboundRequestTypes TEST_EXCEPTION_UTILS_RQ = new MagizhchiInboundRequestTypes(9);

  /**
   * Constructor.
   * 
   * @param id the message type's id
   */
  private MagizhchiInboundRequestTypes(int id) {
    super(id);
  }

}
