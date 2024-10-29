package application.controller;

import java.util.List;


public interface CalculatorControllerInterface {
    public void change(String accu);
    public void change(List<Double> stackData);
    public void handleNumberButton(String a);
    public void handleAddButton();
    public void handlePushButton();
}
