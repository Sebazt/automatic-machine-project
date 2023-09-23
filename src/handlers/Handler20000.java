package handlers;

public class Handler20000 implements ICashHandler {
  private ICashHandler next;

  @Override
  public void dispense(int quantity) {
    if (quantity >= 20000) {
      int quantityCash = quantity / 20000;
      System.out.println("Deliver " + quantityCash + " bills of $20,000");
      int surplus = quantity % 20000;
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