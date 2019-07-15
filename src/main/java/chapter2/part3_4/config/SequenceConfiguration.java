package chapter2.part3_4.config;

import chapter2.part3_4.DatePrefixGenerator;
import chapter2.part3_4.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {

	@Bean
	public DatePrefixGenerator datePrefixGenerator() {
		DatePrefixGenerator dpg = new DatePrefixGenerator();
		dpg.setPattern("yyyyMMdd");
		return dpg;
	}

	@Bean
	public SequenceGenerator sequenceGenerator() {
		SequenceGenerator sequence = new SequenceGenerator();
		sequence.setInitial(100000);
		sequence.setSuffix("A");
		return sequence;
	}
}
