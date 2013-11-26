package org.webplayerslib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.webplayerslib.model.EntityPlayer;
import org.webplayerslib.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	static Logger log = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newPlayerPage(){
		
		log.info("Page for new player");
		
		ModelAndView mav = new ModelAndView("player-new", "entityPlayer", new EntityPlayer());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewPlayer(@ModelAttribute EntityPlayer ep) throws Exception{
		
		log.info( "Creating new player with photo name " + ep.getPhotoName() );
		
		ModelAndView mav = new ModelAndView();
		
		playerService.create(ep);
		
		/*
		 (String path=request.getParameter("filename");) and then opens a file input stream with this path (FileInputStream fis=new FileInputStream(path);). 
		 */
		
		return mav;
		
	}
	
}