package com.magizhchi.arch.communication.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Property;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.utilities.api.PropertiesUtil;

public class MagizhchiMessage {

  private final static String MESSAGE_CODE = "magizhchimessage.code";

  private final static String MESSAGE_NAME = "magizhchimessage.name";

  private final static String MESSAGE_TYPE = "magizhchimessage.type";

  private MagizhchiMessageType magizhchiMessageType;

  @Property(name = MESSAGE_CODE)
  private String messageCode;

  @Property(name = MESSAGE_NAME)
  private String messageName;

  @Property(name = MESSAGE_TYPE)
  private String messageType;

  protected void activate(ComponentContext ctx){
    this.messageCode = PropertiesUtil.toString(ctx.getProperties().get(MESSAGE_CODE), StringUtils.EMPTY);
    this.messageName = PropertiesUtil.toString(ctx.getProperties().get(MESSAGE_NAME), StringUtils.EMPTY);
    this.messageType = PropertiesUtil.toString(ctx.getProperties().get(MESSAGE_TYPE), StringUtils.EMPTY);
    this.magizhchiMessageType = MagizhchiMessageType.getValueForId(messageType);
  }

  public MagizhchiMessageType getMagizhchiMessageType() {
    return magizhchiMessageType;
  }

  public String getMessageCode() {
    return messageCode;
  }

  public String getMessageName() {
    return messageName;
  }

  public String getMessageType() {
    return messageType;
  }

}
