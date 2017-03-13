package com.magizhchi.arch.communication.model;

import java.util.HashMap;
import java.util.Map;

public enum MagizhchiMessageType {

  INBOUND_REQUEST ("IR", "Inbound Request"),
  
  OUTBOUND_RESPONE ("OR", "Outbound Response");
  
  private final String id;

  private final String desc;

  private static Map<String, MagizhchiMessageType> values;
  
  private String messageType;

  private MagizhchiMessageType(String id, String desc) {
      this.id = id;
      this.desc = desc;
      registerId(this);
  }

  private static synchronized void registerId(MagizhchiMessageType value) {
      if (values == null) {
          values = new HashMap<String, MagizhchiMessageType>();
      }
      values.put(value.getId(), value);
  }

  public String getId() {
      return id;
  }

  public String getDesc() {
      return desc;
  }

  public String getMessageType() {
      return messageType;
  }

  public static MagizhchiMessageType getValueForId(String id) {
      return values.get(id);
  }
  
}
