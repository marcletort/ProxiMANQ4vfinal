package org.formation.dao.impl;

import org.formation.dao.IClientDao;
import org.formation.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Nabila Marc-Antoine Quentin
 * Implémentation de la Dao Client
 */
@Repository
@Transactional
public class ClientDaoimpl extends EntityDaoImpl< Client> implements IClientDao{
	
}
