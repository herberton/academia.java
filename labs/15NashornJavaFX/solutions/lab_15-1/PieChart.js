var Scene = Java.type("javafx.scene.Scene");
var Group = Java.type("javafx.scene.Group");
var PieChart = Java.type("javafx.scene.chart.PieChart");
var FXCollections = Java.type("javafx.collections.FXCollections");

function start(primaryStage) {
    var root = new Group();
    var scene = new Scene(root, 400, 300);
    primaryStage.scene = scene;

    primaryStage.title = "Pie Chart Example";
    var pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Oracle", 30),
            new PieChart.Data("IBM", 12),
            new PieChart.Data("HP", 25),
            new PieChart.Data("Dell", 22),
            new PieChart.Data("Apple", 27)
            );
    var chart = new PieChart(pieChartData);
    chart.maxWidthProperty().bind(scene.widthProperty());
    chart.maxHeightProperty().bind(scene.heightProperty());
    root.getChildren().add(chart);
    primaryStage.show();
}
