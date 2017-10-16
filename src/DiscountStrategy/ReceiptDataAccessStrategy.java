package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public interface ReceiptDataAccessStrategy {
   
    public Customer findCustomer(String custId);
    
    public Product findProduct(String prodId);
}
