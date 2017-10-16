package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class QtyPercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    private double minQty;
    

    public QtyPercentOffDiscount(double percentOff, double minQty) {
        setPercentOff(percentOff);
        setMinQty(minQty);
    }
    
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
        double discountAmt = 0;
        
        if(qty >= minQty){
          discountAmt = unitCost * qty * percentOff;  
        }
        return discountAmt;
        
        //return qty <= minQty ? unitCost * qty * percentOff : 0;
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        if(percentOff < 0){
            throw new IllegalArgumentException("Must enter valid percentage");
        }
        this.percentOff = percentOff;
    }

    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        if(minQty < 0){
            throw new IllegalArgumentException("Must enter valid minimum quantity");
        }
        this.minQty = minQty;
    }
    
    
    
}
