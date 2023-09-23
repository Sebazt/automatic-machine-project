package handlers;

public interface ICashHandler {

  void dispense(int quantity);

  void nextHandler(ICashHandler next);

}
