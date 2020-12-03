package com.lec.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.Mail;
import com.lec.commerce.domain.dLocation;
import com.lec.commerce.domain.dUser;
import com.lec.commerce.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired MailService mailService;
	
	public String join(dUser duser) {
		
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
	
	public boolean authenticateUser(String username, String password) {
		dUser user = userRepository.findByUsername(username);
		if(user.getPassword().equals(password))
			return true;
		else return false;
	}
	
	public dUser getEmailById(int id) {
		dUser user = null;
		user = userRepository.findById(id);
		return user;
	}
	
	public List<dUser> getUserList() {
		
		List<dUser> users = userRepository.findall();
		
		return users;
	}
	public void updateStatus(dUser user, String date, int status) {
		
		userRepository.updateStatus(status, date, user.getEmail());
		
		//sendEmail();
		
		
		//userRepository.updateTestDate(date,user.getEmail());
	}
	
	public void sendEmail(dUser user) {
		
		
		Mail mail = new Mail();
		mail.setMailFrom("se3910bank@gmail.com");//*******Your email
		mail.setMailTo(user.getEmail());
		mail.setMailSubject("IMPORTANT"); 
		mail.setMailContent("Take test immediately.");
		mailService.sendEmail(mail);
		
	}
	
	
	
	
}
