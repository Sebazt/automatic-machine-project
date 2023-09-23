package handlers;

public class Handler10000 implements ICashHandler {
  private ICashHandler next;

  @Override
  public void dispense(int quantity) {
    if (quantity >= 10000) {
      int quantityCash = quantity / 10000;
      System.out.println("Deliver " + quantityCash + " bills of $10,000");
      int surplus = quantity % 10000;
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