package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    

    public PercentOffDiscount(double percentOff) {
        setPercentOff(percentOff);
        
    }
    
    @Override
    public final double getDiscountAmt(double unitCost, double qty){
        return unitCost * qty * percentOff;
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
   
}