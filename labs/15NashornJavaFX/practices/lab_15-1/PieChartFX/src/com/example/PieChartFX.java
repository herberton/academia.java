package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartFX extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Pie Chart Example");
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Oracle", 30),
            new PieChart.Data("IBM", 12),
            new PieChart.Data("HP", 25),
            new PieChart.Data("Dell", 22),
            new PieChart.Data("Apple", 27)
    );
    PieChart chart = new PieChart(pieChartData);

    Scene scene = new Scene(chart, 400, 300);
    // Shrink / grow the chart with the size of the frame
    chart.maxWidthProperty().bind(scene.widthProperty());
    chart.maxHeightProperty().bind(scene.heightProperty());
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  /**
   * The main() method is ignored in correctly deployed JavaFX application.
   * main() serves only as fallback in case the application can not be launched
   * through deployment artifacts, e.g., in IDEs with limited FX support.
   * NetBeans ignores main().
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
