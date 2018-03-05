package com.excercise.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSON;
import org.bson.Document;
import org.json.JSONObject;

import com.excercise.model.Indicator;
import com.excercise.model.Physician;
import com.excercise.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class AuthenticateUser {
	public static Indicator autheticate(User user) {
		Indicator ind = new Indicator();
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "physiciandb", "password".toCharArray());

		MongoDatabase database = mongo.getDatabase("physiciandb");

		MongoCollection<Document> collection = database.getCollection("users");
		
		Document myDoc = collection.find(Filters.and(Filters.eq("emailid", user.getEmailId()), Filters.eq("password", user.getPassword()))).first();
		
		if (myDoc != null) {
			ind.setIndicator(Indicator.enumIndicators.SUCCESS);
		}
		else
		{
			ind.setIndicator(Indicator.enumIndicators.FAILURE);
		}		

		mongo.close();
		
		return ind;

	}

}
