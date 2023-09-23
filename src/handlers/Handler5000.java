package handlers;

public class Handler5000 implements ICashHandler {
  private ICashHandler next;

  @Override
  public void dispense(int quantity) {
    if (quantity >= 5000) {
      int quantityCash = quantity / 5000;
      System.out.println("Deliver " + quantityCash + " bills of $5,000");
      int surplus = quantity % 5000;
      if (surplus > 0) {
        System.out.println("We can't dispense more $5,000 bills.");
      }
    } else {
      System.out.println("Invalid quantity. The amount must be a multiple of $5,000.");
    }
  }

  @Override
  public void nextHandler(ICashHandler next) {
    this.next = next;
  }
}
