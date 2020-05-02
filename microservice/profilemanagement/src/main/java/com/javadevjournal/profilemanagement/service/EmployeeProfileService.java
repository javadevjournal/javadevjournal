package com.javadevjournal.profilemanagement.service;

import com.javadevjournal.profilemanagement.domain.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {
	void addEmployeeProfile(EmployeeProfile profile);
	List<EmployeeProfile> getEmployeeProfiles();
}
