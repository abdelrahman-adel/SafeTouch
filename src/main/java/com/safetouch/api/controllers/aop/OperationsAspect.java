package com.safetouch.api.controllers.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class OperationsAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationsAspect.class);

	@Pointcut("execution(* com.safetouch.api.controllers..*.*(..))")
	public void operationPointCut() {
	}

	@Around("operationPointCut()")
	public Object operationsPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		LOGGER.debug("Operation {} started..", joinPoint.toShortString().replaceFirst("execution", ""));
		Object returnedValue = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - start;
		LOGGER.debug("Operation {} ended .. time taken: {}", joinPoint.toShortString().replaceFirst("execution", ""), timeTaken);
		return returnedValue;
	}
}
