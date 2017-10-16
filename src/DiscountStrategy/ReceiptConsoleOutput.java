package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class ReceiptConsoleOutput implements ReceiptOutputStrategy {

    @Override
    public void outputReceipt(String msg) {
        System.out.println(msg);
    }
    
}
