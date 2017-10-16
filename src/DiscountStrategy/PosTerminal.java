package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class PosTerminal {
    
    private ReceiptOutputStrategy output;
    private Receipt receipt;

    public final void startNewSale(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        receipt = new Receipt(custId, db, output);
        return;
    }
    
     public final void endSaleAndOutputReceipt() {
        receipt.outputReceipt();
    }

    public final void addItemToSale(String prodId, int qty) {
        if(prodId == null || prodId.length() == 0 || qty < 1){
            throw new IllegalArgumentException("Must enter valid product id and quantity");
        }
        receipt.addLineItem(prodId, qty);
    }
      
}
