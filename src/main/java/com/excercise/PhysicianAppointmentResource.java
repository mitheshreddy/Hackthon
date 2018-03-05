package com.excercise;

import java.net.Authenticator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.excercise.model.Appointments;
import com.excercise.model.Indicator;
import com.excercise.model.Physician;
import com.excercise.model.User;
import com.excercise.repository.AppointmentService;
import com.excercise.repository.AuthenticateUser;
import com.excercise.repository.PhysicianRepositoryCollection;
import com.google.gson.Gson;

@Path("physicians") // URI : http://localhost:9090/test-services/webapi/physicians
public class PhysicianAppointmentResource {

	private final PhysicianRepositoryCollection physicianRepositoryCollection = new PhysicianRepositoryCollection();

	@GET @Produces({ MediaType.APPLICATION_JSON })
	public Response getAllPhysicansById(@QueryParam(value = "id") final List<Long> ids) {
		List<Physician> physicians = null;
		if (ids.isEmpty()) {
			physicians = physicianRepositoryCollection.findAllPhysicains();
		}

		String superheroJson = new Gson().toJson(physicians);
		return Response.ok().entity(superheroJson)
				.header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("user") // http://localhost:9090/test-services/webapi/physicians/user
    @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces({MediaType.APPLICATION_JSON}) 
	public Response AutheticateUser(final MultivaluedMap<String, String> params)
    {
        final User user = new User();
        user.setEmailId(params.getFirst("emailId"));
        user.setPassword(params.getFirst("password"));
        String superheroJson = new Gson().toJson(AuthenticateUser.autheticate(user));
        // Call will be routed to actual database operations.
        return Response.ok().entity(superheroJson).build();
    }
	
	@Path("newappointment") // http://localhost:9090/test-services/webapi/physicians/newappointment
    @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces({MediaType.TEXT_PLAIN}) 
	public Response addNewAppointment(final MultivaluedMap<String, String> params)
    {
        final Appointments appointment = new Appointments();
        appointment.setSlot(Integer.parseInt(params.getFirst("slot")));
        appointment.setPhysicanId(params.getFirst("physicianid"));
        appointment.setuserId(params.getFirst("userid"));
        appointment.setSlotStatus(Integer.parseInt(params.getFirst("slotstatus")));
        String superheroJson = new Gson().toJson(AppointmentService.getAppointments(appointment));
        
        // Call will be routed to actual database operations.
        return Response.ok().entity(superheroJson)
				.header("Access-Control-Allow-Origin", "*").build();
    }
	
	@Path("updateappointment") // http://localhost:9090/test-services/webapi/physicians/updateappointment
    @PUT @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces({MediaType.TEXT_PLAIN}) 
	public Response updateAppointment(final MultivaluedMap<String, String> params)
    {
        final Appointments appointment = new Appointments();
        appointment.setSlot(Integer.parseInt(params.getFirst("slot")));
        appointment.setPhysicanId(params.getFirst("physicianid"));
        appointment.setuserId(params.getFirst("userid"));
        appointment.setSlotStatus(Integer.parseInt(params.getFirst("slotstatus")));
        String superheroJson = new Gson().toJson(AppointmentService.updateAppointments(appointment));
        
        // Call will be routed to actual database operations.
        return Response.ok().entity(superheroJson)
				.header("Access-Control-Allow-Origin", "*").build();
    }

}
