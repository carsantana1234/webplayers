package org.webplayerslib.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.webplayerslib.model.EntityPlayer;
import org.webplayerslib.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	static Logger log = LoggerFactory.getLogger(PlayerController.class);
	
	public static void main(String ... arg){
	 String mierda = "super mierda";
	 
	 
		
		byte [] ver = Base64.encodeBase64(mierda.getBytes());
		
		
		System.out.println(  new String(ver));
		
		
		//BASE64Decoder
	}
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newPlayerPage(){
		
		log.info("Page for new player");
		
		ModelAndView mav = new ModelAndView("player-new", "entityPlayer", new EntityPlayer());
		
		log.info("DEVUELVE: " + mav.getViewName());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewPlayer(@ModelAttribute EntityPlayer ep) throws Exception{
		
		log.info( "Creating new player with photo name " + ep.getPhotoName() );
		log.info( "Creating new player with photo name " + ep.getPhotoFile() );
		
		log.info("BYTESSSSSSSSSSSSS: " + ep.getPhotoFile().getBytes());
		
		Blob newBlob = new SerialBlob(ep.getPhotoFile().getBytes());
		//javax.imageio.ImageIO;
		ep.setPhoto(newBlob);
		ep.setState(new Integer(6));
		
		ep.setPhotoBase64(  Base64.encodeBase64( ep.getPhotoFile().getBytes() )  );
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("player-list");
		
		playerService.create(ep);
		
		return mav;
		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView findAll(){
		
		ModelAndView mav = new ModelAndView("player-list");	
		mav.addObject("playerslist", playerService.findAll() );
		
		return mav;
		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	@Transactional
	public ModelAndView deletePlayer(@PathVariable Integer id, final RedirectAttributes redirect){
		
		//ModelAndView mav = new ModelAndView("redirect:/list");
		ModelAndView mav = new ModelAndView("player-list");
		EntityPlayer player = playerService.delete( id );
		//String mensaje ="the plaer with the id " + player.getId() + " was deleted success ";
		
		//redirect.addFlashAttribute("atrimensaje", mensaje);
		
		return mav;
		
	}
	
	
	@RequestMapping("/show/{id}")
	public ModelAndView show(@PathVariable Integer id) throws SQLException,
			IOException {

		Blob blob = null;
		OutputStream os = null;

		if (log.isDebugEnabled()) {
			log.debug("Display image with id " + id);
		}
		ModelAndView mav = null;
		if (id == null || id == 0) {
			return null;
		} else {
			try {

				EntityPlayer ep = playerService.findOne(id);

				mav = new ModelAndView("player-picture");
				if (log.isDebugEnabled()) {
					log.debug("serving data : " + ep.getPhoto());
				}
				os = new ByteArrayOutputStream();

				blob = ep.getPhoto();

				int bloblength = (int) blob.length();

				byte[] blobAsByte = blob.getBytes(1, bloblength);

				os.write(blobAsByte);

				mav.addObject("data", os);

			} catch (NumberFormatException ex) {
				return null;
			} catch (Exception e) {
				log.warn("Unable to fetch picture with id " + id, e);
			} finally {

				blob.free();
				os.flush();
				os.close();
			}
		}
		return mav;
	}

}
