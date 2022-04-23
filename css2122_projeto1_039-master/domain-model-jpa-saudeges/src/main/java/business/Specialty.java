package business;

import java.io.Serializable;
//IMPORTS NEEDED
import javax.persistence.*;

//ENTITIES AND INHERITANCE NEEDED
@Entity
@NamedQueries({
	@NamedQuery(name = Specialty.FIND_BY_SPECIALTYNAME, query = "SELECT s FROM Specialty s WHERE s.specialtyName = :"
			+ "SPECIALTYNAME"),
	@NamedQuery(name = Specialty.FIND_ALL, query = "SELECT s FROM Specialty s ORDER BY s.specialtyName ASC")

})
public class Specialty implements Serializable {

	// Named query name constants NEEDED
	
    	public static final String FIND_BY_SPECIALTYNAME = "Specialty.findByName";
	public static final String FIND_ALL = "Specialty.findALL";

	private static final long serialVersionUID = 1L;

	//MISSING PERSISTENCIES
	@Id
	private long id;
	
	private String specialtyName;
	
	private int nRegist;
	
	private String certification; //CHECK IF CORRECT
	
	
	//CHECK IF NEEDS MORE ENTITIES
	
	//private String designation;
	
	private int minDuration;
	
	public Specialty() {
	}
	
	public Specialty(String specialtyName, int nRegist, String certification, String designation, int minDuration) {
		//CERTIFICATION CLASS NEEDED
		
		//CHECK IF NEEDS MORE ENTITIES
		this.specialtyName = specialtyName;
		this.nRegist = nRegist;
		this.certification = certification; //CHECK IF CORRECT
		//this.designation = designation;
		this.minDuration = minDuration;
	}

	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	
	public int getNRegist() {
		return nRegist;
	}

	public void setNRegist(int nRegist) {
		this.nRegist = nRegist;
	}
	
	public String getCertification() {
		return certification; //CHECK IF CORRECT
	}

	public void setCertification(String certification) {
		this.certification = certification; //CHECK IF CORRECT
	}
	
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
	
	public int getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(int minDuration) {
		this.minDuration = minDuration;
	}
	

	//CHECKERS NEEDED

}