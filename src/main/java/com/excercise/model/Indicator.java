package com.excercise.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Indicator {
	public static enum enumIndicators{
		SUCCESS,
		FAILURE
		
	}
	private enumIndicators successInd;
	
	public enumIndicators getIndicator() {
		return this.successInd;
	}
	
	public void setIndicator(enumIndicators ind) {
		this.successInd = ind;
	}
}
