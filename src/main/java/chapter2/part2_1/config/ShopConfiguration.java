package chapter2.part2_1.config;

import chapter2.part2_1.Battery;
import chapter2.part2_1.Disc;
import chapter2.part2_1.Product;
import org.springframework.context.annotation.Bean;

public class ShopConfiguration {
	@Bean
	public Product aaa() {
		Battery p1 = new Battery("AAAA", 2.5);
		p1.setRechargeable(true);
		return p1;
	}

	@Bean
	public Product cdrw() {
		Disc p2 = new Disc("CD-RW", 1.5);
		p2.setCapacity(700);
		return p2;
	}
}
