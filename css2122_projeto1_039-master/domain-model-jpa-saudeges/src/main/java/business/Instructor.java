package business;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
//IMPORTS NEEDED
import javax.persistence.*;

//ENTITIES AND INHERITANCE NEEDED
@Entity
public class Instructor implements Serializable {

	// Named query name constants NEEDED
	
	//public static final String FIND_BY_VAT_NUMBER = "Customer.findByVATNumber";
	//public static final String NUMBER_VAT_NUMBER = "vatNumber";


	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_ID = "Instructor.findByNumber";
	public static final String INSTRUCTOR_NUMBER = "instructorNumber";

	//MISSING PERSISTENCIES
	@Id @GeneratedValue(strategy = AUTO)
	private long id;
	@Column
	private int nRegists;
	@Column
	private String name;
	
	//CERTIFICATION CLASS NEEDED
	
	//CHECK IF NEEDS MORE ENTITIES
	@Column
	private int instructorNumber;
	@Column
	private int attributedMonths;
	
	public Instructor() {
	}
	
	public Instructor(int nRegists, String name, int instructorNumber, int attributedMonths) {
		//CERTIFICATION CLASS NEEDED
		
		//CHECK IF NEEDS MORE ENTITIES
		this.nRegists = nRegists;
		this.name = name;
		this.instructorNumber = instructorNumber;
		this.attributedMonths = attributedMonths;
		
	}

	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getNRegists() {
		return nRegists;
	}

	public void setNRegists(int nRegists) {
		this.nRegists = nRegists;
	}
	
	public String getInstructorName() {
		return name;
	}

	public void setInstructorName(String name) {
		this.name = name;
	}
	
	public int getInstructorNumber() {
		return instructorNumber;
	}

	public void setInstructorNumber(int instructorNumber) {
		this.instructorNumber = instructorNumber;
	}
	
	public int getAttributedMonths() {
		return attributedMonths;
	}

	public void setAttributedMonths(int attributedMonths) {
		this.attributedMonths = attributedMonths;
	}

	//CHECKERS NEEDED

}