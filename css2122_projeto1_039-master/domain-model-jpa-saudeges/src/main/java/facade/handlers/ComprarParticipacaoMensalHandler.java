package facade.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ComprarParticipacaoMensalHandler {

	private EntityManagerFactory emf;
	
	public ComprarParticipacaoMensalHandler(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
