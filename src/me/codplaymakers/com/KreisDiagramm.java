package me.codplaymakers.com;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


public class KreisDiagramm extends JFrame {

  private static final long serialVersionUID = 1L;
  private DefaultPieDataset dataset1;
  private String DiagrammTitel;
  private PieDataset dataset2;
  public KreisDiagramm(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        DiagrammTitel=chartTitle;
        dataset1 = new DefaultPieDataset();
    }
  
  public void createDiagramm(){
	  JFreeChart chart = createChart(dataset2, DiagrammTitel);
      // we put the chart into a panel
      ChartPanel chartPanel = new ChartPanel(chart);
      // default size
      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      // add it to our application
      setContentPane(chartPanel);

  }
    
    
/**
     * Creates a sample dataset 
     */

        
    public void AddValue(String Was,Double Wert){
    	dataset1.setValue(Was, Wert);
    	dataset2=dataset1;
    }
/**
     * Creates a chart
     */

    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
} 
