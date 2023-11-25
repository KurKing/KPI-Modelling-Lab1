import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Distribution {

    private final DescriptiveStatistics stats = new DescriptiveStatistics();
    private final Map<Double, Integer> distributionMap = new HashMap<>();

    public void add(Double num) {

        stats.addValue(num);

        double numDouble = ((double) (int) (num * 10)) / 10;

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

    public DescriptiveStatistics getStats() {
        return stats;
    }
}
