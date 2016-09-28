package com.magizhchi.arch.exceptions.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Level;

import com.magizhchi.arch.exceptions.api.NotificationSeverityMappingHelperService;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.ChannelBasedSeverityMapper;
import com.magizhchi.arch.exceptions.notifications.Notification;

@Component(enabled = true, immediate = true)
@Service
public class NotificationSeverityMappingHelperServiceImpl implements NotificationSeverityMappingHelperService {

  /** Input channel based mappings */
  private Map<String, ChannelBasedSeverityMapper> inputChannelBasedMappings =
      new HashMap<String, ChannelBasedSeverityMapper>();


  @Override
  public Notification mapNotification(Notification notification, String channelName) {

    String msgId = notification.getMsgId();

    String key = getInputChannelBasedMappingsKey(channelName, msgId);

    if (inputChannelBasedMappings.containsKey(key)) {

      // here: Passed msgId and used channel are configured. Get configured
      // data.

      ChannelBasedSeverityMapper configBean = inputChannelBasedMappings.get(key);

      Level severityLevel = configBean.getSeverityLevel();
      CompletionState completionState = configBean.getCompletionState();

      // Override severity and completion state with the configured ones.
      notification.setLevel(severityLevel);
      notification.setCompletionState(completionState);
    }
    return notification;


  }

  /**
   * Returns key for internal map of input channel based mappings.
   * 
   * @param channelName name of the channel
   * @param msgId message ID
   * @return internal key
   */
  private String getInputChannelBasedMappingsKey(String channelName, String msgId) {
    return channelName + "#" + msgId;
  }

  @Override
  public void setInputChannelBasedMappings(List<ChannelBasedSeverityMapper> inputChannelBasedMappings) {

    this.inputChannelBasedMappings.clear();
    if (inputChannelBasedMappings != null && !inputChannelBasedMappings.isEmpty()) {
      for (ChannelBasedSeverityMapper configBean : inputChannelBasedMappings) {
        String key = getInputChannelBasedMappingsKey(configBean.getChannelName(), configBean.getMsgId());
        this.inputChannelBasedMappings.put(key, configBean);
      }
    }

  }

}
