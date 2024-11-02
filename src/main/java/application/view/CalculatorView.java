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

        Button commaButton = new Button(",");
        commaButton.setMinSize(50, 50);
        commaButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        commaButton.setOnAction(e -> {
            controller.handleNumberButton(".");
        });

        Button oppositeButton = new Button("+/-");
        oppositeButton.setMinSize(50, 50);
        oppositeButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        oppositeButton.setOnAction(e -> {
            controller.handleOppositeButton();
        });

        Button pushButton = new Button("Push");
        pushButton.setMinSize(50, 50);
        pushButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        pushButton.setOnAction(e -> {
            controller.handlePushButton();
        });

        Button popButton = new Button("Pop");
        popButton.setMinSize(50, 50);
        popButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        popButton.setOnAction(e -> {
            controller.handlePopButton();
        });

        Button clearButton = new Button("Clear");
        clearButton.setMinSize(50, 50);
        clearButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        clearButton.setOnAction(e -> {
            controller.handleClearButton();
        });

        Button swapButton = new Button("Swap");
        swapButton.setMinSize(50, 50);
        swapButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        swapButton.setOnAction(e -> {
            controller.handleSwapButton();
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
        column.setPercentWidth(20);
        grid.getColumnConstraints().addAll(column, column, column, column, column);

        // First row (numbers 7, 8, 9, divide operator)
        grid.add(numberButtons[7], 0, 0);
        grid.add(numberButtons[8], 1, 0);
        grid.add(numberButtons[9], 2, 0);
        grid.add(operatorButtons[0], 3, 0); // Divide

        // Second row (numbers 4, 5, 6, multiply operator)
        grid.add(numberButtons[4], 0, 1);
        grid.add(numberButtons[5], 1, 1);
        grid.add(numberButtons[6], 2, 1);
        grid.add(operatorButtons[1], 3, 1); // Multiply

        // Third row (numbers 1, 2, 3, subtract operator)
        grid.add(numberButtons[1], 0, 2);
        grid.add(numberButtons[2], 1, 2);
        grid.add(numberButtons[3], 2, 2);
        grid.add(operatorButtons[2], 3, 2); // Subtract

        // Fourth row (number 0, comma, opposite, add operator)
        grid.add(numberButtons[0], 0, 3);
        grid.add(commaButton, 1, 3);
        grid.add(oppositeButton, 2, 3);  // Opposite button next to comma button
        grid.add(operatorButtons[3], 3, 3); // Add

        // Fifth column (Push, Pop, Clear, Swap buttons)
        grid.add(pushButton, 4, 0);  // Push button in fifth column, first row
        grid.add(popButton, 4, 1);   // Pop button in fifth column, second row
        grid.add(clearButton, 4, 2); // Clear button in fifth column, third row
        grid.add(swapButton, 4, 3);  // Swap button in fifth column, fourth row

        // Create the main layout and add components
        VBox layout = new VBox(10);
        layout.getChildren().addAll(pileView, inputField, grid);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculatrice");
        primaryStage.show();
    }


}
