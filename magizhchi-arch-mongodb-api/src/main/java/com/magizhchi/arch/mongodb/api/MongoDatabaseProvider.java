package com.magizhchi.arch.mongodb.api;

import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

public interface MongoDatabaseProvider {

  String PROP_ALIAS = "mongodatabaseprovider.property.alias";

  String PROP_DATABASE_NAME = "mongodatabaseprovider.property.dbName";

  String PROP_USERNAME = "mongodatabaseprovider.property.userName";

  String PROP_PASSWORD = "mongodatabaseprovider.property.password";

  String PROP_CLIENT_FILTER = "mongodatabaseprovider.property.clientfilter";

  MongoDatabase getMongoDatabase();

  String getDatabaseAlias();

  String getDatabaseName();

  String getUserName();

  String getPassword();

  String getClientFilter();

  DB getMongoDatabaseDeprecated();

}
