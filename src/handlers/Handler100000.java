package handlers;

public class Handler100000 implements ICashHandler {

  private ICashHandler next;

  @Override
  public void dispense(int quantity) {
    if (quantity >= 100000) {
      int quantityCash = quantity / 100000;
      System.out.println("Deliver " + quantityCash + " bills of $100,000");
      int surplus = quantity % 100000;
      if (surplus > 0) {
        next.dispense(surplus);
      }
    } else {
      next.dispense(quantity);
    }
  }

  @Override
  public void nextHandler(ICashHandler next) {
    this.next = next;
  }
}
