package com.github.ukraine1449.queststest.Mongo;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoCon {
    public MongoClient mongoClient;
    public DB database;
    public DBCollection collection;
    public MongoCon(String host, Integer port, String DB, String collection) throws UnknownHostException {
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb://" + host + ":" + port));
        this.database = mongoClient.getDB(DB);
        this.collection = database.getCollection(collection);
    }
    public void insertToDB(DBObject dbo){
        collection.insert(dbo);
    }
    public DBCursor loadFromDB(DBObject query){
        return collection.find(query);
    }
    public void close(){
        mongoClient.close();
    }
}
