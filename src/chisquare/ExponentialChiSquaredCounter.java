package chisquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExponentialChiSquaredCounter extends ChiSquaredCounter {

    private final double lambda;

    public ExponentialChiSquaredCounter(Map<Integer, Integer> frequencyMap, 
                                        int numBins, 
                                        double lambda, 
                                        int sampleSize,
                                        double min,
                                        double max) {

        super(frequencyMap, min, max, numBins, sampleSize);

        this.lambda = lambda;
    }

    @Override
    protected List<Double> calculateExpectedFrequencies() {

        List<Double> expectedFrequencies = new ArrayList<>();

        for (int i = 0; i < numBins; i++) {

            double expectedStart = 1 - Math.exp(-lambda * (i * binWidth + min));

            double endX = Math.min((i + 1) * binWidth + min, max);
            double expectedEnd = 1 - Math.exp(-lambda * endX);

            double expectedFrequency = sampleSize * (expectedEnd - expectedStart);

            expectedFrequencies.add(expectedFrequency);
        }

        return expectedFrequencies;
    }
}
