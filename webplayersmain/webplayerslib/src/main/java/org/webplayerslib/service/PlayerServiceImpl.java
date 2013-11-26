package org.webplayerslib.service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
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

	public EntityPlayer create(EntityPlayer ep) throws Exception{
		
		
		
		FileInputStream f_in = new FileInputStream(ep.getName());
		//FileInputStream f_in = new FileInputStream("c:\\myobject.data");
        ObjectInputStream obj_in = new ObjectInputStream (f_in);
        Object obj = obj_in.readObject();
        Blob myObject = (Blob)obj;
             
        //LargeTable lt = new LargeTable();
        //EntityPlayer epo = new EntityPlayer();
        ep.setPhoto(myObject);
       // lt.setTableId(1L);
        //lt.setBlob(myObject);
		
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


}
