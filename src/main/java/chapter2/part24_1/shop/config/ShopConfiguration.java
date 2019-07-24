package chapter2.part24_1.shop.config;

import chapter2.part24_1.shop.Battery;
import chapter2.part24_1.shop.Cashier;
import chapter2.part24_1.shop.Disc;
import chapter2.part24_1.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("chapter2.part24_1.shop")
public class ShopConfiguration {

	@Bean
	public Product aaa() {
		Battery p1 = new Battery();
		p1.setName("AAA");
		p1.setPrice(2.5);
		p1.setRechargeable(true);
		return p1;
	}

	@Bean
	public Product cdrw() {
		Disc p2 = new Disc("CD-RW", 1.5);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public Product dvdrw() {
		Disc p2 = new Disc("DVD-RW", 3.0);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public Cashier cashier() {
		return new Cashier();
	}
}
