package DiscountStrategy;

import javax.swing.JOptionPane;
/**
 *
 * @author Cainebourne
 */
public class ReceiptGUIOutput implements ReceiptOutputStrategy {

    @Override
    public void outputReceipt(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    
}
