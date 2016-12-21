package org.formation.test;

import java.util.List;

import org.formation.model.Adresse;
import org.formation.model.Client;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;
import org.formation.model.Conseiller;
import org.formation.service.ClientService;
import org.formation.service.ConseillerService;
import org.formation.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPropre {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);
		Adresse adresse1 = new Adresse("4", "rue du Temple", "Vaux sur Seine", "78740");
		Adresse adresse2 = new Adresse("1", "rue de la gare", "Montigny le Bretonneux", "78180");
		Adresse adresse3 = new Adresse("12", "rue stephenson", "Montigny le Bretonneux", "78180");
		Adresse adresse4 = new Adresse("15", "rue de la république", "Lyon", "69001");

		Client client1 = new Client("Martin", "Jean", "JeanMartin@gmail.com", adresse1);
		Client client2 = new Client("Bernard", "Alice", "BernardA@gmail.com", adresse2);
		Client client3 = new Client("Roux", "Lauriane", "RouxLauriane@gmail.com", adresse3);
		Client client4 = new Client("Petit", "Richard", "RichardPetit@gmail.com", adresse4);

		CompteEpargne compteEpargne1 = new CompteEpargne(118, null);
		client1.setCompteEpargne(compteEpargne1);
		CompteEpargne compteEpargne2 = new CompteEpargne(5000, null);
		client2.setCompteEpargne(compteEpargne2);
		CompteCourant compteCourant1 = new CompteCourant(18000, null);
		client1.setCompteCourant(compteCourant1);
		CompteCourant compteCourant2 = new CompteCourant(400, null);
		client2.setCompteCourant(compteCourant2);
		CompteCourant compteCourant3 = new CompteCourant(3000, null);
		client3.setCompteCourant(compteCourant3);

		// clientService.createClient(client);

		// Conseiller conseiller = new Conseiller("Dieu", "Notre père", "dieu",
		// "dieu");
		// conseillerService.persist(conseiller);

		// client.setConseiller(conseiller);
		// System.out.println(client);
		// System.out.println(client.getConseiller().getNom());
		// conseillerService.merge(conseiller);
		clientService.createClient(client1);
		clientService.createClient(client2);
		clientService.createClient(client3);
		clientService.createClient(client4);

	}
}
