package racingcar.step1.generator;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    private final static int RANGE = 9;

    @Override
    public int generator() {
        Random random = new Random();
        return random.nextInt(RANGE + 1);
    }
}
