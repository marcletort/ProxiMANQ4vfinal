package org.formation.Main;

import org.formation.config.BankConfig;
import org.formation.dao.IClientDao;
import org.formation.dao.impl.ClientDaoimpl;
import org.formation.model.Adresse;
import org.formation.model.Client;
import org.formation.model.Conseiller;
import org.formation.service.ClientService;
import org.formation.service.ConseillerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestBDD {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
		
		ConseillerService conseillerService = context.getBean("conseillerService", ConseillerService.class);
		
		ClientService clientService = context.getBean("clientService", ClientService.class);
		
		Conseiller conseiller = new Conseiller("Dieu", "Notre père", "dieu", "dieu");
		
		Client client = new Client("Christ", "Jesus", "JesusChrist@paradis.amen",
				new Adresse("7", "rue du paradis", "Ciel", "77777"));
		
		conseillerService.persist(conseiller);
		clientService.merge(client);
		clientService.createClient(client);
		
//		conseiller.getListClients().add(client);
//		client.setConseiller(conseiller);
//		
		
		
//		ClientService clientService = new ClientService();
		

	}

}
