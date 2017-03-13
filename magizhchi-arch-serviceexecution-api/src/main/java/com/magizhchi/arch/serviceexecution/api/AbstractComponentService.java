package com.magizhchi.arch.serviceexecution.api;

import com.magizhchi.arch.persistence.api.PersistenceService;

public interface AbstractComponentService<T> {

  PersistenceService<T> getPersistenceService();

}
