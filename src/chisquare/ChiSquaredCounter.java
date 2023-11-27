package chisquare;

import java.util.List;
import java.util.Map;

abstract public class ChiSquaredCounter {

    protected final Map<Integer, Integer>  frequencyMap;
    protected final int numBins;
    protected final int sampleSize;

    public ChiSquaredCounter(Map<Integer, Integer> frequencyMap, int numBins, int sampleSize) {

        this.frequencyMap = frequencyMap;
        this.numBins = numBins;
        this.sampleSize = sampleSize;
    }

    public double calculateChiSquared() {

        double chiSquared = 0.0;

        List<Double> expectedFrequencies = calculateExpectedFrequencies();

        for (int i = 0; i < numBins; i++) {

            double observed = frequencyMap.getOrDefault(i, 0);
            double expected = expectedFrequencies.get(i);

            double binChiSquare = Math.pow(observed - expected, 2) / expected;

            chiSquared += binChiSquare;
        }

        return chiSquared;
    }

    protected abstract List<Double> calculateExpectedFrequencies();
}
