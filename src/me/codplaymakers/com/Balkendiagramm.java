package me.codplaymakers.com;

import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
* A simple demonstration application showing how to create a bar chart.
*/
public class Balkendiagramm extends ApplicationFrame {
/**
* Creates a new demo instance.
*
* @param title the frame title.
*/
public Balkendiagramm(String title, double wert1, double wert2) {
	
super(title);

int anzahl;



DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.addValue(wert1, "Ist", "Ziel");
dataset.addValue(wert2, "Soll", "Ziel");
JFreeChart chart = ChartFactory.createBarChart(
"Zielerfolg", // chart title
"", // domain axis label
"Anzahl", // range axis label
dataset, // data
PlotOrientation.VERTICAL, // orientation
true, // include legend
true, // tooltips
false // URLs
);
ChartPanel chartPanel = new ChartPanel(chart, false);
//chartPanel.setPreferredSize(new Dimension(500, 270));
chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
setContentPane(chartPanel);

}
}