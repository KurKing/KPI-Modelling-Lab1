import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GraphDrawer {

    private final XYChart chart;
    private int counter = 0;

    public GraphDrawer(Boolean isScatter) {

        this.chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("KPI Modelling")
                .xAxisTitle("x")
                .yAxisTitle("y")
                .build();

        if (isScatter) {

            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        }

        chart.getStyler().setMarkerSize(8);
        chart.getStyler().setYAxisMin(0.0);
    }

    public void addChart(String chartName, List<Double> x, List<Integer> y) {

        List<DataPoint> dataPoints = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            dataPoints.add(new DataPoint(x.get(i), y.get(i)));
        }

        Collections.sort(dataPoints, Comparator.comparingDouble(DataPoint::getX));
        List<Double> sortedX = dataPoints.stream().map(DataPoint::getX).collect(Collectors.toList());
        List<Integer> sortedY = dataPoints.stream().map(DataPoint::getY).collect(Collectors.toList());

        chart.addSeries(chartName, sortedX, sortedY);
    }

    public void displayChart() {

        new SwingWrapper<>(chart).displayChart();
    }

    private class DataPoint {

        private double x;
        private int y;

        public DataPoint(double x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
