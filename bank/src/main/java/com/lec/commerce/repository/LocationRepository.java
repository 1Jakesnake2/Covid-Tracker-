package com.lec.commerce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lec.commerce.domain.dLocation;
import com.lec.commerce.domain.dUser;

@Repository
public class LocationRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void save(dLocation location) {
		em.persist(location);
	}
	
	public List<dLocation> findAll() {
		List<dLocation> results = em.createQuery("select m from dLocation m", dLocation.class)
		.getResultList();
		
		return results;
	}
	
	public List<dLocation> findUserList(dUser user) {
		int userid = user.getId();
		List<dLocation> results = em.createQuery("select m from dLocation m where m.userid = :userid", dLocation.class).setParameter("userid",userid).getResultList();
		return results;
	}
	
    public void updateLocationStatus(@Param("status") int status, @Param("id") int id) {    	
    	em.createQuery("update dLocation l Set l.status = :status where l.id =:id").setParameter("status", status).setParameter("id", id).executeUpdate();
    }
	
/*	public dUser findOne(String id) {
		
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
*/	
	
}
