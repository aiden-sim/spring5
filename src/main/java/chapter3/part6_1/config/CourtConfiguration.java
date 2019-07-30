package chapter3.part6_1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("chapter3.part6_1")
@EnableWebMvc
public class CourtConfiguration {
}