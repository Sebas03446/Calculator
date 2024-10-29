package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class CalculatorView implements CalculatorViewInterface {

    private CalculatorControllerInterface controller;
    private TextField inputField = new TextField();
    private TextArea pileView = new TextArea();

    public void setController(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    public String getInputTextField() {
        return inputField.getText();
    }

    public void setInputTextField(String input) {
        inputField.setText(input);
    }

    public void pileViewUpdated(List<Double> pile) {
        StringBuilder pileText = new StringBuilder();
        for (int i = pile.size() - 1; i >= 0; i--) {
            pileText.append(pile.get(i)).append("\n");
        }
        pileView.setText(pileText.toString());
    }

    public CalculatorView() {
    }

    public void start(Stage primaryStage) {
        Button addButton = new Button("Add");
        Button pushButton = new Button("Push");
        Button oneButton = new Button("1");
        Button twoButton = new Button("2");
        Label resultLabel = new Label("Result: 0.0");

        pileView.setEditable(false);
        pileView.setPrefHeight(150);

        addButton.setOnAction(e -> {
            controller.handleAddButton();
        });

        pushButton.setOnAction(e -> {
            controller.handlePushButton();
        });

        oneButton.setOnAction(e -> {
            controller.handleNumberButton("1");
        });

        twoButton.setOnAction(e -> {
            controller.handleNumberButton("2");
        });

        VBox layout = new VBox(10); // Increase spacing for better look
        layout.getChildren().addAll(pileView, inputField, addButton, pushButton, oneButton, twoButton, resultLabel);

        Scene scene = new Scene(layout, 300, 350); // Increased height for better spacing
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }
}
