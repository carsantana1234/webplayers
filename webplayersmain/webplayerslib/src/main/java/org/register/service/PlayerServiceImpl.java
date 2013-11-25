package org.register.service;

import java.util.List;

import org.register.dao.PlayerDao;
import org.register.model.EntityPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Layer for use from top layers
 * @author Socrates
 *
 */
@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerDao playerDao;
	
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

}
