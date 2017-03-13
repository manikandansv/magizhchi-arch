package com.magizhchi.arch.mapper.api;

public interface VOMapper<S, T> {
  
  public T map(S source, MappingContext mappingContext);

}
