package com.ayoosh.profilemanagement.service;

import com.ayoosh.profilemanagement.domain.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {
	void addEmployeeProfile(EmployeeProfile profile);
	List<EmployeeProfile> getEmployeeProfiles();
}
