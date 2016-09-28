package com.magizhchi.arch.exceptions.provider;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.magizhchi.arch.communication.model.ChannelInfo;
import com.magizhchi.arch.exceptions.api.NotificationContextService;
import com.magizhchi.arch.exceptions.api.NotificationSeverityMappingHelperService;
import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.exceptions.BaseException;
import com.magizhchi.arch.exceptions.exceptions.BaseRunTimeException;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;
import com.magizhchi.arch.exceptions.notifications.Notification;
import com.magizhchi.arch.exceptions.notifications.Notification.NotificationCode;
import com.magizhchi.arch.utilities.api.SerializationHelper;

@Component(immediate = true, enabled = true)
@Service
public class NotificationContextServiceImpl implements NotificationContextService, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1835686628707180142L;

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationContextServiceImpl.class);

  /** An instance of <code>NotificationSeverityMappingHelper</code>. */
  @Reference
  private transient NotificationSeverityMappingHelperService notificationSeverityMappingHelperService;

  /**
   * Overall completion state, stores the highest completion state across all (not acknowledged)
   * notifications
   */
  private CompletionState highestCompletionState = CompletionState.OK;

  /**
   * Overall severity level, stores the highest severity level across all (not acknowledged)
   * notifications
   */
  private Level highestSeverityLevel = Level.INFO;

  /** newly occurred (= not acknowledged) Notifications */
  private HashMap<String, Notification> newlyOccurredNotifications;

  /** acknowledged occurred Notifications */
  private HashMap<String, Notification> acknowledgedOccurredNotifications;

  /**
   * previously registered acknowledged notifications
   * 
   * Key: the JAP messageID (8-digit)
   * 
   * Value: a set of acknowledged notifications for this messageID
   */
 // private HashSet<AcknowledgedNotification> acknowledgedRegisteredNotifications;


  /** amount of new notifications added since last 'reset' of this variable */
  private int notificationsAddedSinceReset = 0;

  private ChannelInfo channelInfo;

  @Override
  public void add(BaseException e) {

    Notification notification = new Notification(e.getMessageId(), e.getSeverityLevel(), e.getCompletionState(), null);

    add(notification);

  }

  @Override
  public void add(BaseRunTimeException e) {

    Notification notification = new Notification(e.getMessageId(), e.getSeverityLevel(), e.getCompletionState(), null);

    add(notification);

  }

  @Override
  public void add(Notification notification) {

    // log added notification
    if (LOGGER.isTraceEnabled()) {
      String notificationString = SerializationHelper.objectToXMLString(notification);
      LOGGER.trace("NotificationContext.add was called." + " Channel:" + channelInfo + " Notification:"
          + notificationString);
    }

    // map severity based on channel info
    String channelName = (channelInfo != null) ? channelInfo.getChannelName() : ChannelInfo.DEFAULT_CHANNEL_NAME;
    if (notificationSeverityMappingHelperService != null) {
      notification = notificationSeverityMappingHelperService.mapNotification(notification, channelName);
    }

//    // add notification to correct list, and adapt highest completion state
//    String notificationKey = getNotificationKey(notification);
//    if (!isCoveredByAcknowledgedRegisteredNotifications(notification)) {
//      notificationsAddedSinceReset += 1;
//      newlyOccurredNotifications.put(notificationKey, notification);
//      adaptHighestCompletionState(notification);
//      adaptHighestSeverityLevel(notification);
//    } else {
//      acknowledgedOccurredNotifications.put(notificationKey, notification);
//    }

  }

  /**
   * Checks whether a given notification is covered by an previously registered acknowledged
   * notification.
   * 
   * @param notification (new) notification
   * @return <code>true</code> if the given notification is covered by (at least) one of the
   *         previously acknowledged notifications
   */
//  private boolean isCoveredByAcknowledgedRegisteredNotifications(Notification notification) {
//    return isCoveredByAcknowledgedRegisteredNotifications(notification, acknowledgedRegisteredNotifications);
//  }


  /**
   * If needed, re-set the overall completion state.
   * 
   * @param notification notification to be adapted
   */
  private void adaptHighestCompletionState(Notification notification) {

    int i = this.highestCompletionState.compareTo(notification.getCompletionState());
    if (i < 0) {
      this.highestCompletionState = notification.getCompletionState();
    }

  }

  /**
   * If needed, re-set the overall SeverityLevel.
   * 
   * @param notification notification to be adapted
   */
  private void adaptHighestSeverityLevel(Notification notification) {

    int i = this.highestSeverityLevel.toInt() - notification.getLevel().toInt();
    if (i < 0) {
      this.highestSeverityLevel = notification.getLevel();
    }

  }

  @Override
  public <T extends AbstractExceptionCode> boolean contains(T notificationCode) {
    NotificationCode code =
        new NotificationCode(notificationCode.getMsgId(), notificationCode.getSeverityLevel(),
            notificationCode.getCompletionState());

    return contains(new Notification(code));
  }

  @Override
  public boolean contains(Notification notification) {
    return newlyOccurredNotifications.get(getNotificationKey(notification)) != null;
  }

  /**
   * Gets a semi-unique key for this notification. It is unique enough to clearly separate two
   * notifications with same code, but different context data. On the other side, it is the same key
   * for two notification instances which were created under same circumstances (same code, same
   * context data,...).
   * 
   * @param notification the notification
   * 
   * @return a semi-unique key
   */
  private String getNotificationKey(Notification notification) {
    StringBuffer buffer = new StringBuffer((notification.getMsgId() == null) ? "?" : notification.getMsgId());
    buffer.append('_');
    buffer.append(notification.getLevel());
    buffer.append('_');
    buffer.append((notification.getCompletionState() == null) ? "?" : notification.getCompletionState());
    if (notification.getContextData() == null) {
      buffer.append("_");
    } else {
      for (String data : notification.getContextData()) {
        buffer.append('_');
        buffer.append(data);
      }
    }
    return buffer.toString();
  }

  @Override
  public boolean contains(Class<? extends Notification> notificationClass) {
    // per definition: always false if either existing notification list or the
    // comparable class is null
    if (notificationClass == null || newlyOccurredNotifications == null) {
      return false;
    }

    // 'contains' check is done via class instantiation, so attribute values may
    // be different.
    for (Notification not : newlyOccurredNotifications.values()) {
      if (notificationClass.isInstance(not)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Collection<Notification> getNewlyOccurredNotifications() {
    return ((newlyOccurredNotifications == null) ? null : newlyOccurredNotifications.values());
  }

  @Override
  public Collection<Notification> getAcknowledgedOccurredNotifications() {
    return ((acknowledgedOccurredNotifications == null) ? null : acknowledgedOccurredNotifications.values());
  }

  @Override
  public int getNotificationsCount() {
    return newlyOccurredNotifications.size();
  }

  @Override
  public CompletionState getHighestCompletionState() {
    return this.highestCompletionState;
  }

  @Override
  public void setChannel(ChannelInfo channelInfo) {

    this.channelInfo = channelInfo;

  }

}
