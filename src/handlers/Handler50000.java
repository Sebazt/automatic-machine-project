package handlers;

public class Handler50000 implements ICashHandler {
  private ICashHandler next;

  @Override
  public void dispense(int quantity) {
    if (quantity >= 50000) {
      int quantityCash = quantity / 50000;
      System.out.println("Deliver " + quantityCash + " bills of $50,000");
      int surplus = quantity % 50000;
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
