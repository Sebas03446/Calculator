package application.controller;

import application.model.CalculatorModelInterface;

public class CalculatorController implements CalculatorControllerInterface {
    private CalculatorModelInterface model;

    public CalculatorController(CalculatorModelInterface model) {
        this.model = model;
    }

    public void handlePressButton(String a){
        double convertA = Double.parseDouble(a);
        model.push(convertA);
    }



    /*public void change(String accu){

    }*/

   // public void change(List<Double> stackData){}
}
