package com.magizhchi.arch.persistence.api;

public interface PersistenceServiceFactory<T extends Object> {

  PersistenceService<T> getPersistenceService(String persistenceServiceId);
  
}
