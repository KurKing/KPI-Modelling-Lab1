package generators;

import java.util.Random;
import java.util.stream.IntStream;

public class NormalDistributionNumberGenerator implements NumberGenerator {

    private final double sigma;
    private final double a;

    private final int valuesInSumAmount;

    private final Random random;

    public NormalDistributionNumberGenerator(double sigma, double a) {

        this.sigma = sigma;
        this.a = a;

        valuesInSumAmount = 12;
        random = new Random();
    }

    @Override
    public Double next() {

        return (randomSum() - valuesInSumAmount / 2) * sigma + a;
    }

    private double randomSum() {

        return IntStream.range(0, valuesInSumAmount)
                .mapToDouble(i -> random.nextDouble())
                .sum();
    }
}
