package application.view;

import application.controller.CalculatorControllerInterface;
import javafx.stage.Stage;

import java.util.List;

public interface CalculatorViewInterface {
    public void start(Stage primaryStage);
    public String getInputTextField();
    public void setInputTextField(String input);
    public void setController(CalculatorControllerInterface controller);
    public void pileViewUpdated(List<Double> pile);
}
