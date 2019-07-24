package chapter2.part17_1.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class CalculatorPointcuts {
    @Pointcut("@annotation(chapter2.part17_1.calculator.LoggingRequired)")
    public void loggingOperation() {
    }
}
