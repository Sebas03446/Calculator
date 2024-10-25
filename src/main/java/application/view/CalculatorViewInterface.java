package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.stage.Stage;

public interface CalculatorViewInterface {
    public void start(Stage primaryStage);
    public String getInputTextField();
    public void setInputTextField(String input);
    public void setController(CalculatorControllerInterface controller);
}
