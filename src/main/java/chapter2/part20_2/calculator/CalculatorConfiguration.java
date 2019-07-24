package chapter2.part20_2.calculator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@ComponentScan
@EnableLoadTimeWeaving // -javaagent:C:\spring\lib\spring-instrument-5.0.0.RELEASE.jar 설정 안하면 에러남
public class CalculatorConfiguration {
}
