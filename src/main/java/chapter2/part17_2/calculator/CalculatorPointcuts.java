package chapter2.part17_2.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class CalculatorPointcuts {
    @Pointcut("@within(chapter2.part17_2.calculator.LoggingRequired)")
    public void loggingOperation() {
    }
}
