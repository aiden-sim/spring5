package chapter4.part9.web.config;

import chapter4.part9.feeds.AtomFeedView;
import chapter4.part9.feeds.RSSFeedView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "chapter4.part9")
public class CourtRestConfiguration {
	@Bean
	public AtomFeedView atomfeedtemplate() {
		return new AtomFeedView();
	}

	@Bean
	public RSSFeedView rssfeedtemplate() {
		return new RSSFeedView();
	}

	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}
}
