package chapter2.part15_1.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorValidationAspect implements Ordered {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* *.*(double, double))")
	public void validateBefore(JoinPoint joinPoint) {
		log.info("The validate {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		for (Object arg : joinPoint.getArgs()) {
			validate((Double) arg);
		}
	}

	private void validate(double a) {
		if (a < 0) {
			throw new IllegalArgumentException("Positive numbers only");
		}
	}

	@Override public int getOrder() {
		return 2;
	}
}
