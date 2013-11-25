package org.register.service;

import java.util.List;

import org.register.model.EntityPlayer;

public interface PlayerService {
	
	public List<EntityPlayer> findAll();

	public EntityPlayer update(EntityPlayer ep);

	public EntityPlayer delete(int id);
	
}
