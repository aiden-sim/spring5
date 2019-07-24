package chapter2.part18_1.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {
	@DeclareParents(
			value = "chapter2.part18_1.calculator.ArithmeticCalculatorImpl",
			defaultImpl = MaxCalculatorImpl.class
	)
	public MaxCalculator maxCalculator;

	@DeclareParents(
			value = "chapter2.part18_1.calculator.ArithmeticCalculatorImpl",
			defaultImpl = MinCalculatorImpl.class
	)
	public MinCalculator minCalculator;
}
