package com.ubp.volart.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

	@Before("execution(public * com.ubp.volart.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
	}

}
