package com.magizhchi.arch.exceptions.api;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

import com.magizhchi.arch.exceptions.models.ChannelBasedSeverityMapper;
import com.magizhchi.arch.exceptions.notifications.Notification;

@ProviderType
public interface NotificationSeverityMappingHelperService {

  Notification mapNotification(final Notification notification, String channelName);
  
  void setInputChannelBasedMappings(List<ChannelBasedSeverityMapper> inputChannelBasedMappings);
  
}
