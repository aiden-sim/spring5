package chapter2.part16_1.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* *.*(..))")
	private void loggingOperation() {
	}

	@Before("loggingOperation()")
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(
			pointcut = "loggingOperation()",
			returning = "result"
	)
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() ends with " + result);
	}

	@AfterThrowing(
			pointcut = "loggingOperation()",
			throwing = "e"
	)
	public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
		log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs())
				+ " in " + joinPoint.getSignature().getName() + "()");
	}

	@Around("loggingOperation()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			log.info("The method " + joinPoint.getSignature().getName()
					+ "() ends with " + result);
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument "
					+ Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
}

