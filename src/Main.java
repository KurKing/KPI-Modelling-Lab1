import chisquare.ChiSquaredCounter;
import chisquare.ExponentialChiSquaredCounter;
import chisquare.NormalChiSquaredCounter;
import distribution.Distribution;
import generators.ExponentialRandomNumberGenerator;
import generators.NormalDistributionNumberGenerator;
import generators.NumberGenerator;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        GraphDrawer drawer = new GraphDrawer(false);

        NumberGenerator generator = createGenerator();

        Distribution distribution = new Distribution(10);

        for (int i = 0; i < 10000; i++) {

            distribution.add(generator.next());
        }

        drawer.addChart("distribution.Distribution",
                distribution.getKeys(),
                distribution.getValues());
        drawer.displayChart();

        System.out.println("Mean = " + distribution.getStats().getMean() + ";");
        System.out.println("Variance = " + distribution.getStats().getVariance() + ";");

        ChiSquaredCounter chiSquaredCounter = createChiSquaredCounter(distribution.getStats().getBins(),
                distribution.getStats().getMin(),
                distribution.getStats().getMax());
        double calculatedChiSquared = chiSquaredCounter.calculateChiSquared();

        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumber = df.format(calculatedChiSquared);

        System.out.println("Chi squared = " + roundedNumber + ";");
    }

    private static NumberGenerator createGenerator() {

//        return new ExponentialRandomNumberGenerator(0.2);
        return new NormalDistributionNumberGenerator(0.5, 10);
//        return new LinearRandomNumberGenerator();
    }

    private static ChiSquaredCounter createChiSquaredCounter(Map<Integer, Integer> frequencyMap, double min, double max) {

//        return new ExponentialChiSquaredCounter(frequencyMap,
//               30,
//               0.2,
//                10000,
//                min,
//                max);

        return new NormalChiSquaredCounter(frequencyMap,
                min,
                max,
                30,
                10000,
                0.5,
                10
                );
    }
}