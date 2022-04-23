package facade.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DefinirNovoHorarioHandler {
	
	private EntityManagerFactory emf;
	
	public DefinirNovoHorarioHandler(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
