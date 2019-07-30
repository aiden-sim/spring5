package chapter3.part6_1.config;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer, ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	@Override public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	// XML 방식
	@Bean
	public ViewResolver viewResolver() {
		XmlViewResolver viewResolver = new XmlViewResolver();
		// resourceLoader를 하기 위해서는 ResourceLoaderAware 가 필요
		viewResolver.setLocation(resourceLoader.getResource("/WEB-INF/court-views.xml"));
		viewResolver.setOrder(0);
		return viewResolver;
	}

	// Resource 방식
/*	@Bean
	public ResourceBundleViewResolver viewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setOrder(0);
		viewResolver.setBasename("court-views");
		return viewResolver;
	}*/

	// 기본 방식
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
