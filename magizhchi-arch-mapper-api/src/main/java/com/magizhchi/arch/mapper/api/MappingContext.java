package com.magizhchi.arch.mapper.api;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Mapping context is transported through mapping flow to provide functionality as:
 * Avoid cycles in mapping flow
 * 
 *
 */
public class MappingContext {

  /** 
   * contains a map for each mapper, with all object already mapped by VOMapperUtil 
   * to avoid cycles IdentityHashMap is used for the inner map to avoid wrong mapping 
   * due to two equal source sub VOs
   **/
  private Map<VOMapper<?, ?>, Map<Object, Object>> watchList;

  /**
   * Standard constructor with default visibility, so that it can only be
   * created from the VOMapperUtils.
   */
  public MappingContext() {
    watchList = new HashMap<VOMapper<?, ?>, Map<Object, Object>>();
  }

  /**
    * Adds an object to the watch list
    * @param <S> source type
    * @param <T> target type
    * @param mapper mapper to select the right watchList 
    * @param source Object which was already mapped
    * @param target Object to which it was mapped
    */
  public <S, T> void putObject(VOMapper<S, T> mapper, S source, T target) {
    Map<Object, Object> mapperWatchList = watchList.get(mapper);
    if (mapperWatchList == null) {
      mapperWatchList = new IdentityHashMap<Object, Object>();
      watchList.put(mapper, mapperWatchList);
    }
    mapperWatchList.put(source, target);
  }

  /**
   * Checks whether the object was already mapped by VOMapperUtil, because it's already stored in the watch list
   * @param <S> source type
   * @param <T> target type
   * @param mapper mapper to select the right watchList 
   * @param source the object to be checked
   * @return true if already mapped; false if not
   */
  public <S, T> boolean contains(VOMapper<S, T> mapper, S source) {
    Map<Object, Object> mapperWatchList = watchList.get(mapper);
    if (mapperWatchList == null) {
      return false;
    }
    return mapperWatchList.containsKey(source);
  }

  /**
   * Delivers the target object for a source object if existent.
   * @param <S> source typezz
   * @param <T> target type
   * @param mapper mapper to select the right watchList 
   * @param source the object to be checked
   * @return the target object to the key or null if not available
   */
  @SuppressWarnings(value = "unchecked")
  public <S, T> T getObject(VOMapper<S, T> mapper, S source) {
    Map<Object, Object> mapperWatchList = watchList.get(mapper);
    if (mapperWatchList == null) {
      return null;
    }
    return (T) mapperWatchList.get(source);
  }

}
