package com.lec.commerce.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.commerce.domain.dLocation;
import com.lec.commerce.domain.dUser;
import com.lec.commerce.repository.LocationRepository;
import com.lec.commerce.repository.UserRepository;
import com.lec.commerce.service.LocationService;
import com.lec.commerce.service.UserService;
import com.lec.commerce.web.User;

@Controller
public class MyController {
	

	dUser currentUser = new dUser();
	
	@Autowired UserService userservice;
	@Autowired UserRepository userRepository;
	@Autowired LocationService locationService;
	@Autowired LocationRepository locationRepository;
	
	Boolean session = false;
	
	
	@RequestMapping(value = "/test/hello")
	public String hello() {
		return "index";
	}
	
	@RequestMapping(value = "/list")
	public String userList(Model model) {
		
		List<dUser> users = userservice.getUserList();
	    for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUsername());}
		
		model.addAttribute("userlist", users);
		return "list";
	}
	
	@RequestMapping(value="/log", method = RequestMethod.GET)
	public String login() {
		return "index";
	}
	
	@RequestMapping(value="/locations")
	public String locations() {
		return "locations";
	}
	
	
	@RequestMapping(value="/history")
	public String history(Model model) {
		
		List<dLocation> locations = locationService.getUserLocations(currentUser);
		//for(int i=0;i<locations.size();i++) {
			//System.out.println(locations.get(i).getOffice());}
		model.addAttribute("loginstatus", session);
		model.addAttribute("email" , currentUser.getEmail());
		model.addAttribute("locationlist", locations);
		return "history";
	}
	@RequestMapping(value="/submitcase")
	public String submitCase(String date) throws ParseException {
		userservice.updateStatus(currentUser,date,1);
		currentUser.setTestdate(date);
		List<dLocation> currentUserLocations = locationService.getUserLocations(currentUser);
		List<dLocation> locations = locationService.getLocationList();
		List<dUser> users = userservice.getUserList();
		SimpleDateFormat testSDF = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long timeInMillis;
		long timeOutMillis;
		long currentTimeInMillis;
		long currentTimeOutMillis;
		Date aDate = null;
		
		int userId;
		String userDate;
		String userIn;
		String userOut;
		String inDate;
		String outDate;
		String userLocation;
		
		int currentId = currentUser.getId();
		int locId;
		String currentLocation;
		String currentDate;
		String currentIn;
		String currentOut;
		String currentInDate;
		String currentOutDate;
		
		//Test date in milliseconds
		
		aDate = testSDF.parse(currentUser.getTestdate());
		long currentMillis = aDate.getTime();
		long past14Millis = currentMillis - (86400000 * 14);

		
		int i = 0, j = 0;
		//2020-11-02
		while(i < currentUserLocations.size()) {
			currentLocation = currentUserLocations.get(i).getOffice();//**
			currentDate = currentUserLocations.get(i).getDate();
			currentIn = currentUserLocations.get(i).getTin();
			currentOut = currentUserLocations.get(i).getTout();
			currentInDate = currentDate + " " + currentIn;
			currentOutDate = currentDate + " " + currentOut;
			aDate = sdf.parse(currentInDate);
			currentTimeInMillis = aDate.getTime();
			aDate = sdf.parse(currentOutDate);
			currentTimeOutMillis = aDate.getTime();
			


			j = 0;
			while(j < locations.size())
			{
				locId = locations.get(j).getId();
				userLocation = locations.get(j).getOffice();
				userId = locations.get(j).getUserid();
				userDate = locations.get(j).getDate();
				userIn = locations.get(j).getTin();
				userOut = locations.get(j).getTout();
				inDate = userDate +" "+userIn;
				outDate = userDate +" "+userOut;
				aDate = sdf.parse(inDate);
				timeInMillis = aDate.getTime();
				aDate = sdf.parse(outDate);
				timeOutMillis = aDate.getTime();
				if(currentId != userId) {
					//System.out.println("Time in: " + timeInMillis + " 14: " + past14Millis + " Curr: " + currentMillis);
					//Positive test will never be before contact... only after due to quarantine
					if((timeInMillis <= currentMillis) && (timeInMillis >= past14Millis)) {
						if(currentLocation.equals(userLocation)) {
							if((currentTimeInMillis <= timeOutMillis) && (currentTimeOutMillis >= timeInMillis)) {
								//In Contact
								alertUser(userId);
								updateLocationStatus(locId);
								System.out.println("In Contact :" + userLocation + " " + userId + " " + userDate + " " + userIn + "-" + userOut +" " +timeInMillis +" | " + currentIn + "-" + currentOut + " | C:" + currentMillis + " 14:" + past14Millis);
							}else if((timeInMillis <= currentTimeOutMillis) && (currentTimeInMillis <= timeOutMillis)) {
								//In Contact
								alertUser(userId);
								updateLocationStatus(locId);
								System.out.println("In Contact :" + userLocation + " " + userId + " " + userDate + " " + userIn + "-" + userOut +" " +timeInMillis +" | " + currentIn + "-" + currentOut + " | C:" + currentMillis + " 14:" + past14Millis);
							}else if((timeInMillis<=currentTimeInMillis) && (timeOutMillis>=currentTimeOutMillis)) {
								//In Contact
								alertUser(userId);
								updateLocationStatus(locId);
								System.out.println("In Contact :" + userLocation + " " + userId + " " + userDate + " " + userIn + "-" + userOut +" " +timeInMillis +" | " + currentIn + "-" + currentOut + " | C:" + currentMillis + " 14:" + past14Millis);
							}else if((timeInMillis>=currentTimeInMillis) && (timeOutMillis<=currentTimeOutMillis)) {
								//In Contact
								alertUser(userId);
								updateLocationStatus(locId);
								System.out.println("In Contact :" + userLocation + " " + userId + " " + userDate + " " + userIn + "-" + userOut +" " +timeInMillis +" | " + currentIn + "-" + currentOut + " | C:" + currentMillis + " 14:" + past14Millis);
							}else if((timeInMillis == currentTimeInMillis)&&(timeOutMillis == currentTimeOutMillis)) {
								//In Contact
								alertUser(userId);
								updateLocationStatus(locId);
								System.out.println("In Contact :" + userLocation + " " + userId + " " + userDate + " " + userIn + "-" + userOut +" " +timeInMillis +" | " + currentIn + "-" + currentOut + " | C:" + currentMillis + " 14:" + past14Millis);
							}
						}
					}
				}
				j++;
			}
			i++;
		}
		
		
		return "stop";
	}
	
	private void updateLocationStatus(int locId)
	{
		locationService.updateLocationStatus(locId, currentUser.getStatus());
	}
	
	private void alertUser(int id) {
		dUser user = null;
		//Change DB
		user = userservice.getEmailById(id);
		if(user.getStatus()!=1) {
			userservice.updateStatus(user,null,2);
		}
		//Send email
		userservice.sendEmail(user);

	}
	
	@RequestMapping(value="/status")
	public String status() {
		return "status";
	}
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model) {
		List<dLocation> locations = locationService.getUserLocations(currentUser);
		//for(int i=0;i<locations.size();i++) {
			//System.out.println(locations.get(i).getOffice());}
		model.addAttribute("locationlist", locations);
		return "home";
		
	}
	
	//@GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(String fname, String lname, String username, String password, String email) {
		System.out.println("fname " + fname);
		System.out.println("lname " + lname);
		System.out.println("username " + username);
		System.out.println("password " + password);
		System.out.println("email " + email);
		
		dUser duser = new dUser();
		duser.setFname(fname);
		duser.setLname(lname);
		duser.setUsername(username);
		duser.setPassword(password);
		duser.setEmail(email);
		String savedId = userservice.join(duser);
		
		return "index";
	}
	
	@RequestMapping(value="/logloc", method = RequestMethod.GET)
	public String logloc(String office, String date, String tin, String tout) {
		
		dLocation location = new dLocation();
		location.setUserid(currentUser.getId());
		location.setOffice(office);
		location.setDate(date);
		location.setTin(tin);
		location.setTout(tout);
		String saveId = locationService.join(location);
		
		return "locations";
	}
	

	
	@RequestMapping(value="/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/redirect")
	public String redirect(String email, String password, String reset) {
		try {
		dUser user = userRepository.findByEmail(email);

		if(user.getPassword().equals(password)) {
			try {
				if(reset.equals("reset")) {
					userservice.updateStatus(user, null, 0);
					
					user.setStatus(0);
					user.setTestdate(null);
					wait();
				}
			}catch(Exception e) {
				
			}
			session = true;
			currentUser = user;
			if(currentUser.getStatus() == 0) {
				return "redirect";
			}else if(currentUser.getStatus()==1){
				return "redirect_stop";
			}else {
				return "inContact";
			}
		}
		else return "index";
		} 
		catch(Exception e) {return "index";}
	}

	@RequestMapping(value="/stop")
	public String stop() {
		return "stop";
	}
	
	@RequestMapping(value="/log_out")
	public String logout() {
		session = false;
		currentUser = null;
		return "index";
	}
	
	/*
	@PostMapping("/create")
	public String create(User user) {
		System.out.println("userid " + user);
		
		return "welcome";
	}*/
		
}
