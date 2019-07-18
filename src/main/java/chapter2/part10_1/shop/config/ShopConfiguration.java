package chapter2.part10_1.shop.config;

import chapter2.part10_1.shop.Product;
import chapter2.part10_1.shop.ProductCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("chapter2.part10_1.shop")
public class ShopConfiguration {
	@Bean
	public Product aaa() {
		return ProductCreator.createProduct("aaa");
	}

	@Bean
	public Product cdrw() {
		return ProductCreator.createProduct("cdrw");
	}

	@Bean
	public Product dvdrw() {
		return ProductCreator.createProduct("dvdrw");
	}
}
