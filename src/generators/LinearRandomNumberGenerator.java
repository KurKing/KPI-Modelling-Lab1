package generators;

import java.util.Random;

public class LinearRandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();
    private Double z;

    private final long a = (long) Math.pow(5, 13);
    private final long c = (long) Math.pow(2, 31);

    public LinearRandomNumberGenerator() {

        this.z = random.nextDouble();
    }

    @Override
    public Double next() {

        z = (a * z) % c;
        return z / c;
    }
}
