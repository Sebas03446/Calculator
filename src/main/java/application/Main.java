package application;

import application.controller.CalculatorControllerInterface;
import application.controller.CalculatorController;
import application.model.CalculatorModel;
import application.model.CalculatorModelInterface;
import application.view.CalculatorView;
import application.view.CalculatorViewInterface;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CalculatorModelInterface calculatorModelInterface = new CalculatorModel();
        CalculatorViewInterface calculatorViewInterface = new CalculatorView();

        CalculatorControllerInterface calculatorController = new CalculatorController(calculatorModelInterface,calculatorViewInterface);


        calculatorViewInterface.setController(calculatorController);
        calculatorModelInterface.setController(calculatorController);

        calculatorViewInterface.start(primaryStage);
    }
}
