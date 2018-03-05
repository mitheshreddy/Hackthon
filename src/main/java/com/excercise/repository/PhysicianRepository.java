package com.excercise.repository;

import java.util.List;

import com.excercise.model.Physician;;

public interface PhysicianRepository {
	
	List<Physician> findAllPhysicains();

}
