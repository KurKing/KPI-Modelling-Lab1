import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GraphDrawer drawer = new GraphDrawer(false);

        List<Integer> randomNumbers1 = new ArrayList<>();
        List<Integer> randomNumbers2 = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {

            randomNumbers1.add(random.nextInt(0,1000));
            randomNumbers2.add(random.nextInt(0,1000));
        }

        Collections.sort(randomNumbers1);

        drawer.addChart(randomNumbers1, randomNumbers2);

        drawer.displayChart();
    }
}