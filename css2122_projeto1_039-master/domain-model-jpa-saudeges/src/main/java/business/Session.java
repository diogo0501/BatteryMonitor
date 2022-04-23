package business;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
//IMPORTS NEEDED
import javax.persistence.*;

//ENTITIES AND INHERITANCE NEEDED
@Entity
public class Session implements Serializable {

	// Named query name constants NEEDED
	
	//public static final String FIND_BY_VAT_NUMBER = "Customer.findByVATNumber";
	//public static final String NUMBER_VAT_NUMBER = "vatNumber";


	private static final long serialVersionUID = 1L;
	//JOINCOLUMNS MISSING
	@Id @GeneratedValue(strategy = AUTO)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startingDateTime;
	@ManyToOne
	private Activity activity;
	@ManyToOne
	private Instructor instructor;
	
	//CHECK IF NEEDS MORE ENTITIES
	
	public Session() {
	}
	
	public Session(Date startingDateTime, Activity activity, Instructor instructor) {
		//CHECK IF NEEDS MORE ENTITIES
		this.startingDateTime = startingDateTime;
		this.activity = activity;
		this.instructor = instructor;
	}

	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getStartingDateTime() {
		return startingDateTime;
	}

	public void setStartingDateTime(Date startingDateTime) {
		this.startingDateTime = startingDateTime;
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	

	//CHECKERS NEEDED

}