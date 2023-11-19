package generators;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public Double next() {

        return random.nextDouble();
    }
}
