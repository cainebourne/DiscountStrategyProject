package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public interface DiscountStrategy {

    public abstract double getDiscountAmt(double unitCost, double qty);
    
}