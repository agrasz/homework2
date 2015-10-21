/*
 * Copyright Jack Landry and Lexa Grasz 2015
 */
package graszlandry.business;

import java.text.NumberFormat;

/**
 *
 * @author lexagrasz
 */
public class Calculator {
    
    private Double futureValue;
    
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
     */
    public double getFutureValue() {
        return futureValue;
    }

    /**
     * @param futureValue the futureValue to set
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }
    
    
    
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String total = currency.format(this.getFutureValue());
        return total;
    }
}
