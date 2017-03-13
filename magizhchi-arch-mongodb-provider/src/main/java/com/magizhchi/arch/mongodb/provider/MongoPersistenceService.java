package com.magizhchi.arch.mongodb.provider;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.mongodb.api.MagizhchiMongoModel;
import com.magizhchi.arch.mongodb.api.MongoClientProvider;
import com.magizhchi.arch.mongodb.api.MongoDatabaseProvider;
import com.magizhchi.arch.mongodb.api.MongoDatabaseProviderFactory;
import com.magizhchi.arch.persistence.api.PersistenceService;
import com.magizhchi.arch.utilities.api.PropertiesUtil;
import com.mongodb.DB;
import com.mongodb.WriteResult;

@Service
@Component(immediate = true, enabled = true)
public class MongoPersistenceService<T extends MagizhchiMongoModel> implements PersistenceService<T> {

  @Reference
  private MongoClientProvider mongoClientProvider;

  @Reference
  private MongoDatabaseProviderFactory mongoDatabaseProviderFactory;

  public static final String DEFAULT_READ_LIMIT = "default.readLimit";

  public static final String PERSISTENCE_SERVICE_ID = "persistence.service.id";

  private static final String DEFAULT_PERSISTENCE_SERVICE_ID_VALUE = "mongo";

  @Property(name = DEFAULT_READ_LIMIT)
  private Integer limit;

  @Property(name = PERSISTENCE_SERVICE_ID)
  private String persistenceServiceId;

  @Activate
  protected void activate(ComponentContext ctx) {
    this.limit = PropertiesUtil.toInteger(ctx.getProperties().get(DEFAULT_READ_LIMIT), 10);
    this.persistenceServiceId =
        PropertiesUtil.toString(ctx.getProperties().get(PERSISTENCE_SERVICE_ID), DEFAULT_PERSISTENCE_SERVICE_ID_VALUE);
  }

  @Override
  public String getPersistenceServiceId() {
    return persistenceServiceId;
  }

  private MongoCollection init(T obj) {

    String collectionName = obj.getCollectionName();

    MongoDatabaseProvider mongoDatabaseProvider =
        mongoDatabaseProviderFactory.getMongoDatabaseProviderByCollectionName(collectionName);

    DB db = mongoDatabaseProvider.getMongoDatabaseDeprecated(mongoClientProvider);

    MongoCollection mongoCollection = new Jongo(db).getCollection(collectionName);

    return mongoCollection;
  }


  @SuppressWarnings("unchecked")
  @Override
  public T create(T entity) {

    MongoCollection mongoCollection = init(entity);

    WriteResult saveResult = mongoCollection.save(entity);

    String saveId = null;

    if (saveResult != null && saveResult.getUpsertedId() != null) {

      saveId = saveResult.getUpsertedId().toString();

    }

    T persistedEntity = load((Class<T>) entity.getClass(), saveId);

    return persistedEntity;

  }

  @Override
  public T update(T object, long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T update(T object, String id) {

    T returnObj = null;

    MongoCollection mongoCollection = init(object);

    WriteResult updatedResult = mongoCollection.update(id).with(object);

    String updatedId = null;

    if (updatedResult != null && updatedResult.getUpsertedId() != null) {

      updatedId = (String) updatedResult.getUpsertedId();

    }

    returnObj = load((Class<T>) object.getClass(), updatedId);

    return returnObj;
  }

  @Override
  public T load(Class<? extends T> entity, long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T load(Class<? extends T> entity, String id) {

    T returnObj = null;

    try {

      MongoCollection mongoCollection = init(entity.newInstance());

      returnObj = mongoCollection.findOne(id).as(entity);

    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return returnObj;
  }

  @Override
  public void remove(T object, long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void remove(T object, String id) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean contains(T o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T update(T object, Object id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove(T object, Object id) {
    // TODO Auto-generated method stub

  }



}
