package com.excercise.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Physician {
	private String physicianId;
	private String physicianName;
	private ArrayList<Appointments> appointmentsArray;
	
	public Physician() {
		appointmentsArray = new ArrayList<Appointments>();
	}
	
	public String getPhysicanId()
    {
        return physicianId;
    }

    public void setPhysicanId(final String physicianId)
    {
        this.physicianId = physicianId;
    }

    public String getPhysicanName()
    {
        return physicianName;
    }

    public void setPhysicanName(final String physicianName)
    {
        this.physicianName = physicianName;
    }

	public void addAppointment(Appointments appointment) {
		this.appointmentsArray.add(appointment);
	}
	
	public List<Appointments> getappointmentsArray() {
		return appointmentsArray;
	}

	

}
