package application.model;

import application.controller.CalculatorControllerInterface;

public interface CalculatorModelInterface {
    public void add();
    public void subtract(  );
    public void multiply(  );
    public void divide( );
    public void opposite();
    public void push();
    public Double pop();
    public void clear();
    public void  setAcc(String acc);
    public String getAcc();
    public void setController(CalculatorControllerInterface controller);
    public void swap();
}
