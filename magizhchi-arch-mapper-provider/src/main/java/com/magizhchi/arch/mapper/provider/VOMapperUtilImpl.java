package com.magizhchi.arch.mapper.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.magizhchi.arch.mapper.api.MappingContext;
import com.magizhchi.arch.mapper.api.VOMapper;
import com.magizhchi.arch.mapper.api.VOMapperUtil;

public class VOMapperUtilImpl<S extends Object, T extends Object, M extends VOMapper<S, T>> implements VOMapperUtil<S, T, M> {

  private VOMapper<S, T> voMapper;

  /**
   * map of mapper classes where the key consists of input and output type
   */
  private Map<Key, VOMapper<?, ?>> mappers = new HashMap<Key, VOMapper<?, ?>>();


  /**
   * Registers a mapper with the class
   * 
   * @param <S> Input type of mapper
   * @param <T> Output type of mapper
   * @param source Class of Input type
   * @param target Class of Output type
   * @param voMapper2 Actual mapper to use
   */
  @Override
  public void addMapping(Class<S> source, Class<T> target, VOMapper<S, T> voMapper2) {
    mappers.put(new Key(source, target), voMapper2);
  }

  /**
   * Instantiates a mapper with the ApplicationServiceFactory and registers it with the class
   * 
   * @param <S> Input type of mapper
   * @param <T> Output type of mapper
   * @param source Class of Input type
   * @param target Class of Output type
   * @param mapper Class of mapper to use
   */
  @Override
  public void addMapping(Class<S> source, Class<T> target) {
    addMapping(source, target, voMapper);
  }

  /**
   * Lookup method for specific mapper
   * 
   * @param <M> Type bound for type safe mapper get
   * @param <S> Input type of Mapper
   * @param <T> Output type of Mapper
   * @param source Source object to be mapped
   * @param targetClass Class of output type
   * @return Mapper capable of mapping Input object to output type or null if not found
   */
  @Override
  @SuppressWarnings(value = "unchecked")
  public  M getMapping(S source, Class<T> targetClass) {
    return (M) mappers.get(new Key(source.getClass(), targetClass));
  }

  /**
   * This method will recursively map a source VO into a VO of the type given by the target class.
   * 
   * @param <S> source type
   * @param <T> target type
   * @param source source object
   * @param targetClass target class
   * @param ctx mapping context to use
   * @return the newly created target class
   */
  @Override
  public T map(S source, Class<T> targetClass, MappingContext ctx) {
    if (source == null) {
      return null;
    }
    VOMapper<S, T> mapper = getMapping(source, targetClass);
    if (ctx.contains(mapper, source)) {
      return ctx.getObject(mapper, source);
    }

    if (mapper == null) {
      throw new IllegalArgumentException("Mapping from " + source.getClass().getSimpleName() + " to "
          + targetClass.getSimpleName() + " is not defined.");
    }
    return mapper.map(source, ctx);
  }

  /**
   * This method will recursively map a source VO into a VO of the type given by the target class.
   * 
   * @param <S> source type
   * @param <T> target type
   * @param source source object
   * @param targetClass target class
   * @return the newly created target class
   */
  @Override
  public T map(S source, Class<T> targetClass) {
    return map(source, targetClass, createMappingContextForMapping());
  }

  /**
   * maps a list of source vos to a new list of target vos
   * 
   * @param <S> source VO
   * @param <T> target VO
   * @param source source list
   * @param targetClass class of target vos contained in the list returned to client
   * @param mappingContext MappingContext
   * @return a list filled with target VOs
   **/
  @Override
  public List<T> map(List<S> source, Class<T> targetClass, MappingContext mappingContext) {
    ArrayList<T> newList = new ArrayList<T>();
    for (S element : source) {
      newList.add(map(element, targetClass, mappingContext));
    }
    return newList;
  }

  /**
   * maps a list of source vos to a new list of target vos
   * 
   * @param <S> source VO
   * @param <T> target VO
   * @param source source list
   * @param targetClass class of target vos contained in the list returned to client
   * @return a list filled with target VOs
   **/
  @Override
  public List<T> map(List<S> source, Class<T> targetClass) {
    return map(source, targetClass, new MappingContext());
  }

  /**
   * Private class to create a key from two classes (input and output class of mapper) so that we
   * are able to safe the mappers in a map (input, output) -> mapper<input, output>
   * 
   * @author F155025 Mathias Poths
   */
  private static class Key {
    /** source class **/
    private Class<?> source;

    /** target class **/
    private Class<?> target;

    /**
     * standard constructor
     * 
     * @param source source class
     * @param target target class
     */
    public Key(Class<?> source, Class<?> target) {
      this.source = source;
      this.target = target;
    }

    /** {@inheritDoc} **/
    @Override
    public int hashCode() {
      int hash = 7;
      hash += 31 * source.hashCode();
      hash += 31 * target.hashCode();
      return hash;
    }

    /** {@inheritDoc} **/
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Key) {
        Key otherKey = (Key) obj;
        return otherKey.source == source && otherKey.target == target;
      } else {
        return false;
      }
    }
  }
  
  /**
   * @return creates you a new mapping context for a mapping
   */
  public static MappingContext createMappingContextForMapping() {
    return new MappingContext();
  }

}
