import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis(0,1,0.1);
        final NumberAxis yAxis = new NumberAxis(0,1,0.1);
        xAxis.setLabel("Sr");
        yAxis.setLabel("&r");

        //creating the chart
        final AreaChart<Number,Number> lineChart =
                new AreaChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("平面缺陷简化评定的失效评定图");
        lineChart.setCreateSymbols(false);

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("安全");
        //populating the series with data
//        series.getData().add(new XYChart.Data(Math.random(), Math.random()));
        series.getData().add(new XYChart.Data(0.1, 0.5));
        series.getData().add(new XYChart.Data(0.2, 0.55));
        series.getData().add(new XYChart.Data(0.3, 0.6));
        series.getData().add(new XYChart.Data(0.4, 0.67));
        series.getData().add(new XYChart.Data(0.45, 0.7));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("非安全");
        series2.getData().add(new XYChart.Data(0.45, 0.7));
        series2.getData().add(new XYChart.Data(0.5, 0.74));
        series2.getData().add(new XYChart.Data(0.6, 0.8));
        series2.getData().add(new XYChart.Data(0.65, 0.85));
        series2.getData().add(new XYChart.Data(0.7, 0.8));
        series2.getData().add(new XYChart.Data(0.74, 0.76));
        series2.getData().add(new XYChart.Data(0.8, 0.7));
        series2.getData().add(new XYChart.Data(0.9, 0.45));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName(null);
        series3.getData().add(new XYChart.Data(0, 0.7));
        series3.getData().add(new XYChart.Data(0.5, 0.7));
        series3.getData().add(new XYChart.Data(0.8, 0.7));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName(null);
        series4.getData().add(new XYChart.Data(0.8, 0));
        series4.getData().add(new XYChart.Data(0.8, 0.3));
        series4.getData().add(new XYChart.Data(0.8, 0.7));



        Scene scene  = new Scene(lineChart,800,600);
//        lineChart.getData().add(series);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(MainApp.class.getResource("/css/main.css").toExternalForm());
        lineChart.getData().addAll(series, series2,series3,series4);
        lineChart.setAlternativeColumnFillVisible(true);
        lineChart.setAlternativeRowFillVisible(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


