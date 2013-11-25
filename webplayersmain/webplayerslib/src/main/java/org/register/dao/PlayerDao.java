package org.register.dao;

import java.util.List;

import org.register.model.EntityPlayer;

/**
 * Interface for DAO operations
 * @author Socrates
 *
 */
public interface PlayerDao {

	public List<EntityPlayer> findAll();

	public EntityPlayer update(EntityPlayer ep);

	public EntityPlayer delete(int id);

}
