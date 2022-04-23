package facade.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AgendarAtividadeOcasionalHandler {
	
	private EntityManagerFactory emf;
	
	public AgendarAtividadeOcasionalHandler(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
