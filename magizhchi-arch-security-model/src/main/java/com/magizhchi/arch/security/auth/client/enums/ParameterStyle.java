package com.magizhchi.arch.security.auth.client.enums;

public enum ParameterStyle {

  BODY, JSON_BODY, QUERY, HEADER;

  private String parameterStyle;

  public String toString() {
      return this.parameterStyle;
  }
  
}
