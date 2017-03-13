package com.magizhchi.arch.communication.model;

import java.io.Serializable;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class SftpConnection implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3073301116376141560L;

  private Session session;

  private ChannelSftp channelSftp;

  private Channel channel;

  public SftpConnection(Session session) {
    this.session = session;
  }

  public SftpConnection(Session session, ChannelSftp channelSftp) {
    this.session = session;
    this.channelSftp = channelSftp;
  }


  public SftpConnection(Session session, Channel channel, ChannelSftp channelSftp) {
    this.session = session;
    this.channel = channel;
    this.channelSftp = channelSftp;
  }


  public Session getSession() {
    return session;
  }

  public ChannelSftp getChannelSftp() {
    return channelSftp;
  }

  public Channel getChannel() {
    return channel;
  }



}
