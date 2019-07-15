package chapter2.part4_2;

import java.util.Random;

@NumberPrefixAnnotation
public class NumberPrefixGenerator implements PrefixGenerator {

    @Override
    public String getPrefix() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return String.format("%03d", randomInt);
    }
}
