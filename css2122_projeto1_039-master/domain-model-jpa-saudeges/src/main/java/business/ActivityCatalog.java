package business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class ActivityCatalog {

	private EntityManager em;

	public ActivityCatalog(EntityManager em) {
		this.em = em;
	}
	
	public Activity getActivity (String activityDesignation) { 
		TypedQuery<Activity> query = em.createNamedQuery (Activity.FIND_BY_DESIGNATION, Activity.class);
		query.setParameter(Activity.ACTIVITY_DESIGNATION, activityDesignation);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	
	
}
