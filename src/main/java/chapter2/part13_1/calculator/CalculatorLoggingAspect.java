package chapter2.part13_1.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLoggingAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* ArithmeticCalculator.add(..)) || execution(* ArithmeticCalculator.sub(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Aspect @Before : " + joinPoint.getTarget());
		log.info("The method add) begins");
	}
}
