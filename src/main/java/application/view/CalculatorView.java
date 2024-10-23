package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorView {
    private CalculatorControllerInterface controller;

    public CalculatorView(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    public void start(Stage primaryStage) {
        // UI components
        TextField inputField = new TextField();
        Button addButton = new Button("Add");
        Label resultLabel = new Label("Result: 0.0");

        // Button click event
        addButton.setOnAction(e -> {
            String input = inputField.getText();
            });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputField, addButton, resultLabel);

        // Scene setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }
}
