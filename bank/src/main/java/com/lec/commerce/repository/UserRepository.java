package com.lec.commerce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.dUser;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void save(dUser user) {
		em.persist(user);
	}
	
	public dUser findOne(String id) {
		
		return em.find(dUser.class, id);
	}
	
	
	public List<dUser> findall(){
		
		List<dUser> results = em.createQuery("select m from dUser m", dUser.class)
		.getResultList();
		
		return results;
	}
	
	public List<dUser> findByName(String username){
		
		return em.createQuery("select n from dUser n where n.username = :username", dUser.class)
		.setParameter("username", username)
		.getResultList();
		
	}
	
	public dUser findById(int id) {
		return em.createQuery("select n from dUser n where n.id = :id", dUser.class).setParameter("id",id).getSingleResult();
	}
	
	public dUser findByUsername(String username) {
		return em.createQuery("select n from dUser n where n.username = :username", dUser.class).setParameter("username",username).getSingleResult();
	}
	
	public dUser findByEmail(String email) {
		return em.createQuery("select n from dUser n where n.email = :email", dUser.class).setParameter("email",email).getSingleResult();
	}

    public void updateStatus(@Param("status") int status, String date,  @Param("email") String email) {    	
    	em.createQuery("update dUser u Set u.status = :status, u.testdate = :date where u.email =:email").setParameter("status", status).setParameter("date", date).setParameter("email", email).executeUpdate();
    }
//    @Modifying
//    @Query("UPDATE dUser u SET u.testdate = :date WHERE c.email = :email")
//    public void updateTestDate(@Param("date") String date, @Param("email") String email) {
//    
//    }
	

	
	
}
