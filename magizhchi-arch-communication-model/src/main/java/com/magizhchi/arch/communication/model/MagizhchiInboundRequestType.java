package com.magizhchi.arch.communication.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Property;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.utilities.api.PropertiesUtil;

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
  
  private static final String INBOUND_REQ_MSG_CODE = "inboundmsg.request.code";
  
  private static final String INBOUND_REQ_MSG_NAME = "inboundmsg.request.name";
  
  @Property(name = INBOUND_REQ_MSG_CODE)
  private String inboundReqMessageCode;
  
  @Property(name = INBOUND_REQ_MSG_NAME)
  private String inboundReqMessageName;
  
  protected void activate(ComponentContext ctx){
    this.inboundReqMessageCode = PropertiesUtil.toString(ctx.getProperties().get(INBOUND_REQ_MSG_CODE), StringUtils.EMPTY);
    this.inboundReqMessageName = PropertiesUtil.toString(ctx.getProperties().get(INBOUND_REQ_MSG_NAME), StringUtils.EMPTY);
  }

  public String getInboundReqMessageCode() {
    return inboundReqMessageCode;
  }

  public String getInboundReqMessageName() {
    return inboundReqMessageName;
  }

  /**
   * @param id ID of given request type
   */
  public MagizhchiInboundRequestType(int id) {
    super(id);
  }

}
