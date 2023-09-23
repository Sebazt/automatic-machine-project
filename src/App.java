import handlers.ICashHandler;
import handlers.Handler100000;
import handlers.Handler10000;
import handlers.Handler50000;
import handlers.Handler20000;
import handlers.Handler5000;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Instancias de los manejadores para llamarlo despues en el main
        ICashHandler handler100000 = new Handler100000();
        ICashHandler handler50000 = new Handler50000();
        ICashHandler handler20000 = new Handler20000();
        ICashHandler handler10000 = new Handler10000();
        ICashHandler handler5000 = new Handler5000();

        // Conecto los manejadores en cadena
        handler100000.nextHandler(handler50000);
        handler50000.nextHandler(handler20000);
        handler20000.nextHandler(handler10000);
        handler10000.nextHandler(handler5000);

        int quantityTodispense = 0;
        boolean validQuantity = false;

        while (!validQuantity) {
            try {
                quantityTodispense = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "Please input the withdrawal amount."));
                if (quantityTodispense % 5000 == 0) {
                    validQuantity = true;
                } else {
                    System.out.println("The amount must be a multiple of $5,000. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        handler100000.dispense(quantityTodispense);

        String respuesta = JOptionPane.showInputDialog(null, "¿Do you want to perform another transaction? (Yes / Not)");
        if (respuesta != null && respuesta.equalsIgnoreCase("Not")) {
            System.out.println("Transaction canceled.");
        }
    }
}
