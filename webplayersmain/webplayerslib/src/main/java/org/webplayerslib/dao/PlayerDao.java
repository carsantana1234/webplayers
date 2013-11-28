package org.webplayerslib.dao;

import java.util.List;

import org.webplayerslib.model.EntityPlayer;

/**
 * Interface for DAO operations
 * @author Socrates
 *
 */
public interface PlayerDao {
	
	public EntityPlayer create(EntityPlayer ep); 

	public List<EntityPlayer> findAll();

	public EntityPlayer update(EntityPlayer ep);

	public EntityPlayer delete(int id);
	
	public EntityPlayer findOne(Integer id);

}
