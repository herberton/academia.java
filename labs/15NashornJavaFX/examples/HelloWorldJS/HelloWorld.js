var Button = Java.type("javafx.scene.control.Button");
var StackPane = Java.type("javafx.scene.layout.StackPane");
var Scene = Java.type("javafx.scene.Scene");

function start(primaryStage) {
    primaryStage.title = "Hello World";
    var btn = new Button();
    btn.text = "Say 'Hello World'";
    btn.onAction = function() print ("Hello World");
    var root = new StackPane();
    root.children.add(btn);
    primaryStage.scene = new Scene(root, 300, 250);
    primaryStage.show();
}