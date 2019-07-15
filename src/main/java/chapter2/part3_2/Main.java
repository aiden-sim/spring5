package chapter2.part3_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("chapter2.part3_2");

		SequenceService sequenceService =
				context.getBean(SequenceService.class);

		System.out.println(sequenceService.generate("IT"));
		System.out.println(sequenceService.generate("IT"));
	}
}
