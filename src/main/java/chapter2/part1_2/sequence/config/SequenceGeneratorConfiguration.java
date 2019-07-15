package chapter2.part1_2.sequence.config;

import chapter2.part1_2.sequence.SequenceDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		basePackages = "chapter2.part1_2.sequence",
		includeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { SequenceDao.class }) },
		excludeFilters = {
				@ComponentScan.Filter(
						type = FilterType.ANNOTATION,
						classes = { org.springframework.stereotype.Controller.class }
				)
		}
)
public class SequenceGeneratorConfiguration {
}
