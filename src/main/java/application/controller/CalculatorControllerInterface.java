package application.controller;

import java.util.List;


public interface CalculatorControllerInterface {
    public void change(String accu);
    public void change(List<Double> stackData);
    public void handleNumberButton(String a);
    public void handleAddButton();
    public void handleSubtractButton();
    public void handleMultiplyButton();
    public void handleDivideButton();
    public void handlePushButton();
    public void handlePopButton();
    public void handleClearButton();
}
