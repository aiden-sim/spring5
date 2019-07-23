package chapter2.part13_1.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLoggingAspect {
	@Before("execution(* *.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Aspect @Before : " + joinPoint.getTarget());
	}

	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("Aspect @After : " + joinPoint.getTarget());
	}

	@AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("Aspect @AfterReturning : " + joinPoint.getSignature().getName() + " result : " + result);
	}

	@AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
		System.out.println("Aspect @AfterThrowing : " + e);
	}

	@Around("execution(* *.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Aspect @Around begins : " + joinPoint.getTarget());

		try {
			Object result = joinPoint.proceed();
			System.out.println("Aspect @Around ends : " + joinPoint.getTarget());
			return result;
		} catch (IllegalArgumentException e) {
			System.out.println("Aspect @Around excetion : " + joinPoint.getTarget());
			throw e;
		}
	}
}
