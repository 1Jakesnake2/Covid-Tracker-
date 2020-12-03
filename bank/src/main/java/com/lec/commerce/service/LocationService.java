package com.lec.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.dLocation;
import com.lec.commerce.domain.dUser;
import com.lec.commerce.repository.LocationRepository;
import com.lec.commerce.repository.UserRepository;

@Service
@Transactional
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public String join(dLocation location) {
		locationRepository.save(location);
		return location.getOffice();
	}
	
	public List<dLocation> getLocationList() {
		List<dLocation> locations = locationRepository.findAll();
		return locations;
	}
	
	public List<dLocation> getUserLocations(dUser user) {
		List<dLocation> locations = locationRepository.findUserList(user);
		return locations;
		
	}
	
	public void updateLocationStatus(int id, int status) {
		locationRepository.updateLocationStatus(status, id);
	}
	
/*	public String join(dUser duser) {
		
		validateUser(duser);
		userRepository.save(duser);
		return duser.getUsername();
	}
	
	private void validateUser(dUser duser) {
		
		List<dUser> users = userRepository.findByName(duser.getUsername());
		if(!users.isEmpty()) {
			throw new IllegalStateException("id exists");
		}

	}
	
	
	
	public List<dUser> getUserList() {
		
		List<dUser> users = userRepository.findall();
		
		return users;
		
	}
*/	
}
