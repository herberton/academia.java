load("fx:base.js");
load("fx:controls.js");

$STAGE.title = "Pie Chart Example";
var root = new Group();
var scene = new Scene(root, 400, 300);
$STAGE.scene = scene;
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
$STAGE.show();