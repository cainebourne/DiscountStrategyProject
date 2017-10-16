package DiscountStrategy;
/**
 *
 * @author Cainebourne
 */
public class Customer {
    private String name;
    private String custId;

    public Customer(String name, String custId) {
        setName(name);
        setCustId(custId);
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

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId) {
        if(custId == null){
            throw new IllegalArgumentException("Must enter valid customer id");
        }
        this.custId = custId;
    }
    
    
}
