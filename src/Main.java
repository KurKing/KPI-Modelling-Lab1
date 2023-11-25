import generators.ExponentialRandomNumberGenerator;
import generators.NormalDistributionNumberGenerator;
import generators.NumberGenerator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GraphDrawer drawer = new GraphDrawer(false);

        NumberGenerator generator = createGenerator();
        Distribution distribution = new Distribution();

        List<Double> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {

            var num = generator.next();

            randomNumbers.add(num);
            distribution.add(num);
        }

        drawer.addChart("Default distribution",
                distribution.getKeys(),
                distribution.getValues());
        drawer.displayChart();
    }

    private static NumberGenerator createGenerator() {

//        return new ExponentialRandomNumberGenerator(1.0);
        return new NormalDistributionNumberGenerator(2, 10);
    }
}