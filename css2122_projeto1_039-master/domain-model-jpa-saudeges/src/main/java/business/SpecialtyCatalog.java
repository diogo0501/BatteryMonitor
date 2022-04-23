package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import facade.exceptions.ApplicationException;

public class SpecialtyCatalog {

	private EntityManager em;
	
	
	public SpecialtyCatalog(EntityManager em) {
		this.em = em;
	}
	
	public Specialty getByName(String nome) {
		TypedQuery<Specialty> query = em.createNamedQuery(Specialty.FIND_BY_SPECIALTYNAME, Specialty.class);
		query.setParameter(Specialty.FIND_BY_SPECIALTYNAME, nome);
		return query.getSingleResult();
	}

	public List<Specialty> getAllEspecialidades() {
		TypedQuery<Specialty> query = em.createNamedQuery(Specialty.FIND_ALL, Specialty.class);
		return (List<Specialty>) (query.getResultList().isEmpty() ? 
			new ArrayList<Specialty>() : query.getResultList());
	}

}