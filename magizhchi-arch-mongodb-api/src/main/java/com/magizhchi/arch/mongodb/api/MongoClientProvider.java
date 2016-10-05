package com.magizhchi.arch.mongodb.api;

import com.mongodb.MongoClient;

public interface MongoClientProvider {


  /**
   * The service property key for the client id. The value must be unique to an OSGi application
   * instance.
   */
  String PROP_CLIENT_ID = "mongoclientprovider.prop.clientId";

  /**
   * The service property key for the client URI. The value may be a single URI for one MongoDB
   * server, or a CSV of URIs for a MongoDB replica set. The value must have the form:
   * mongodb://host[:port] [,mongodb://host[:port]] You may optionally specify a user, password, and
   * database in which case, the URI would have the form:
   * user:password@mongodb://host[:port]/database [,user:password@mongodb://host[:port]/database]
   */
  String PROP_URI = "mongoclientprovider.prop.uri";

  /**
   * The service property key for: Sets whether JMX beans registered by the driver should always be
   * MBeans, regardless of whether the VM is Java 6 or greater.
   */
  String PROP_ALWAYS_USE_MBEANS = "alwaysUseMBeans";

  /**
   * The service property key for: The maximum number of connections allowed per host for this Mongo
   * instance. Those connections will be kept in a pool when idle. Once the pool is exhausted, any
   * operation requiring a connection will block waiting for an available connection. Default is
   * 100.
   */
  String PROP_CONNECTIONS_PER_HOST = "mongoclientprovider.prop.connectionsPerHost";

  /**
   * The service property key for: The connection timeout in milliseconds. It is used solely when
   * establishing a new connection Socket.connect(java.net.SocketAddress, int) Default is 0 and
   * means no timeout.
   */
  String PROP_CONNECT_TIMEOUT = "mongoclientprovider.prop.connectTimeout";

  /**
   * The service property key for: Sets whether cursor finalizers are enabled.
   */
  String PROP_CURSOR_FINALIZER_ENABLED = "mongoclientprovider.prop.cursorFinalizerEnabled";

  /**
   * The service property key for: The description for Mongo instances created with these options.
   * This is used in various places like logging.
   */
  String PROP_DESCRIPTION = "mongoclientprovider.prop.description";

  /**
   * The service property key for: Sets the connect timeout for connections used for the cluster
   * heartbeat.
   */
  String PROP_HEARTBEAT_CONNECT_TIMEOUT = "mongoclientprovider.prop.heartbeatConnectTimeout";

  /**
   * The service property key for: Sets the heartbeat frequency.
   */
  String PROP_HEARTBEAT_FREQUENCY = "mongoclientprovider.prop.heartbeatFrequency";

  /**
   * The service property key for: Sets the socket timeout for connections used for the cluster
   * heartbeat.
   */
  String PROP_HEARTBEAT_SOCKET_TIMEOUT = "mongoclientprovider.prop.sockettimeout";

  /**
   * The service property key for: Sets the local threshold.
   */
  String PROP_LOCAL_THRESHOLD = "mongoclientprovider.prop.localThreshold";

  /**
   * The service property key for: Sets the maximum idle time for a pooled connection.
   */
  String PROP_MAX_CONNECTION_IDLE_TIME = "mongoclientprovider.prop.maxConnectionIdleTime";

  /**
   * The service property key for: Sets the maximum life time for a pooled connection.
   */
  String PROP_MAX_CONNECTION_LIFE_TIME = "mongoclientprovider.prop.maxConnectionLifeTime";

  /**
   * The service property key for: The maximum wait time in ms that a thread may wait for a
   * connection to become available. Default is 120,000.
   */
  String PROP_MAX_WAIT_TIME = "mongoclientprovider.prop.maxWaitTime";

  /**
   * The service property key for: Sets the minimum number of connections per host.
   */
  String PROP_MIN_CONNECTIONS_PER_HOST = "mongoclientprovider.prop.minConnectionsPerHost";

  /**
   * The service property key for: Sets the minimum heartbeat frequency.
   */
  String PROP_MIN_HEARTBEAT_FREQUENCY = "mongoclientprovider.prop.minHeartbeatFrequency";

  /**
   * The service property key for: The read preference type.
   */
  String PROP_READ_PREFERENCE_TYPE = "mongoclientprovider.prop.readPreferenceType";

  /**
   * The service property key for: The read preference tags.
   */
  String PROP_READ_PREFERENCE_TAGS = "mongoclientprovider.prop.readPreferenceTags";

  /**
   * The service property key for: The required replica set name.
   */
  String PROP_REQUIRED_REPLICA_SET_NAME = "mongoclientprovider.prop.requiredReplicaSetName";

  /**
   * The service property key for: Sets the server selection timeout in milliseconds, which defines
   * how long the driver will wait for server selection to succeed before throwing an exception.
   */
  String PROP_SERVER_SELECTION_TIMEOUT = "mongoclientprovider.prop.serverSelectionTimeout";

  /**
   * The service property key for: This flag controls the socket keep alive feature that keeps a
   * connection alive through firewalls Socket.setKeepAlive(boolean) Default is false.
   */
  String PROP_SOCKET_KEEP_ALIVE = "mongoclientprovider.prop.socketKeepAlive";

  /**
   * The service property key for: The socket timeout in milliseconds It is used for I/O socket read
   * and write operations Socket.setSoTimeout(int) Default is 0 and means no timeout.
   */
  String PROP_SOCKET_TIMEOUT = "mongoclientprovider.prop.socketTimeout";

  /**
   * The service property key for: Sets whether to use SSL.
   */
  String PROP_SSL_ENABLED = "mongoclientprovider.prop.sslEnabled";

  /**
   * The service property key for: Define whether invalid host names should be allowed.
   */
  String PROP_SSL_INVALID_HOST_NAME_ALLOWED = "mongoclientprovider.prop.sslInvalidHostNameAllowed";

  /**
   * The service property key for: This multiplier, multiplied with the connectionsPerHost setting,
   * gives the maximum number of threads that may be waiting for a connection to become available
   * from the pool. All further threads will get an exception right away. For example if
   * connectionsPerHost is 10 and threadsAllowedToBlockForConnectionMultiplier is 5, then up to 50
   * threads can wait for a connection. Default is 5.
   */
  String PROP_THREADS_ALLOWED_TO_BLOCK_FOR_CONNECTION_MULTIPLIER =
      "mongoclientprovider.prop.threadsAllowedToBlockForConnectionMultiplier";

  /**
   * The service property key for: The 'w' value of the global WriteConcern. Default is 0.
   */
  String PROP_WRITECONCERNW = "mongoclientprovider.prop.w";

  /**
   * The service property key for: The 'wtimeout' value of the global WriteConcern. Default is 0.
   */
  String PROP_WTIMEOUT = "mongoclientprovider.prop.wtimeout";

  /**
   * The service property key for: The 'fsync' value of the global WriteConcern. Default is false.
   */
  String PROP_FSYNC = "mongoclientprovider.prop.fsync";

  /**
   * The service property key for: The 'j' value of the global WriteConcern. Default is false.
   */
  String PROP_J = "j";

  MongoClient getMongoClient();

  String getClientId();

  String[] getURIs();

}
