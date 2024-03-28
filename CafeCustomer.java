/**
 * CafeCustomer class represents a customer in a cafe.
 */
public class CafeCustomer {
    /** Name of the customer */
    private String customerName; 
    /** Number of coffees ordered by the customer. */
    private int numOfCoffee;
    /** Indicates if the customer is a member or not. */ 
    private boolean isMember;
    /** Type of coffee ordered by the customer. */    
    private String coffeeType; 
    /** Tip given by the customer. */    
    private double tip;
    /** Tax rate applied to the total bill. */   
    private final double TAX = 0.11;  

    /**
     * Constructs a CafeCustomer object with default values.
     */
    public CafeCustomer() {
        this.customerName = "Customer";
        this.isMember = false;
        this.coffeeType = "None";
        this.numOfCoffee = 0;
    }

    /**
     * Constructs a CafeCustomer object with specified parameters.
     *
     * @param customerName The name of the customer.
     * @param numOfCoffee The number of coffees ordered by the customer.
     * @param isMember Indicates whether the customer is a member or not.
     * @param coffeeType The type of coffee ordered by the customer.
     */
    public CafeCustomer(String customerName, int numOfCoffee, boolean isMember, String coffeeType) {
        this.customerName = customerName;
        this.isMember = isMember;
        this.coffeeType = coffeeType;
        this.numOfCoffee = numOfCoffee;
    }
    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     * Sets the name of the customer.
     *
     * @param customerName The name of the customer.
     */
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    /**
     * Gets the type of coffee ordered by the customer.
     *
     * @return The type of coffee ordered by the customer.
     */
    public String getCoffeeType(){
        return this.coffeeType;
    }

    /**
     * Sets the type of coffee ordered by the customer.
     *
     * @param coffeeType The type of coffee ordered by the customer.
     */
    public void setCoffeeType(String coffeeType){
        this.coffeeType = coffeeType;
    }

    /**
     * Sets the tip given by the customer.
     *
     * @param tip The tip given by the customer.
     */
    public void setTip(double tip){
        this.tip = tip;
    }

    /**
     * Gets the membership status of the customer.
     *
     * @return True if the customer is a member, false otherwise.
     */
    public boolean getMembership(){
        return this.isMember;
    }

    /**
     * Sets the membership status of the customer.
     *
     * @param isMember True if the customer is a member, false otherwise.
     */
    public void setMembership(boolean isMember){
        this.isMember = isMember;
    }


        /**
     * Checks if the customer is a member.
     *
     * @return True if the customer is a member, false otherwise.
     */
    public boolean checkMembership(){
        if (this.isMember == true){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Calculates the price of the customer's coffee based on its type.
     *
     * @return The price of the customer's coffee.
     */
    public double customersCoffeePrice(){
        double coffeePrice = 0;
        if (this.coffeeType.equals("cappuccino")){
            coffeePrice = 4.99;
        } else if (this.coffeeType.equals("espresso")){
            coffeePrice = 3.99;
        } else if (this.coffeeType.equals("latte")){
            coffeePrice = 6.99;
        }

        return coffeePrice;
    }
    
    /**
     * Calculates the subtotal of the customer's bill.
     *
     * @return The subtotal of the customer's bill.
     */
    public double calcSubTotal(){
        return (customersCoffeePrice() * this.numOfCoffee);
    }

    /**
     * Calculates the total bill amount including tax and discounts.
     *
     * @return The total bill amount.
     */
    public double calcTotal(){      
        double discountedTotal = 0.8 * calcSubTotal();
        if (checkMembership() == true){
            return (discountedTotal + (discountedTotal * TAX));
        }
        else{
            return (calcSubTotal() + (calcSubTotal() * TAX));
        }
    }

    /**
     * Generates a formatted string representation of the customer's bill.
     *
     * @return A formatted string representing the customer's bill.
     */
    public String toString(){
        if(checkMembership() == true){
            String customerBill = String.format("\t Cafe Bill\n\nFor %s\n\n%d %s\t$%.2f\n\nSub-Total\t\t$%.2f\nDiscount\t\t\t$%.2f\nTip\t\t\t\t$%.2f\nTax 11%%\t\t\t$%.2f\nTotal\t\t\t\t$%.2f",this.customerName, this.numOfCoffee, this.coffeeType, customersCoffeePrice() * this.numOfCoffee, calcSubTotal(), 0.2 * calcSubTotal(), this.tip, calcSubTotal() * this.TAX, calcTotal() + this.tip);
            return customerBill;
        }
        String customerBill = String.format("\t Cafe Bill\n\nFor %s\n\n%d %s\t$%.2f\n\nSub-Total\t\t$%.2f\nDiscount\t\t\t$%.2f\nTip\t\t\t\t$%.2f\nTax 11%%\t\t\t$%.2f\nTotal\t\t\t\t$%.2f",this.customerName, this.numOfCoffee, this.coffeeType, customersCoffeePrice() * this.numOfCoffee, calcSubTotal(), 0.0 * calcSubTotal(), this.tip, calcSubTotal() * this.TAX, calcTotal() + this.tip);
        return customerBill;        
    }    

}