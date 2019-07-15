package chapter2.part2_1.sequence;

import chapter2.part2_1.sequence.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

		Product aaa = context.getBean("aaa", Product.class);
		Product cdrw = context.getBean("cdrw", Product.class);

		System.out.println(aaa);
		System.out.println(cdrw);
	}
}
