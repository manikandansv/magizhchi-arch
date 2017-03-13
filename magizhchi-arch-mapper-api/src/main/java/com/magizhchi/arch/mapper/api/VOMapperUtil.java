package com.magizhchi.arch.mapper.api;

import java.util.List;


/**
 * Abstract VOMapper utility class to be implemented by the VOMapperUtil. This
 * class will contain a Map of VOMappers and wrapper functions to call them.
 * 
 * @param <S>
 * @param <T>
 */
public interface VOMapperUtil<S, T, M extends VOMapper<S, T>> {

  void addMapping(Class<S> source, Class<T> target, VOMapper<S, T> voMapper2);

  void addMapping(Class<S> source, Class<T> target);

  T map(S source, Class<T> targetClass, MappingContext ctx);

  M getMapping(S source, Class<T> targetClass);

  T map(S source, Class<T> targetClass);

  List<T> map(List<S> source, Class<T> targetClass, MappingContext mappingContext);

  List<T> map(List<S> source, Class<T> targetClass);

 
}
