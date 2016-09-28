package com.magizhchi.arch.exceptions.api;

import java.util.Collection;

import com.magizhchi.arch.communication.model.ChannelInfo;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.exceptions.BaseException;
import com.magizhchi.arch.exceptions.exceptions.BaseRunTimeException;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;
import com.magizhchi.arch.exceptions.notifications.Notification;

public interface NotificationContextService {

  void add(BaseException e);

  void add(BaseRunTimeException e);

  void add(Notification notification);

  <T extends AbstractExceptionCode> boolean contains(T notificationCode);

  boolean contains(Notification notification);

  boolean contains(Class<? extends Notification> notificationClass);

  Collection<Notification> getNewlyOccurredNotifications();

  Collection<Notification> getAcknowledgedOccurredNotifications();


  int getNotificationsCount();

  CompletionState getHighestCompletionState();

  void setChannel(ChannelInfo channelInfo);

}
