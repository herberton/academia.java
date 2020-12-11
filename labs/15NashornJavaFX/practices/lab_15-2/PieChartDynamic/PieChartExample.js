load("fx:base.js");
load("fx:controls.js");

function init(primaryStage) {
    var root = new Group();
    var scene = new Scene(root, 400, 300);
    primaryStage.scene = scene;
    primaryStage.title = "Pie chart Example";
    var pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Oracle", 30),
            new PieChart.Data("IBM", 12),
            new PieChart.Data("HP", 25),
            new PieChart.Data("Dell", 22),
            new PieChart.Data("Apple", 27)
            );
    var chart = new PieChart(pieChartData);
    //chart.labelsVisible = false;
    
    chart.maxWidthProperty().bind(scene.widthProperty());
    chart.maxHeightProperty().bind(scene.heightProperty());
    chart.setClockwise(false);
    root.getChildren().add(chart);
}
