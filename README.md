# MongoDBJDBC JDBC Test Program

First try working with MongoDBJDBC in Java, using the MongoDB JDBC driver. I have been testing this with Mongo Atlas. 

Important note: You must configure MongoDB Atlas to permit JDBC connections - instructions [here](https://www.mongodb.com/docs/atlas/data-federation/query/sql/getting-started/get-started-advanced/#std-label-sql-get-started-advanced).

This is a work in progress; please read this code before trying to run it.  :) 

You'll need to configure the environment variables to fit your setup - you'll need the cluster ID, username and password.
```shell
export MONGODB_CLUSTER_ID=cluster0.blahblah
export MONGODB_PASSWORD=mypassword
export MONGODB_USERNAME=myusername
```
The usual Maven incantation should be enough to build the runnable jar. 

```shell
git clone https://github.com/rcprcp/MongoDBJDBC
cd MongoDBJDBC
mvn package
java -jar target/MongoDBJDBC-1.0-SNAPSHOT-jar-with-dependencies.jar
```

TODO: 

- Need to finish setting up the logger; remove the System.out.println's
