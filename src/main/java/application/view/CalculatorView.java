package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

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
        String[] operators = {"/", "*", "-", "+"};
        Button[] operatorButtons = new Button[operators.length];

        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new Button(operators[i]);
            operatorButtons[i].setMinSize(50, 50);
            operatorButtons[i].setFont(Font.font("Arial", FontWeight.BOLD, 14));
        }

        Button[] numberButtons = new Button[10];
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].setMinSize(50, 50);
            numberButtons[i].setFont(Font.font("Arial", FontWeight.BOLD, 14));
            final int num = i;
            numberButtons[i].setOnAction(e -> {
                controller.handleNumberButton(String.valueOf(num));
            });
        }

        Button pushButton = new Button("Push");
        pushButton.setMinSize(50, 50);
        pushButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pushButton.setOnAction(e -> {
            controller.handlePushButton();
        });

        operatorButtons[0].setOnAction(e -> controller.handleDivideButton());
        operatorButtons[1].setOnAction(e -> controller.handleMultiplyButton());
        operatorButtons[2].setOnAction(e -> controller.handleSubtractButton());
        operatorButtons[3].setOnAction(e -> controller.handleAddButton());

        // Configure 'pileView' and 'inputField'
        pileView.setEditable(false);
        pileView.setPrefHeight(150);

        // Arrange buttons in a GridPane to mimic a calculator layout
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);

        // Set uniform column widths
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(25);
        grid.getColumnConstraints().addAll(column, column, column, column);

        // First row
        grid.add(numberButtons[7], 0, 0);
        grid.add(numberButtons[8], 1, 0);
        grid.add(numberButtons[9], 2, 0);
        grid.add(operatorButtons[0], 3, 0); // Divide

        // Second row
        grid.add(numberButtons[4], 0, 1);
        grid.add(numberButtons[5], 1, 1);
        grid.add(numberButtons[6], 2, 1);
        grid.add(operatorButtons[1], 3, 1); // Multiply

        // Third row
        grid.add(numberButtons[1], 0, 2);
        grid.add(numberButtons[2], 1, 2);
        grid.add(numberButtons[3], 2, 2);
        grid.add(operatorButtons[2], 3, 2); // Subtract

        // Fourth row
        grid.add(numberButtons[0], 0, 3);
        grid.add(pushButton, 1, 3);
        // Empty placeholder to maintain grid structure
        grid.add(new Pane(), 2, 3);
        grid.add(operatorButtons[3], 3, 3); // Add

        // Create the main layout and add components
        VBox layout = new VBox(10);
        layout.getChildren().addAll(pileView, inputField, grid);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }
}
