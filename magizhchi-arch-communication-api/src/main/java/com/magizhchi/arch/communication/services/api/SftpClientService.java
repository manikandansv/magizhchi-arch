package com.magizhchi.arch.communication.services.api;

import com.magizhchi.arch.communication.model.SftpConnection;

public interface SftpClientService {

  SftpConnection connect(String clientId);

  void disconnect(SftpConnection sftpConnection);

  byte[] importFile(SftpConnection connection, String filePath);

  void deleteFile();

  void exportFile(SftpConnection connection, String destinationFilePath, byte[] inputContent);

}
