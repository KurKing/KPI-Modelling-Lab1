package distribution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Distribution {

    private final int segment;

    private final BinnedStatistics stats = new BinnedStatistics(30);
    private final Map<Double, Integer> distributionMap = new HashMap<>();

    public Distribution(int segment) {

        this.segment = segment;
    }

    public void add(Double num) {

        stats.addValue(num);

        double numDouble = ((double) (int) (num * segment)) / segment;

        if (distributionMap.containsKey(numDouble)) {

            int frequency = distributionMap.get(numDouble);
            distributionMap.put(numDouble, frequency + 1);
        } else {

            distributionMap.put(numDouble, 1);
        }
    }

    public List<Double> getKeys() {

        return distributionMap.keySet().stream().toList();
    }

    public List<Integer> getValues() {

        return distributionMap.values().stream().toList();
    }

    public BinnedStatistics getStats() {
        return stats;
    }
}
