package chapter2.part24_1.shop;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.io.IOException;
import java.util.Date;

public class Cashier implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;

	@Override public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void checkout(ShoppingCart cart) throws IOException {
		CheckoutEvent event = new CheckoutEvent(cart, new Date());
		applicationEventPublisher.publishEvent(event);
	}
}
