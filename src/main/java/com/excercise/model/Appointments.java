package com.excercise.model;

public class Appointments {
	private String physicianId;
	private String userId;
	private int slot;
	private int slotStatus;

	
	
	public void setPhysicanId(String physicianId) {
		this.physicianId = physicianId;
	}
	
	public String getPhysicanId() {
		return this.physicianId;
	}
	
	public void setuserId(String userId) {
		this.userId = userId;
	}
	
	public String getuserId() {
		return this.userId;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getSlotStatus() {
		return slotStatus;
	}

	public void setSlotStatus(int slotStatus) {
		this.slotStatus = slotStatus;
	}


}
