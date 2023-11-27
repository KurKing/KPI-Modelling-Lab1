package generators;

import java.util.Random;

public class ExponentialRandomNumberGenerator implements NumberGenerator {

    private final double lambda;
    private final Random random = new Random();

    public ExponentialRandomNumberGenerator(double lambda) {

        this.lambda = lambda;
    }

    @Override
    public Double next() {

        return -1 * Math.log(random.nextDouble()) / lambda;
    }
}
