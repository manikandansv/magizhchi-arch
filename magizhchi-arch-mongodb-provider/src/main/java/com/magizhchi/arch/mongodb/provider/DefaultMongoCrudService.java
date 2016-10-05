package com.magizhchi.arch.mongodb.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.bson.types.ObjectId;
import org.jongo.Aggregate;
import org.jongo.Aggregate.ResultsIterator;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.ResultHandler;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.mongodb.api.Model;
import com.magizhchi.arch.mongodb.api.MongoCrudService;
import com.magizhchi.arch.mongodb.api.MongoDatabaseProvider;
import com.magizhchi.arch.utilities.api.PropertiesUtil;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Component(enabled = true, immediate = true)
@Service
public class DefaultMongoCrudService<T extends Model> implements MongoCrudService<T> {

  protected String m_collectionName;

  private Class<T> m_clazz;

  @Reference
  private MongoDatabaseProvider mongoDatabaseProvider;

  private MongoCollection mongoCollection;

  public static final String DEFAULT_READ_LIMIT = "default.readLimit";

  @Property(name = DEFAULT_READ_LIMIT)
  private Integer limit;

  @Activate
  protected void activate(ComponentContext ctx) {
    this.limit = PropertiesUtil.toInteger(ctx.getProperties().get(DEFAULT_READ_LIMIT), 10);
  }

  public DefaultMongoCrudService() {}

  /**
   * Constructor to setup the collection and generic type of this CRUD service.
   * 
   * @param collectionName The collection name in Mongo
   * @param clazz The type to work with in this CRUD service.
   */
  public DefaultMongoCrudService(String collectionName, Class<T> clazz) {
    m_collectionName = collectionName;
    m_clazz = clazz;
  }

  public void start() {
    mongoCollection = new Jongo(mongoDatabaseProvider.getMongoDatabaseDeprecated()).getCollection(m_collectionName);
  }

  protected void ensureIndex() {};

  @Override
  public Object save(T obj) {

    WriteResult saveResult = mongoCollection.save(obj);

    Object saveId = null;

    if (saveResult != null && saveResult.getUpsertedId() != null) {

      saveId = saveResult.getUpsertedId();

    }

    return saveId;
  }

  /**
   * Deletes a document based on ID. ID is converted into ObjectId. Convenience method
   *
   * @param id
   */
  @Override
  public void delete(String id) {
    mongoCollection.remove(new ObjectId(id));
  }

  /**
   * Deletes given document
   *
   * @param id
   */
  @Override
  public void delete(ObjectId id) {
    mongoCollection.remove(id);
  }

  /**
   * Aggregate
   *
   * @param pipeline - multiple pipelines
   * @return
   */
  @Override
  public List<T> aggregate(String... pipeline) {

    List<T> outputList = new ArrayList<T>();

    int i = 0;
    Aggregate agr = null;
    for (String p : pipeline) {
      if (i == 0) {
        agr = mongoCollection.aggregate(p);
      } else {
        agr = agr.and(p);
      }
    }

    ResultsIterator<T> itr = agr.as(m_clazz);

    while (itr.hasNext()) {
      outputList.add(itr.next());
    }

    return outputList;
  }

  /**
   * Aggregate - single pipeline
   *
   * @param pipeline
   * @return
   */
  @Override
  public List<T> aggregate(String pipeline) {

    List<T> outputList = new ArrayList<T>();

    Aggregate agr = mongoCollection.aggregate(pipeline);

    ResultsIterator<T> itr = agr.as(m_clazz);

    while (itr.hasNext()) {
      outputList.add(itr.next());
    }

    return outputList;
  }

  @Override
  public int getLimit() {
    return limit;
  }

  @Override
  public long count() {
    return mongoCollection.count();
  }

  @Override
  public long count(String query, Object... parameters) {
    return mongoCollection.count(query, parameters);
  }

  @Override
  public List<T> list() {
    return list(0, 0, null);
  }

  @Override
  public List<T> list(int limit, int page) {
    return list(limit, page, null);
  }

  @Override
  public List<T> list(int limit, int page, String sort) {
    if (page < 1) {
      page = 1;
    }
    page = (page < 0) ? -page : page;
    page--;
    limit = (limit < 0) ? 10 : limit;
    return copyIterator(mongoCollection.find().limit(limit).skip(page * limit).sort(sort).as(m_clazz).iterator());
  }

  @Override
  public List<T> list(int limit, int page, String sort, String query) {
    if (page < 1) {
      page = 1;
    }
    page = (page < 0) ? -page : page;
    page--;
    limit = (limit < 0) ? 10 : limit;
    return copyIterator(mongoCollection.find(query).limit(limit).skip(page * limit).sort(sort).as(m_clazz).iterator());
  }

  @Override
  public String listJSON(int limit, int skip, DBObject query, DBObject fields) {

    DBCollection col = mongoDatabaseProvider.getMongoDatabaseDeprecated().getCollection(this.m_collectionName);

    return col.find(query, fields).limit(limit).skip(skip).toArray().toString();

  }

  @Override
  public T find(ObjectId id) {
    return mongoCollection.findOne(id).as(m_clazz);
  }

  @Override
  public T find(ObjectId id, Class<T> type) {
    return mongoCollection.findOne(id).as(type);
  }

  @Override
  public T find(String id, ResultHandler<T> handler) {
    return mongoCollection.findOne(new ObjectId(id)).map(handler);
  }

  @Override
  public T find(String id) {
    return mongoCollection.findOne(new ObjectId(id)).as(m_clazz);
  }

  @Override
  public T find(String id, String fields) {
    return mongoCollection.findOne(new ObjectId(id)).projection(fields).as(m_clazz);
  }

  @Override
  public Object update(ObjectId id, T object) {

    WriteResult updatedResult = mongoCollection.update(id).with(object);

    Object updatedId = null;

    if (updatedResult != null && updatedResult.getUpsertedId() != null) {

      updatedId = updatedResult.getUpsertedId();

    }

    return updatedId;

  }

  @Override
  public Object update(String query, T object) {

    WriteResult updatedResult = mongoCollection.update(query).with(object);

    Object updatedId = null;

    if (updatedResult != null && updatedResult.getUpsertedId() != null) {

      updatedId = updatedResult.getUpsertedId();

    }

    return updatedId;

  }

  @Override
  public Object update(String query, T object, Object... parameters) {

    WriteResult updatedResult = mongoCollection.update(query, parameters).with(object);

    Object updatedId = null;

    if (updatedResult != null && updatedResult.getUpsertedId() != null) {

      updatedId = updatedResult.getUpsertedId();

    }

    return updatedId;

  }


  /**
   * Converts an iterator to a List
   *
   * @param <T>
   * @param iter
   * @return
   */
  public static <T> List<T> copyIterator(Iterator<T> iter) {
    List<T> copy = new ArrayList<T>();
    while (iter.hasNext()) {
      copy.add(iter.next());
    }
    return copy;
  }

  @Override
  public boolean isVersioned() {
    return false;
  }

  @Override
  public String getCollectionSuffix() {
    return ".history";
  }

  @Override
  public void deleteHistory(ObjectId referenceId) {
    mongoCollection.remove("{ref : #}", referenceId);
  }

  @Override
  public T getVersion(ObjectId referenceId, int version) {
    return null;
  }

  @Override
  public List<T> listVersions(ObjectId referenceId) {
    return null;
  }

  @Override
  public void writeHistory(MongoCollection collection, ObjectId id, T t) {

    if (isVersioned()) {

      t.setId(null);

      t.setReference(id);

      collection.save(t);
    }

  }

}
