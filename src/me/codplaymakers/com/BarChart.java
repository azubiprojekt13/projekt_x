package me.codplaymakers.com;

import org.jfree.chart.*;
import java.awt.Dimension;
import org.jfree.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

/**
* A simple demonstration application showing how to create a bar chart.
*/
public class BarChart extends ApplicationFrame {
/**
* Creates a new demo instance.
*
* @param title the frame title.
*/
public BarChart(String title) {
	
super(title);

int anzahl;



DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.addValue(1.0, "Row 1", "Soll");
dataset.addValue(5.0, "Row 2", "Ist");
JFreeChart chart = ChartFactory.createBarChart(
"Termine", // chart title
"", // domain axis label
"Anzahl", // range axis label
dataset, // data
PlotOrientation.VERTICAL, // orientation
true, // include legend
true, // tooltips
false // URLs
);
ChartPanel chartPanel = new ChartPanel(chart, false);
chartPanel.setPreferredSize(new Dimension(500, 270));
setContentPane(chartPanel);
}
/**
* Starting point for the demonstration application.
*
* @param args ignored.
*/
public static void main(String[] args) {
BarChart demo = new BarChart("Bar Demo 1");
demo.pack();
RefineryUtilities.centerFrameOnScreen(demo);
demo.setVisible(true);
}}

