package org.register.dao;

import java.util.List;

import org.register.model.EntityPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webplayerslib.repository.PlayerRepository;

/**
 * Implementation of DataAccessObject Interface 
 * @author Socrates
 *
 */
@Repository
public class PlayerDaoImpl implements PlayerDao{
	
	@Autowired
	PlayerRepository playerRepository;


	public EntityPlayer create(EntityPlayer ep) {
		return playerRepository.save(ep);
	}
	
	public List<EntityPlayer> findAll() {
		return playerRepository.findAll();
	}

	public EntityPlayer update(EntityPlayer ep) {
		EntityPlayer entityPlayer = playerRepository.findOne(ep.getId());
		entityPlayer.setAge(ep.getAge());
		entityPlayer.setName(ep.getName());
		entityPlayer.setSurName(ep.getSurName());
		entityPlayer.setPhotoName(ep.getPhotoName());
		entityPlayer.setPhoto(ep.getPhoto());
		entityPlayer.setState(ep.getState());
		
		return entityPlayer;
	}

	public EntityPlayer delete(int id) {
		EntityPlayer ep = playerRepository.findOne(id);
		playerRepository.delete(ep);
		return ep;
	}


}
