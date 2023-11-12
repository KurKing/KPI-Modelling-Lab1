import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.List;

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

        chart.getStyler().setMarkerSize(4);
    }

    public void addChart(List<Integer> x, List<Integer> y) {

        counter += 1;
        String name = "Chart #" + counter;

        chart.addSeries(name, x, y);
    }

    public void displayChart() {

        new SwingWrapper<>(chart).displayChart();
    }
}
