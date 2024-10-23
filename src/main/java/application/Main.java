package application;

import application.controller.CalculatorControllerInterface;
import application.controller.CalculatorController;
import application.model.CalculatorModel;
import application.model.CalculatorModelInterface;
import application.view.CalculatorView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize Model and Controller
        CalculatorModelInterface calculatorModelInterface = new CalculatorModel();
        CalculatorControllerInterface calculatorControler = new CalculatorController(calculatorModelInterface);

        // Initialize View and pass the controller to it
        CalculatorView calculatorView = new CalculatorView(calculatorControler);
        calculatorView.start(primaryStage);
    }
}
