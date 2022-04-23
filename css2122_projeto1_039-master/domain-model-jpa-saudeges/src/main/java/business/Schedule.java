package business;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//IMPORTS NEEDED
import javax.persistence.*;

//ENTITIES AND INHERITANCE NEEDED
@Entity
@NamedQueries({ 
	@NamedQuery(name = Schedule.FIND_ALL, query = "SELECT a FROM Schedule a WHERE a.id = :" + Schedule.STRID),
})
public class Schedule implements Serializable {

	// Named query name constants NEEDED

	private static final long serialVersionUID = 1L;
	
	protected static final String FIND_ALL= "Schedule.findAll";

	//public static final String FIND_BY_VAT_NUMBER = "Customer.findByVATNumber";
	//public static final String NUMBER_VAT_NUMBER = "vatNumber";
	public static final String STRID = "STRID";

	//MISSING PERSISTENCIES
	@Id @GeneratedValue(strategy = AUTO)
	private long id;
	@Column
	private Date availabilityStartDate;
	@Column
	private int availabilityMonths;
	@Column
	private float monthlyFee;
	@Column
	private Date startingDate;
	@Column		
	private int nrMonths;
	
	public Schedule() {
	}
	
	public Schedule(Date availabilityStartDate, int availabilityMonths, float monthlyFee, Date startingDate, int nrMonths) {
		//CHECK IF NEEDS MORE ENTITIES
		this.availabilityStartDate = availabilityStartDate;
		this.availabilityMonths = availabilityMonths;
		this.monthlyFee = monthlyFee;
		this.startingDate = startingDate;
		this.nrMonths = nrMonths;
	}

	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getAvailabilityStartDate() {
		return availabilityStartDate;
	}

	public void setAvailabilityStartDate(Date availabilityStartDate) {
		this.availabilityStartDate = availabilityStartDate;
	}
	
	public int getAvailabilityMonths() {
		return availabilityMonths;
	}

	public void setAvailabilityMonths(int availabilityMonths) {
		this.availabilityMonths = availabilityMonths;
	}
	
	public float getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(float monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	public int getNrMonths() {
		return nrMonths;
	}

	public void setNrMonths(int nrMonths) {
		this.nrMonths = nrMonths;
	}
	

	//CHECKERS NEEDED

}