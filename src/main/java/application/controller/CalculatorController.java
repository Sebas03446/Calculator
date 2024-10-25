package application.controller;

import application.model.CalculatorModelInterface;
import application.view.CalculatorViewInterface;

public class CalculatorController implements CalculatorControllerInterface {
    private CalculatorModelInterface model;
    private CalculatorViewInterface view;

    public CalculatorController(CalculatorModelInterface model, CalculatorViewInterface view) {
        this.model = model;
        this.view = view;
    }

    public void handleNumberButton(String a){
        String actualAcc = model.getAcc();
        String newAcc = actualAcc + a;
        model.setAcc(newAcc);
        view.setInputTextField(newAcc);
    }



    public void change(String accu){
        view.setInputTextField(accu);
    }

   // public void change(List<Double> stackData){}
}
