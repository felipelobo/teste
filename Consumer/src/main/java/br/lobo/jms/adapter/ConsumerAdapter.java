/**
 * 
 */
package br.lobo.jms.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * @author Felipe
 *
 */
@Component
public class ConsumerAdapter {
	
	private static Logger logger = LogManager.getLogger(ConsumerAdapter.class.getName());

	public void sendToMongo(String json) {
		logger.info("Sending to MongoDB");
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("vendor");
		MongoCollection<BasicDBObject> collection = db.getCollection("contact",BasicDBObject.class);
		logger.info("Converting JSON to DBObject");
		BasicDBObject object = (BasicDBObject) JSON.parse(json);
		collection.insertOne(object);
		logger.info(collection.count());
		logger.info("Sent to MongoDB");
		client.close();
	}

}
