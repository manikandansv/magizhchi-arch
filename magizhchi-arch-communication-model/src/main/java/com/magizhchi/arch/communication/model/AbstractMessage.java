package com.magizhchi.arch.communication.model;

import java.io.Serializable;

/**
 * The Class AbstractMessage.
 * 
 * @author manisv
 *
 */
public class AbstractMessage implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = -4503424086909400474L;

  /** The message type. */
  private MessageType messageType = MessageType.UNDEFINED;

  /** The message id. */
  private String messageId;

  /**
   * Gets the message id.
   * 
   * @return the message id
   */
  public String getMessageId() {
    return messageId;
  }

  /**
   * Sets the message id.
   * 
   * @param messageId the new message id
   */
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the message type.
   * 
   * @return the message type
   */
  public MessageType getMessageType() {
    return messageType;
  }

  /**
   * Sets the message type.
   * 
   * @param messageType the new message type
   */
  public void setMessageType(MessageType messageType) {
    this.messageType = messageType;
  }

}
