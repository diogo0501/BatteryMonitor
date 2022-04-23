package business;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.List;
//IMPORTS NEEDED
import javax.persistence.*;

//ENTITIES AND INHERITANCE NEEDED
@Entity
public class Activity implements Serializable {

	// Named query name constants NEEDED
	
	//public static final String FIND_BY_VAT_NUMBER = "Customer.findByVATNumber";
	//public static final String NUMBER_VAT_NUMBER = "vatNumber";
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_DESIGNATION = "Event.findByDesignation";
	public static final String ACTIVITY_DESIGNATION = "activityDesignation";
	//MISSING PERSISTENCIES
	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	
	private String activityDesignation;
	
	private boolean regularity;
	
	private int nsessions;
	
	private int duration;
	
	private float price;
	
	private int maxParticipants;
	
	public Activity() {
	}
	
	public Activity(String activityDesignation, boolean regularity, int nsessions, int duration, float price, int maxParticipants) {
		//CHECK IF NEEDS MORE ENTITIES
		this.activityDesignation = activityDesignation;
		this.regularity = regularity;
		this.nsessions = nsessions;
		this.duration = duration;
		this.price = price;
		this.maxParticipants = maxParticipants;
		
	}

	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getActivityDesignation() {
		return activityDesignation;
	}

	public void setActivityDesignation(String activityDesignation) {
		this.activityDesignation = activityDesignation;
	}
	
	public boolean getRegularity() {
		return regularity;
	}

	public void setRegularity(boolean regularity) {
		this.regularity = regularity;
	}
	
	public int getNSessions() {
		return nsessions;
	}

	public void getNSessions(int nsessions) {
		this.nsessions = nsessions;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	

	//CHECKERS NEEDED

}