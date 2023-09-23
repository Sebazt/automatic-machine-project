package handlers;

public interface ICashHandler {
  // interface
  void dispense(int quantity);

  void nextHandler(ICashHandler next);

}
