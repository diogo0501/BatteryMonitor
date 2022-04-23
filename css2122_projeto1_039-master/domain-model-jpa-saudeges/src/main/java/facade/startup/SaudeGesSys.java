package facade.startup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.AgendarAtividadeOcasionalHandlerService;
import application.ComprarParticipacaoMensalHandlerService;
import application.CriarAtividadeHandlerService;
import application.DefinirNovoHorarioHandlerService;
import facade.exceptions.ApplicationException;
import facade.handlers.AgendarAtividadeOcasionalHandler;
import facade.handlers.ComprarParticipacaoMensalHandler;
import facade.handlers.CriarAtividadeHandler;
import facade.handlers.DefinirNovoHorarioHandler;

public class SaudeGesSys {

	private CriarAtividadeHandlerService activityService;
	private EntityManagerFactory emf;

	public void run() throws ApplicationException {
		// Connects to the database
		try {
			emf = Persistence.createEntityManagerFactory("domain-model-jpa");
			activityService = new CriarAtividadeHandlerService(new CriarAtividadeHandler(emf));
			// exceptions thrown by JPA are not checked
		} catch (Exception e) {
			throw new ApplicationException("Error connecting database", e);
		}
	}

	public void stopRun() {
		// Closes the database connection
		emf.close();
	}

	public CriarAtividadeHandlerService getCriarAtividadeHandlerService() {
		return this.activityService;
	}

	public DefinirNovoHorarioHandlerService getDefinirNovoHorarioHandlerService() {
		return new DefinirNovoHorarioHandlerService(new DefinirNovoHorarioHandler(emf));
	}
	
	public ComprarParticipacaoMensalHandlerService getComprarParticipacaoMensalHandlerService() {
		return new ComprarParticipacaoMensalHandlerService(new ComprarParticipacaoMensalHandler(emf));
	}
	
	public AgendarAtividadeOcasionalHandlerService getAgendarAtividadeOcasionalHandlerService() {
		return new AgendarAtividadeOcasionalHandlerService(new AgendarAtividadeOcasionalHandler(emf));
	}
}
