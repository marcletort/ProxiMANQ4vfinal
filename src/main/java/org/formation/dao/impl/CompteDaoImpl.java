package org.formation.dao.impl;

import org.formation.dao.ICompteDao;
import org.formation.model.Compte;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nabila Marc-Antoine Quentin Implémentation de la Dao Compte
 */
@Repository
@Transactional
public class CompteDaoImpl extends EntityDaoImpl<Compte> implements ICompteDao {

}
