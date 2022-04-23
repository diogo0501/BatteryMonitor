package business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PaymentDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public PaymentDetails() {
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	
	private String entity;
	
	private String reference;
	
	private float value;
	
	//GETTERS and SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}
 