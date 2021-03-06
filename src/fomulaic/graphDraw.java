package fomulaic;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import models.GraphModel;
import models.XYData;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This program demonstrates how to draw XY line chart with XYDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class GraphDraw extends JFrame {
	HashMap<String, GraphModel> graphList;
	JPanel contentPane;
	
    public GraphDraw() {
        super("FORMULAIC Chart Viewer");   
    } 
    
    public GraphDraw(HashMap<String, GraphModel> graphList){
    	super("FORMULAIC Chart Viewer");
    	this.graphList = graphList;
    }
    
    public void setGraphList(HashMap<String, GraphModel> graphList){
    	this.graphList = graphList; 
    }
    
    public void showWindow(){
    	
    	JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
   
 
    private JPanel createChartPanel() {
    	boolean showLegend = true;
    	boolean createURL = true;
    	boolean createTooltip = true;
        // creates a line chart object
        // returns the chart panel
    	    String chartTitle = "Formula In chart";
    	    String xAxisLabel = "X Axis";
    	    String yAxisLabel = "Y Axis";
    	 
    	    XYDataset dataset = createDataset();
    	 
    	    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
    	            xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);
  
           XYPlot plot = chart.getXYPlot();  
    	   //XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
           XYSplineRenderer renderer = new XYSplineRenderer();
    	   
           //setcolors
           Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE};
           int j = 0;
           for (int i = 0; i < dataset.getSeriesCount(); i++) {
        	   
        	   renderer.setSeriesPaint(0, colors[j]);
        	   j++;
        	   if(j == colors.length) j = 0;
           }
           //
           
    	 // sets paint color for each series
//    	 renderer.setSeriesPaint(0, Color.RED);
//    	 renderer.setSeriesPaint(1, Color.GREEN);
//    	 renderer.setSeriesPaint(2, Color.YELLOW);
    	  
    	 // sets thickness for series (using strokes)
           renderer.setBaseStroke(new BasicStroke(0.5f));
//    	 renderer.setSeriesStroke(0, new BasicStroke(4.0f));
//    	 renderer.setSeriesStroke(1, new BasicStroke(3.0f));
//    	 renderer.setSeriesStroke(2, new BasicStroke(2.0f));
    	 
    	 // set background color of plot
    	 plot.setBackgroundPaint(Color.DARK_GRAY);
    	 
    	 //visibility of grid lines
    	 plot.setRangeGridlinesVisible(true);
    	 plot.setRangeGridlinePaint(Color.BLACK);   	  
    	 plot.setDomainGridlinesVisible(true);
    	 plot.setDomainGridlinePaint(Color.BLACK);
    	 
    	 //color for plot outline boarder
    	 plot.setOutlinePaint(Color.GRAY);
    	 plot.setOutlineStroke(new BasicStroke(5.0f));
    	  
    	 plot.setRenderer(renderer);
            
    	 return new ChartPanel(chart);
    }
 
    public XYDataset createDataset() {
            XYSeriesCollection dataset = new XYSeriesCollection();
            
            //draw graphs
            for (Map.Entry<String, GraphModel> entry : graphList.entrySet()) {
                String key = entry.getKey();
                GraphModel value = entry.getValue();
                
                XYSeries s = new XYSeries(key);
                ArrayList<XYData> xyList = value.getXYCordinates();
                
                for (XYData xyData : xyList) {
					s.add(xyData.X, xyData.Y);
					MainFrame.toSave(xyData.X, xyData.Y);
					
				}
                
                dataset.addSeries(s);
            }
            //
            
            
//    	    XYSeries series1 = new XYSeries("Formula");
//    	    XYSeries series2 = new XYSeries("Derivative 1");
//    	    XYSeries series3 = new XYSeries("Derivative 2");
//    	 
//    	    //pass formula values to here
//    	    series1.add(1.0, 2.0);
//    	    series1.add(2.0, 3.0);
//    	    series1.add(3.0, 2.5);
//    	    series1.add(3.5, 2.8);
//    	    series1.add(4.2, 6.0);
//    	 
//    	    //pass derivative 1 values here
//    	    series2.add(2.0, 1.0);
//    	    series2.add(2.5, 2.4);
//    	    series2.add(3.2, 1.2);
//    	    series2.add(3.9, 2.8);
//    	    series2.add(4.6, 3.0);
//    	 
//    	    //pass derivative 2 values here
//    	    series3.add(1.2, 4.0);
//    	    series3.add(2.5, 4.4);
//    	    series3.add(3.8, 4.2);
//    	    series3.add(4.3, 3.8);
//    	    series3.add(4.5, 4.0);
//    	 
//    	    dataset.addSeries(series1);
//    	    dataset.addSeries(series2);
//    	    dataset.addSeries(series3);
    	 
    	    return dataset;
    }
    

 
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new GraphDraw().setVisible(true);
//            }
//            
//        });
//      
//    }
}
