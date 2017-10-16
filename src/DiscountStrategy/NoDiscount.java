package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class NoDiscount implements DiscountStrategy {

    

    public NoDiscount() {

    }
    
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
        
        return 0;
        
        //return qty <= minQty ? unitCost * qty * percentOff : 0;
    }

    
    
    
}
