package com.magizhchi.arch.exceptions.utils;

import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author manisv
 *
 */
public class ExceptionUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtils.class);

  /** atomic integer to be used to create a semi-unique ID */
  private AtomicInteger atomicInt;

  /** server track ID */
  private String track;

  /** WLS server instance's short name (e.g. "msi4") */
  private String serverInstanceShortName;

  /** single instance (for this cluster member) */
  private static final ExceptionUtils INSTANCE = new ExceptionUtils();

  /**
   * Default Constructor.
   */
  private ExceptionUtils() {
    init();
  }

  /**
   * Initializes this instance, prepares some objects which will be used later.
   */
  private void init() {

    /*
     * Preparation for creation of semi-unique Id for exceptions
     */

    // prepare part 1: counter
    int initialCounter = new Random().nextInt(100000);
    atomicInt = new AtomicInteger(initialCounter);

    // prepare part 2: track (Horgen vs. Zurich)
    if (System.getProperty("track") != null) {
      track = System.getProperty("track");
    } else {
      track = "?";
    }

    // prepare part 3: server IP
    try {
      InetAddress serverIP = InetAddress.getLocalHost();
      byte[] ipAddressBytes = serverIP.getAddress();

      StringBuilder ipAddressHex = new StringBuilder();
      for (int ipAddressBlock : ipAddressBytes) {

        int tempIP = ipAddressBlock;
        // shift for bytes between -128 and 0
        if (tempIP < 0) {
          tempIP += 256;
        }

        // prepend "0" for short addresses
        if (tempIP < 16) {
          ipAddressHex.append("0");
        }

        ipAddressHex.append(Integer.toHexString(tempIP));
      }

      serverInstanceShortName = ipAddressHex.toString();

    } catch (Exception e) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER
            .trace(
                "Could not detect the server instance's name, probably because not running from a WLS on an IT-PTA-PROD server.",
                e);
      }
      serverInstanceShortName = "?";
    }

  }

  /**
   * Get instance.
   * 
   * @return the instance
   */
  public static ExceptionUtils getInstance() {
    return INSTANCE;
  }

  /**
   * converts Object[] context data to String []
   * 
   * @param objects context data
   * @return context data as String[]
   */
  public String[] convertContextData(Object[] objects) {
    String[] strings = new String[objects.length];
    for (int i = 0; i != objects.length; i++) {
      Object obj = objects[i];
      if (obj == null) {
        strings[i] = "";
      } else {
        strings[i] = obj.toString();
      }
    }
    return strings;
  }

  /**
   * Creates a semi-unique ID which contains a (nearly) unique ID, the track info and the server
   * instance's short name.
   * 
   * @return the created semi-unique ID
   */
  public String createSemiUniqueId() {
    String id = atomicInt.getAndIncrement() + "-" + track + "-" + serverInstanceShortName;
    return id;
  }

}
