package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class Customer {
    
    private String custId;
    private String name;

    public Customer( String custId, String name) {
        setName(name);
        setCustId(custId);
    }
    
    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId) {
        if(custId == null){
            throw new IllegalArgumentException("Must enter valid customer id");
        }
        this.custId = custId;
    }
    
     public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Must enter valid name");
        }
        this.name = name;
    }
    
}
