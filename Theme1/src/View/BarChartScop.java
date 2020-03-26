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

public class BarChartScop extends JFrame {
	

	public BarChartScop(Map<String,Integer> mapi) {
		CategoryDataset dataset = createDataset(mapi);
		
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	private CategoryDataset createDataset(Map<String,Integer> mapi) {
		var dataset = new DefaultCategoryDataset();
		Iterator entry = mapi.entrySet().iterator();
		while(entry.hasNext()) {
			Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>)entry.next();			
			dataset.setValue(pair.getValue(), "Numar evenimente", pair.getKey());
			
		}
		
		return dataset;
	}
	private JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart barChart = ChartFactory.createBarChart("Statistici evenimente 2020",
															"",
															"Numar evenimente",
															dataset,
															PlotOrientation.VERTICAL,
															false, true, false);
		return barChart;
	}
	
	

}
