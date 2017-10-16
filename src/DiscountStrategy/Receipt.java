package DiscountStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Cainebourne
 */
public class Receipt implements ReceiptFormatter {

   private ReceiptDataAccessStrategy db;
   private static int receiptNo;
   private Date receiptDate;
   private Customer customer;
   private LineItem[] lineItems;
   private ReceiptOutputStrategy output;
   private String dateFormat = "M/d/yyyy hh:mm a"; 
    
    

    public Receipt(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        this.setDB(db);
        this.customer = custId == null || custId.isEmpty() ? null : findCustomer(custId);
        receiptNo++;
        lineItems = new LineItem[0];
        this.output = output;
        receiptDate = new Date();
    }
   
     private Customer findCustomer(String custId){
        if(custId == null || custId.length() == 0){
            throw new IllegalArgumentException("Must enter valid cust id");
        }
        Customer cust = db.findCustomer(custId);
        if(cust == null){
            throw new IllegalArgumentException("Must enter valid valid id");
        }
        return cust;
    }
    
    public final double getTotalBeforeDiscount(){
        double total = 0.0;
        for (LineItem item : lineItems){
            total += item.getOriginalPriceSubtotal();
        }
        return total;
    }
    
    public final double getTotalDiscount() {
        double total = 0.0;
        for (LineItem item : lineItems){
            total += item.getDiscountAmt();
        }
        return total;
    }
    
    public final void addLineItem(String prodId, int qty){
        if(prodId == null || qty < 0){
            throw new IllegalArgumentException("Must enter valid prod id and quantity");
    }
        LineItem item = new LineItem(db, prodId, qty);
        addToArray(item);
    } 
    
    private void addToArray(final LineItem item) {
        if(item == null){
            throw new IllegalArgumentException("Must enter valid item");
        }
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    public final  String getReciptDataFormatted(){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(receiptDate);
    }
    
    public final void outputMessage(String msg){
        output.outputReceipt(msg);
    }
    
    public final void outputReceipt() {
         StringBuilder receiptData = new StringBuilder();
         output.outputReceipt(receiptData.toString());
    }
   
    public final void setDB(ReceiptDataAccessStrategy db){
        if(db == null){
              throw new IllegalArgumentException("Must enter valid database");
        }
        this.db = db;
    }
    
    public final void setOutPut(ReceiptOutputStrategy output){
        if(output == null){
            throw new IllegalArgumentException("Must enter valid output type");
        }
        this.output = output;
    }
    
    public final void setDateFromat(String dateFormat){
        this.dateFormat = dateFormat;
    }

    @Override
    public void formatReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
