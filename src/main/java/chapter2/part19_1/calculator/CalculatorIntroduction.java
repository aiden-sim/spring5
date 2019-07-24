package chapter2.part19_1.calculator;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {
	@DeclareParents(
			value = "chapter2.part19_1.calculator.*CalculatorImpl",
			defaultImpl = CounterImpl.class
	)
	public Counter counter;

	@After("execution(* chapter2.part19_1.calculator.*Calculator.*(..))" + " && this(counter)")
	public void increaseCount(Counter counter) {
		counter.increase();
	}
}
