package chisquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinearChiSquaredCounter extends ChiSquaredCounter {

    public LinearChiSquaredCounter(Map<Integer, Integer> frequencyMap,
                                   double min,
                                   double max,
                                   int numBins,
                                   int sampleSize) {

        super(frequencyMap, min, max, numBins, sampleSize);
    }

    @Override
    protected List<Double> calculateExpectedFrequencies() {

        List<Double> expectedFrequencies = new ArrayList<>();
        double expectedFrequency = sampleSize / numBins;

        for (int i = 0; i < numBins; i++) {

            expectedFrequencies.add(expectedFrequency);
        }

        return expectedFrequencies;
    }
}
