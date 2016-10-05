package com.magizhchi.arch.mongodb.api;

import java.util.Date;

import org.bson.types.ObjectId;

public interface Model {

  Object getId();
  
  String getHash();
  
  /**
   * set the reference to given ID Used when saving to history collection, a reference is maintained
   * to most upto date object in the active collection
   * 
   * @param id
   */
  void setReference(ObjectId id);

  /**
   * get document version number
   * 
   * @return a monotonically increasing number
   */
  int getVersion();

  /**
   * Increment version
   */
  void incrementVersion();

  /**
   * When was the change created
   * 
   * @return
   */
  Date createdAt();

  /**
   * who was responsible
   * 
   * @return
   */
  String createdBy();


  /**
   * Set id
   * 
   * @param object
   */
  public void setId(Object object);
  
}
