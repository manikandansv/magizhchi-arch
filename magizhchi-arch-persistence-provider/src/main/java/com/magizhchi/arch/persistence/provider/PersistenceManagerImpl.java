package com.magizhchi.arch.persistence.provider;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.magizhchi.arch.mongodb.api.MagizhchiMongoModel;
import com.magizhchi.arch.persistence.api.PersistenceManager;
import com.magizhchi.arch.persistence.api.PersistenceService;
import com.magizhchi.arch.persistence.api.PersistenceServiceFactory;

@Service
@Component(immediate = true, enabled = true)
public class PersistenceManagerImpl<T extends Object> implements PersistenceManager<T> {

  @Reference
  private PersistenceServiceFactory<T> persistenceServiceFactory;

  @Override
  public PersistenceService<T> getPersistenceService(Class<T> entity) {

    if (entity.isAssignableFrom(MagizhchiMongoModel.class)) {

      return persistenceServiceFactory.getPersistenceService(MagizhchiMongoModel.getPersistenceServiceId());

    }

    return null;
  }

}
