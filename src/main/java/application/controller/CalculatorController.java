package application.controller;

import application.model.CalculatorModelInterface;
import application.view.CalculatorViewInterface;

import java.util.List;

public class CalculatorController implements CalculatorControllerInterface {
    private CalculatorModelInterface model;
    private CalculatorViewInterface view;

    public CalculatorController(CalculatorModelInterface model, CalculatorViewInterface view) {
        this.model = model;
        this.view = view;

    }

    public void handleNumberButton(String a){
        model.setAcc(a);
    }

    public void change(String accu){
        view.setInputTextField(accu);
    }

    public void handleAddButton(){ model.add();}

    public void handleSubstractButton(){model.subtract();}

    public void handleMultiplyButton(){model.multiply();}

    public void handleDivideButton(){model.divide();}

    public void handlePushButton(){model.push();}

   public void change(List<Double> stackData){
        view.pileViewUpdated(stackData);
   }
}
