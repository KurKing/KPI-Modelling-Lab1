import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        var drawer = new GraphDrawer(false);

        List<Double> randomNumbers = new ArrayList<>();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        Map<Double, Integer> distribution = new HashMap<>();

        var random = new Random();
        for (int i = 0; i < 10000; i++) {

            var num = random.nextDouble();

            randomNumbers.add(num);
            stats.addValue(num);

            int numInt = (int) (num * 10);
            double numDouble = ((double) numInt) / 10;

            if (distribution.containsKey(numDouble)) {

                int frequency = distribution.get(numDouble);
                distribution.put(numDouble, frequency + 1);
            } else {

                distribution.put(numDouble, 1);
            }
        }

        List<Double> doubleList = new ArrayList<>(distribution.keySet());
        List<Integer> integerList = new ArrayList<>(distribution.values());

        drawer.addChart("Default distribution", doubleList, integerList);
        drawer.displayChart();
    }
}