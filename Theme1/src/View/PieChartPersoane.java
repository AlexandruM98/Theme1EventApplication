package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartPersoane extends JFrame {
	

	public PieChartPersoane(Map<String,Integer> mapi) {
		DefaultPieDataset dataset = createDataset(mapi);
		
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	private DefaultPieDataset createDataset(Map<String,Integer> mapi) {
		var dataset = new DefaultPieDataset();
		Iterator entry = mapi.entrySet().iterator();
		while(entry.hasNext()) {
			Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>)entry.next();			
			dataset.setValue(pair.getKey(),pair.getValue());
			
		}
		
		return dataset;
	}
	private JFreeChart createChart(DefaultPieDataset dataset) {
		JFreeChart barChart = ChartFactory.createPieChart("Nr. Persoane Evenimente 2020",															
															dataset,															
															false, true, false);
		return barChart;
	}
	
	

}
