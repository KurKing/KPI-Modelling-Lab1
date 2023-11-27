package distribution;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Map;

public class BinnedStatistics extends DescriptiveStatistics {

    private final int numberOfBins;

    public BinnedStatistics(int numberOfBins) {

        super();
        this.numberOfBins = numberOfBins;
    }

    public Map<Integer, Integer> getBins() {

        double min = getMin();
        double max = getMax();
        double binWidth = (max - min) / numberOfBins;

        Map<Integer, Integer> bins = new HashMap<>();

        for (double i: getValues()) {

            int binIndex = (int) ((i - min) / binWidth);
            binIndex = Math.min(binIndex, numberOfBins - 1);
            bins.merge(binIndex, 1, Integer::sum);
        }

        return bins;
    }
}
