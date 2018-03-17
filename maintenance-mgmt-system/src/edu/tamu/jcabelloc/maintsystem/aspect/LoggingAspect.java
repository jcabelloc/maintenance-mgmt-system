package edu.tamu.jcabelloc.maintsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* edu.tamu.jcabelloc.maintsystem.repository.*.save*(..))")
	public void beforeSaving(JoinPoint joinPoint) {
		MethodSignature method = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method Signature: " + method);
		Object[] args = joinPoint.getArgs();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//String json = ow.writeValueAsString(object);
		for (Object arg : args) {
			System.out.println("Arguments STRING : " + arg.toString());
			try {
				System.out.println("Arguments JSON : " + ow.writeValueAsString(arg));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
