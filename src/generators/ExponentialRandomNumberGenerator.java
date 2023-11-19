package generators;

public class ExponentialRandomNumberGenerator extends RandomNumberGenerator {

    private final double lambda;

    public ExponentialRandomNumberGenerator(double lambda) {

        this.lambda = lambda;
    }

    @Override
    public Double next() {

        return -Math.log(super.next()) / lambda;
    }
}
