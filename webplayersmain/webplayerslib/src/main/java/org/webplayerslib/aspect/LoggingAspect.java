package org.webplayerslib.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	/*
	@After("execution(* org.webplayerslib.controller.PlayerController.newPlayerPage(..))")
	public void logAspect(JoinPoint joinPoint){
		
		log.info("logAspect is running ");
		log.info("Method name " + joinPoint.getSignature().getName() );
		log.info("===================================================");
		
	}
	*/
	/*
	@AfterReturning(pointcut = "execution(* org.webplayerslib.controller.PlayerController.newPlayerPage(..))", returning= "result")
	public void logAspect(JoinPoint joinPoint, Object result){
		
		log.info("logAspect is running ");
		log.info("Method name " + joinPoint.getSignature().getName() );
		log.info("Resultado " + result );
		log.info("===================================================");
		
	}
	*/
	
	/*La interace debe tener un throws Exception; */
	/*
   @AfterThrowing(pointcut = "execution(* org.webplayerslib.controller.PlayerController.newPlayerPage(..))",throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		 
	   		log.info("logAfterThrowing() is running!");
	   		log.info("hijacked : " + joinPoint.getSignature().getName());
	   		log.info("Exception : " + error);
	   		log.info("******");
		 
		    }*/
	
	@Around("execution(* org.webplayerslib.controller.PlayerController.newPlayerPage(..))")
	public void logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		
		log.info("logAspect is running ");
		log.info("Method name " + joinPoint.getSignature().getName() );
		log.info("Argumentos " + Arrays.toString(joinPoint.getArgs()) );
		log.info("Around antes del running");
		joinPoint.proceed();
		log.info("Around despues del running");
		log.info("===================================================");
		
	}

}
