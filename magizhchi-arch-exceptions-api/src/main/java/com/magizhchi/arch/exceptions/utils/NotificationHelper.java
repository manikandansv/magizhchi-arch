package com.magizhchi.arch.exceptions.utils;

import org.apache.felix.scr.annotations.Reference;

import com.magizhchi.arch.exceptions.api.NotificationContextService;
import com.magizhchi.arch.exceptions.exceptions.UnspecificTechnicalException;

public class NotificationHelper {

  @Reference
  private static NotificationContextService notificationContextService;


  /** overrides method initialValue() from ThreadLocal. */
  private static final ThreadLocal<NotificationContextService> FACTORY = new ThreadLocal<NotificationContextService>() {

    @Override
    protected NotificationContextService initialValue() {

      return notificationContextService;
    }
  };

  /**
   * Delivers notification context associated with the current Thread
   * 
   * @return NotificationContext
   */
  public static NotificationContextService getNotificationContext() {
    
    return FACTORY.get();
    
  }

  /**
   * Initializes notification context that is bound to current thread using the provided context
   * object
   * 
   * This method is used to pre-set the notification context e.g. in case of a CORBA call where the
   * other side has added notifications. Note: By default the notification context is set in
   * <code>ThreadLocal.initialValue()</code>.
   * 
   * @param notificationContext the (already used) notification context which should be set to this
   *        thread. Do NOT set 'null'!
   */

  public static void setNotificationContext(NotificationContextService notificationContext) {

    // do not set to 'null'!
    if (notificationContext == null) {
      throw new UnspecificTechnicalException(UnspecificTechnicalException.OTHER_ERROR,
          new String[] {"Prohibited to set the notification context by notification helper to 'null'!"});
    }
    FACTORY.set(notificationContext);
  }

  /**
   * Initializes (empty) notification context that is bound to current thread.
   * 
   * This method is used to initialize the notification context in case e.g. the other side of a
   * CORBA call did not provide one. Note: By default the notification context is set in
   * <code>ThreadLocal.initialValue()</code>.
   * 
   * @return Initialized notification context
   */
  public static NotificationContextService initNotificationContext() {

    FACTORY.set(notificationContextService);
    
    return notificationContextService;
  }

}
