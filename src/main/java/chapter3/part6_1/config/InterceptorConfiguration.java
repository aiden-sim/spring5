package chapter3.part6_1.config;

import chapter3.part5_1.web.ExtensionInterceptor;
import chapter3.part5_1.web.MeasurementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(measurementInterceptor());
		registry.addInterceptor(summaryReportInterceptor()).addPathPatterns("/reservationSummary*");
	}

	@Bean
	public MeasurementInterceptor measurementInterceptor() {
		return new MeasurementInterceptor();
	}

	@Bean
	public ExtensionInterceptor summaryReportInterceptor() {
		return new ExtensionInterceptor();
	}
}