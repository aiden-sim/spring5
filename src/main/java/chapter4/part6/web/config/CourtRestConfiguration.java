package chapter4.part6.web.config;

import chapter4.part6.domain.Member;
import chapter4.part6.domain.Members;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "chapter4.part6")
public class CourtRestConfiguration {

	@Bean
	public View jsonmembertemplate() {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

	@Bean
	public View xmlmembertemplate() {
		return new MarshallingView(jaxb2Marshaller());
	}

	@Bean
	public Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Members.class, Member.class);
		marshaller.setMarshallerProperties(Collections.singletonMap(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE));
		return marshaller;
	}

	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}
}
