package com.excercise.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONObject;

import com.excercise.model.Appointments;
import com.excercise.model.Indicator;
import com.excercise.model.Physician;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class AppointmentService {
	
	public static Indicator getAppointments(Appointments appointment) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		Indicator ind = new Indicator();
		credential = MongoCredential.createCredential("sampleUser", "physiciandb", "password".toCharArray());

		MongoDatabase database = mongo.getDatabase("physiciandb");

		MongoCollection<Document> collection = database.getCollection("appointments");
		
		try {
		      Document document = new Document("physicianid", appointment.getPhysicanId()) 
		      .append("userid", appointment.getuserId())
		      .append("slot", appointment.getSlot()) 
		      .append("slotstatus", appointment.getSlotStatus()) ;  
		      collection.insertOne(document); 
			
		} catch (Exception e) {
		}
		
		ind.setIndicator(Indicator.enumIndicators.SUCCESS);

		mongo.close();
		
		return ind;

	}
	
	public static Indicator updateAppointments(Appointments appointment) {
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		Indicator ind = new Indicator();
		credential = MongoCredential.createCredential("sampleUser", "physiciandb", "password".toCharArray());

		MongoDatabase database = mongo.getDatabase("physiciandb");

		MongoCollection<Document> collection = database.getCollection("appointments");
		
		try {		     
		      
		      collection.updateOne(Filters.and(Filters.eq("physicianid", appointment.getPhysicanId()), Filters.eq("userid", appointment.getuserId()), Filters.eq("slot", appointment.getSlot())), Updates.set("slotstatus", appointment.getSlotStatus())); 
			
		} catch (Exception e) {
		}
		
		ind.setIndicator(Indicator.enumIndicators.SUCCESS);

		mongo.close();
		
		return ind;
		
	}

}
