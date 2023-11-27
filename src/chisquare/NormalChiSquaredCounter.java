package chisquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NormalChiSquaredCounter extends ChiSquaredCounter {

    private final double sigma;
    private final double a;

    public NormalChiSquaredCounter(Map<Integer, Integer> frequencyMap,
                                   double min,
                                   double max,
                                   int numBins,
                                   int sampleSize,
                                   double sigma,
                                   double a) {

        super(frequencyMap, min, max, numBins, sampleSize);

        this.sigma = sigma;
        this.a = a;
    }

    @Override
    protected List<Double> calculateExpectedFrequencies() {

        List<Double> expectedFrequencies = new ArrayList<>();

        for (int i = 0; i < numBins; i++) {

            double startX = i * binWidth + min;
            double endX = Math.min((i + 1) * binWidth + min, max);

            double expectedFrequency = countF((startX+endX) / 2) * binWidth * sampleSize;

            expectedFrequencies.add(expectedFrequency);
        }

        return expectedFrequencies;
    }

    private double countF(double x) {

        double coefficient = 1.0 / (sigma * Math.sqrt(2 * Math.PI));
        double exponent = -1.0 * Math.pow(x - a, 2) / (2 * Math.pow(sigma, 2));
        return coefficient * Math.exp(exponent);
    }
}
