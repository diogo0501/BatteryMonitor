package business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class InstructorCatalog {

	private EntityManager em;

	public InstructorCatalog(EntityManager em) {
		this.em = em;
	}
	
	public Instructor getInstructor (long instructorId) {
		TypedQuery<Instructor> query = em.createNamedQuery(Instructor.FIND_BY_ID, Instructor.class);
		query.setParameter(Instructor.INSTRUCTOR_NUMBER, instructorId);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
