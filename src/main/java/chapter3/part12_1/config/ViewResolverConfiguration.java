package chapter3.part12_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String, MediaType> mediatypes = new HashMap<>();
		mediatypes.put("html", MediaType.TEXT_HTML);
		mediatypes.put("pdf", MediaType.valueOf("application/pdf"));
		mediatypes.put("xls", MediaType.valueOf("application/vnd.ms-excel"));
		mediatypes.put("xml", MediaType.APPLICATION_XML);
		mediatypes.put("json", MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediatypes);
	}

	@Bean
	public ViewResolver pdfViewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setOrder(0);
		viewResolver.setBasename("court-views-pdf");
		return viewResolver;
	}

	@Bean
	public ResourceBundleViewResolver viewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setOrder(0);
		viewResolver.setBasename("court-views");
		return viewResolver;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(contentNegotiationManager);

		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(viewResolver());
		resolvers.add(pdfViewResolver());

		viewResolver.setViewResolvers(resolvers);
		return viewResolver;
	}
}
