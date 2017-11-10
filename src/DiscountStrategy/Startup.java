package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class Startup {
    public static void main(String[] args) {
            //Configuration
            PosTerminal pos = new PosTerminal();
            ReceiptDataAccessStrategy db = new InMemoryDataAccess();
//            Store Kohls = new Store();
            //sale 1
         
            pos.startNewSale("100", db, new ReceiptConsoleOutput());
            pos.addItemToSale("B205", 2);
            pos.addItemToSale("A101", 1);
            pos.endSaleAndOutputReceipt();
            
            
            
            
            
            
            //sale 2
            
            pos.startNewSale("200", new InMemoryDataAccess(), new ReceiptGUIOutput());
            pos.addItemToSale("C222", 4);
            pos.addItemToSale("B205", 6);
            pos.endSaleAndOutputReceipt();
            
            
            
            
            //sale 3
            
            pos.startNewSale("300", db, new ReceiptConsoleOutput());
            pos.addItemToSale("C222", 1);
            pos.addItemToSale("A101", 3);
            pos.endSaleAndOutputReceipt();
    }     
    
}
