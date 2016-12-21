package org.formation.test;

import org.formation.controller.ClientController;
import org.formation.model.Adresse;
import org.formation.model.Client;
import org.formation.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEditionClient {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);

		Client client = clientService.findById(54L);
		client.setNom("truc");
		clientService.merge(client);
	}
}
