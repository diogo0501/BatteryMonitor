package business;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.ArrayList;

import facade.exceptions.ApplicationException;


public class ScheduleCatalog {

	/**
	 * Entity manager factory for accessing the persistence service 
	 */
	private EntityManager em;
	
	public ScheduleCatalog(EntityManager em) {
		this.em = em;
	}
	
	public Schedule getScheduleID(long id) {
		TypedQuery<Schedule> tq = em.createNamedQuery("Schedule.findAll", Schedule.class);
		tq.setParameter(Schedule.STRID, id);
		return tq.getSingleResult();
	}
}
	