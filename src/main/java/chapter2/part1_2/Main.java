package chapter2.part1_2;

import chapter2.part1_2.config.SequenceGeneratorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		//ApplicationContext context = new AnnotationConfigApplicationContext("chapter2.part1_2.sequence");
		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
		SequenceDao sequenceDao = context.getBean(SequenceDao.class);

		System.out.println(sequenceDao.getNextValue("IT"));
		System.out.println(sequenceDao.getNextValue("IT"));
	}
}
