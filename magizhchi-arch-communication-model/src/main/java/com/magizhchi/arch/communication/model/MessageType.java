package com.magizhchi.arch.communication.model;

import java.io.Serializable;

/**
 * The super type for request/response message type implementation.
 * 
 * @author manisv
 *
 */
public class MessageType implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 6160048254381736877L;

  /** The Constant UNDEFINED. */
  public static final MessageType UNDEFINED = new MessageType(-1);

  /** The id. */
  private final int id;

  /**
   * Constructor.
   * 
   * @param id the message type's id
   */
  protected MessageType(int id) {
    this.id = id;
  }

  /**
   * Returns the message type's id.
   * 
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * 
   * @param other the other
   * 
   * @return true, if equals
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof MessageType)) {
      return false;
    }
    MessageType messageType = (MessageType) other;
    return id == messageType.id;
  }

  /**
   * Returns a hash code value for the object.
   * 
   * @return the int
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Integer.valueOf(id).hashCode();
  }

}
