package org.formation.dao.impl;

import javax.persistence.Entity;

import org.formation.dao.IVirementDao;
import org.formation.model.Virement;
import org.springframework.stereotype.Repository;

/**
 * @author Nabila Marc-Antoine Quentin Implémentation de la Dao Virement
 */
@Repository
@Entity
public class VirementDaoImpl extends EntityDaoImpl<Virement> implements IVirementDao {

}
