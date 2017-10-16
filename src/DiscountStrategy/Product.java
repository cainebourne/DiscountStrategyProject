package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class Product {
    private String prodId;
    private String prodName;
    private double unitPrice;
    private DiscountStrategy discountStrategy;

    public Product(String prodId, String prodName, double unitPrice, DiscountStrategy discountStrategy) {
        setProdId(prodId);
        setProdName(prodName);
        setUnitPrice(unitPrice);
        setDiscountStrategy(discountStrategy);
    }
    
    public final double getDiscountAmt(double qty){
       return discountStrategy.getDiscountAmt(unitPrice, qty);
    }
    
    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(String prodId) {
        if(prodId == null){
            throw new IllegalArgumentException("Must enter valid product id");
        }
        this.prodId = prodId;
    }

    public final double getUnitPrice() {
 
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
         if(unitPrice < 0){
            throw new IllegalArgumentException("Must enter valid percentage");
        }
        this.unitPrice = unitPrice;
    }

    public final String getProdName() {
        
        return prodName;
    }

    public final void setProdName(String prodName) {
         if(prodName == null){
            throw new IllegalArgumentException("Must enter valid product name");
        }
        this.prodName = prodName;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        if(discountStrategy == null){
            throw new IllegalArgumentException("discount is required");
        }
        this.discountStrategy = discountStrategy;
    }
    
    
}
