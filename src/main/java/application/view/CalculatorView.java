package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorView implements CalculatorViewInterface {


    private CalculatorControllerInterface controller;
    private TextField inputField = new TextField();

    public void setController(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    public String getInputTextField(){
        return inputField.getText();
    }

    public void setInputTextField(String input){
        inputField.setText(input);
    }

    public CalculatorView() {

    }

    public void start(Stage primaryStage) {


        Button addButton = new Button("Add");
        Button oneButton = new Button("1");
        Button twoButton = new Button("2");
        Label resultLabel = new Label("Result: 0.0");

        addButton.setOnAction(e -> {
            String input = inputField.getText();
            System.out.println(e.getEventType().getName());
        });

        oneButton.setOnAction(e ->{
            controller.handleNumberButton("1");

        }      );

        twoButton.setOnAction(e ->{
            String input = inputField.getText();
            System.out.println(e.getEventType().getName());
        });




        VBox layout = new VBox(5);
        layout.getChildren().addAll(inputField, addButton, oneButton,twoButton, resultLabel);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }
}
