package chapter2.part24_1.shop;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CheckoutListener implements ApplicationListener<CheckoutEvent> {
	@Override public void onApplicationEvent(CheckoutEvent event) {
		// 체크아웃 시간으로 할 일을 여기에 구현
		System.out.println("Checkout event [" + event.getTime() + "]");
	}
}
