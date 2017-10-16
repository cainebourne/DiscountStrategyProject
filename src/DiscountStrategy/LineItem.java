package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class LineItem {
    private ReceiptDataAccessStrategy db;
    private Product product;
    private int qty;

    public LineItem(ReceiptDataAccessStrategy db, String prodId, int qty) {
        this.db = db;
        this.product = findProduct(prodId);
        setQty(qty);
           
    }
    public final Product findProduct(final String prodId) {
        if(prodId == null || prodId.length() == 0) {
            throw new IllegalArgumentException("no valid product found");
            
        }
        return db.findProduct(prodId);
    }
    
    public final double getOriginalPriceSubtotal(){
        return product.getUnitPrice() * qty;
    }
    
    public final double getDiscountAmt(){
        return product.getDiscountStrategy().getDiscountAmt(product.getUnitPrice(), qty);
    }

    public final ReceiptDataAccessStrategy getDb() {
        return db;
    }

    public final void setDb(ReceiptDataAccessStrategy db) {
        this.db = db;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Must enter valid prod");
    }
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if( qty < 0){
            throw new IllegalArgumentException("Must enter valid  quantity");
    }
        this.qty = qty;
    }
    
    
}
