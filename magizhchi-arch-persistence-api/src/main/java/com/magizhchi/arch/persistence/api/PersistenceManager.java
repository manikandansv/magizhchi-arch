package com.magizhchi.arch.persistence.api;


public interface PersistenceManager<T extends Object> {

  PersistenceService<T> getPersistenceService(Class<T> entity);

}
