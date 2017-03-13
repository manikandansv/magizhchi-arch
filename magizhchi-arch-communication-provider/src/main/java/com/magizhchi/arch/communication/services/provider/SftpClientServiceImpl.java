package com.magizhchi.arch.communication.services.provider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.magizhchi.arch.communication.model.SftpClientConfiguration;
import com.magizhchi.arch.communication.model.SftpConnection;
import com.magizhchi.arch.communication.services.api.SftpClientConfigFactory;
import com.magizhchi.arch.communication.services.api.SftpClientService;

public class SftpClientServiceImpl implements SftpClientService {

  private SftpClientConfigFactory sftpClientConfigFactory;

  @Override
  public SftpConnection connect(String clientId) {
    // TODO Auto-generated method stub

    SftpClientConfiguration configuration = sftpClientConfigFactory.getSftpClientConfiguration(clientId);

    JSch jsch = new JSch();

    SftpConnection connection = null;

    try {
      Session session =
          jsch.getSession(configuration.getSftpUsername(), configuration.getSftpHost(), configuration.getSftpPort());

      session.setPassword(configuration.getSftpPassword());

      session.setTimeout(configuration.getSftpConnectTimeout());

      session.connect();

      Channel channel = session.openChannel("sftp");

      channel.connect();

      ChannelSftp sftpChannel = (ChannelSftp) channel;

      connection = new SftpConnection(session, channel, sftpChannel);

    } catch (JSchException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return connection;

  }

  @Override
  public void disconnect(SftpConnection connection) {

    connection.getChannelSftp().disconnect();

    connection.getChannel().disconnect();

    connection.getSession().disconnect();

  }

  @Override
  public byte[] importFile(SftpConnection connection, String filePath) {

    byte[] destinationBytes = null;

    try {

      InputStream is = connection.getChannelSftp().get(filePath);

      destinationBytes = IOUtils.toByteArray(is);

    } catch (SftpException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return destinationBytes;
  }

  @Override
  public void exportFile(SftpConnection connection, String destinationFilePath, byte[] inputContent) {

    try {
      connection.getChannelSftp().put(IOUtils.toInputStream(new String(inputContent), Charset.defaultCharset()),
          destinationFilePath);
    } catch (SftpException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void deleteFile() {
    // TODO Auto-generated method stub

  }

}
