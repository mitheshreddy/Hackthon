package com.excercise.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.excercise.model.Appointments;
import com.excercise.model.Physician;
import org.json.*;

public class PhysicianRepositoryCollection implements PhysicianRepository {

	@Override
	public List<Physician> findAllPhysicains() {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "physiciandb", "password".toCharArray());

		MongoDatabase database = mongo.getDatabase("physiciandb");

		MongoCollection<Document> collection = database.getCollection("physician");

		List<Physician> physicans = new ArrayList<Physician>();

		Physician physician;
		try {
			for (Document cur : collection.find()) {
				physician = new Physician();
				JSONObject obj = new JSONObject(cur.toJson());
				physician.setPhysicanName(obj.getString("physicianName"));
				physician.setPhysicanId(obj.getString("id"));
				physicans.add(physician);
			}
		} catch (Exception e) {
		}

		mongo.close();
		
		List<Appointments> appointments = getAppointments();
		
		for (Physician physican: physicans) {
			for (Appointments appointment: appointments) {
				if (physican.getPhysicanId().equals(appointment.getPhysicanId())) {
					physican.addAppointment(appointment);
				}
			}
		}
		return physicans;

	}
	
	public List<Appointments> getAppointments() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "physiciandb", "password".toCharArray());

		MongoDatabase database = mongo.getDatabase("physiciandb");

		MongoCollection<Document> collection = database.getCollection("appointments");
		
		List<Appointments> appointments = new ArrayList<Appointments>();

		Appointments appointment;
		try {
			for (Document cur : collection.find()) {
				appointment = new Appointments();
				JSONObject obj = new JSONObject(cur.toJson());
				appointment.setPhysicanId(obj.getString("physicianid"));
				appointment.setuserId(obj.getString("userid"));
				appointment.setSlot(obj.getInt("slot"));
				appointment.setSlotStatus(obj.getInt("slotstatus"));
				appointments.add(appointment);
			}
		} catch (Exception e) {
		}

		mongo.close();
		return appointments;
	}

}
