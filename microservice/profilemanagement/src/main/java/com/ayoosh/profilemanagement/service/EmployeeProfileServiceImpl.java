package com.ayoosh.profilemanagement.service;

import com.ayoosh.profilemanagement.domain.EmployeeProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
	List<EmployeeProfile> employeeProfileList = new ArrayList<>();

	@Override
	public void addEmployeeProfile(EmployeeProfile profile) {
			employeeProfileList.add(profile);
	}

	@Override
	public List<EmployeeProfile> getEmployeeProfiles() {
		return employeeProfileList;
	}
}
