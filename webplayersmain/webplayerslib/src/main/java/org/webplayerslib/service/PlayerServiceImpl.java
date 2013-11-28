package org.webplayerslib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webplayerslib.dao.PlayerDao;
import org.webplayerslib.model.EntityPlayer;

/**
 * Layer for use from top layers
 * @author Socrates
 *
 */
@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerDao playerDao;

	@Transactional
	public EntityPlayer create(EntityPlayer ep) throws Exception{
		return playerDao.create(ep);
	}	
	
	@Transactional(readOnly=true)
	public List<EntityPlayer> findAll() {
		return playerDao.findAll();
	}

	public EntityPlayer update(EntityPlayer ep) {
		return playerDao.update(ep);
	}

	public EntityPlayer delete(int id) {
		return playerDao.delete(id);
	}

	public EntityPlayer findOne(Integer id) {
		return playerDao.findOne(id);
		
	}


}
