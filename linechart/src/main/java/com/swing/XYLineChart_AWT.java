package com.swing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class XYLineChart_AWT extends ApplicationFrame
{
    public XYLineChart_AWT( String applicationTitle, String chartTitle )
    {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Sr" ,
                "&r" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                true , true , false);
        StandardChartTheme chartTheme = new StandardChartTheme("CN");

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 600 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        NumberAxis xnumberAxis = (NumberAxis) plot.getDomainAxis();
        plot.getDomainAxis().setLowerBound(0);
        plot.getDomainAxis().setUpperBound(1);
        plot.getDomainAxis().setAutoRange(false);
        plot.getDomainAxis().setAutoRangeMinimumSize(0.1,true);

        xnumberAxis.setAutoTickUnitSelection(false);
        xnumberAxis.setTickUnit(new NumberTickUnit(0.1));

        NumberAxis ynumberAxis = (NumberAxis) plot.getRangeAxis();
        ynumberAxis.setAutoTickUnitSelection(false);
        ynumberAxis.setTickUnit(new NumberTickUnit(0.1));

        plot.getRangeAxis().setLowerBound(0);
        plot.getRangeAxis().setUpperBound(1);
        plot.getRangeAxis().setAutoRange(false);
        plot.getRangeAxis().setAutoRangeMinimumSize(0.1);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.GREEN );
        renderer.setSeriesPaint( 1 , Color.RED );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );


        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset( )
    {
        final XYSeries firefox = new XYSeries( "safe" );
        firefox.add(0.1, 0.5 );
        firefox.add( 0.2, 0.55 );
        firefox.add( 0.3, 0.6 );
        firefox.add( 0.4, 0.67);
        firefox.add( 0.45, 0.7);
        final XYSeries chrome = new XYSeries( "danger" );
        chrome.add( 0.45, 0.7 );
        chrome.add( 0.5, 0.74);
        chrome.add( 0.65, 0.85 );
        chrome.add( 0.7, 0.8 );
        chrome.add( 0.74, 0.76 );
        chrome.add( 0.8, 0.7 );
        chrome.add( 0.9, 0.45);
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( firefox );
        dataset.addSeries( chrome );
        return dataset;
    }

    public static void main( String[ ] args )
    {
        XYLineChart_AWT chart = new XYLineChart_AWT("缺陷评定失效图", "Defect assessment failure diagram");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}