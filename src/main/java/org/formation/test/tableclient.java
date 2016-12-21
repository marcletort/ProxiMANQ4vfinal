package org.formation.test;

import org.formation.model.Adresse;
import org.formation.model.Client;
import org.formation.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class tableclient {

	public static void main(String[] args) throws Exception {
		Client client = new Client("aaa", "aa", "email", new Adresse("1", "1", "1", "1"));

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		clientService.createClient(client);

	}

}
