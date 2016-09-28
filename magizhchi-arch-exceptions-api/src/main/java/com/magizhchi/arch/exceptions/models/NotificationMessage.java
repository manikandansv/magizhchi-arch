package com.magizhchi.arch.exceptions.models;

public class NotificationMessage {

  private String msgId;

  private String message;

  private String localeCode;

  public NotificationMessage() {
    super();
  }

  public NotificationMessage(String msgId, String message, String localeCode) {
    super();
    this.msgId = msgId;
    this.message = message;
    this.localeCode = localeCode;
  }

  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getLocaleCode() {
    return localeCode;
  }

  public void setLocaleCode(String localeCode) {
    this.localeCode = localeCode;
  }



}
