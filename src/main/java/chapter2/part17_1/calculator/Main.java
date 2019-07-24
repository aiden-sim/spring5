package chapter2.part17_1.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

		ArithmeticCalculator arithmeticCalculator =
				(ArithmeticCalculator) context.getBean("arithmeticCalculator");
		arithmeticCalculator.add(1, 2);
		arithmeticCalculator.sub(4, 3);
		arithmeticCalculator.mul(2, 3);
		arithmeticCalculator.div(4, 2);

		UnitCalculator unitCalculator =
				(UnitCalculator) context.getBean("unitCalculator");
		unitCalculator.kilogramToPound(10);
		unitCalculator.kilometerToMile(5);
	}
}
