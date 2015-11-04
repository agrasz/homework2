/*
 * Copyright Jack Landry and Lexa Grasz 2015
 */
package graszlandry.business;

/**
 * The Calculator class takes a user object and uses the formula for compounded 
 * interest to determine the total amount of money one will have after interest 
 * is added to their investment. 
 * @author Lexa Grasz and Jack Landry
 */
public class Calculator {
    
    private Double futureValue;
    
/**
 * 
 * @param user
 * @return futureValue 
 * 
 * This calculate class uses the parameter of a User object to get the 
 * investment amount, the interest rate, and the number of years the to compound 
 * interest for. This class returns the future value of the original investment
 * with the addition of the compounded interest. 
 * 
 */
    public Double calculate(User user) {
        Double investment = user.getInvestment();
        Double interest = user.getInterest()/100;
        Double years = user.getYears();
        Double a = (1 + interest);
        Double b = years;        
        futureValue = investment*Math.pow(a, b);
        
        return futureValue;
    }
    
    /**
     * @return the futureValue
     * This is a getter method for the futureValue double.
     */
    public double getFutureValue() {
        return futureValue;
    }

    /**
     * @param futureValue 
     * This sets the value of the futureValue double.
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }
    
}
