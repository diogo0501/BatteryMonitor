package facade.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CriarAtividadeHandler {

	private EntityManagerFactory emf;
	
	public CriarAtividadeHandler(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
