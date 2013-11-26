package org.webplayerslib.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* org.webplayerslib.controller.PlayerController.newPlayerPage(..))")
	public void logAspect(JoinPoint joinPoint){
		
		log.info("logAspect is running ");
		log.info("Method name " + joinPoint.getSignature().getName() );
		log.info("===================================================");
		
	}

}
