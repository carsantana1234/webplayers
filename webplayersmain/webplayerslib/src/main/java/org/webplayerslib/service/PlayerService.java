package org.webplayerslib.service;

import java.util.List;

import org.webplayerslib.model.EntityPlayer;

public interface PlayerService {
	
	public EntityPlayer create(EntityPlayer ep) throws Exception; 
	
	public List<EntityPlayer> findAll();

	public EntityPlayer update(EntityPlayer ep);

	public EntityPlayer delete(int id);
	
}
