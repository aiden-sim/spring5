package chapter2.part15_1.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class CalculatorLoggingAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* *.*(..))")
	public void logJoinPoint(JoinPoint joinPoint) {
		log.info("The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	}
}

