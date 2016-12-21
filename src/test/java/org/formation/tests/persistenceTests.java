package org.formation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formation.dao.IClientDao;
import org.formation.dao.ICompteDao;
import org.formation.dao.IConseillerDao;
import org.formation.model.Client;
import org.formation.model.Conseiller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class persistenceTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	IClientDao clientDao;

	@Autowired
	IConseillerDao conseillerDao;

	@Autowired
	ICompteDao compteDao;

	// @Test
	// @Transactional
	// public void testDaoImpl() throws Exception {
	// Item item = new Item();
	// itemDao.persist(item);
	// assertEquals(1, itemDao.count());
	// }

	// @Test
	// @Transactional
	// public void testDaoServices() throws Exception{
	// Order order = new Order();
	// order.getItems().add(new Item());
	// orderDao.persist(order);
	// assertEquals(1, orderDao.count());
	// }

	@Test
	@Transactional

	public void testSaveConseillerWithClient() throws Exception {
		Conseiller c = new Conseiller();
		c.getListClients().add(new Client());
		entityManager.persist(c);
		entityManager.flush();
		assertNotNull(c.getId());

	}
	//
	// @Test
	// @Transactional
	// public void testSaveAndGet() throws Exception {
	// Order order = new Order();
	// order.getItems().add(new Item());
	// entityManager.persist(order);
	// entityManager.flush();
	// Otherwise the query returns the existing order (and we didn't set the
	// parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager.find(Order.class, order.getId());
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }

	// @Test
	// @Transactional
	// public void testSaveAndFind() throws Exception {
	// Order order = new Order();
	// Item item = new Item();
	// item.setProduct("foo");
	// order.getItems().add(item);
	// entityManager.persist(order);
	// entityManager.flush();
	// // Otherwise the query returns the existing order (and we didn't set the
	// // parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager
	// .createQuery(
	// "select o from Order o join o.items i where i.product=:product")
	// .setParameter("product", "foo").getSingleResult();
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }

}
