/*
Copyright Jack Landry and Lexa Grasz 2015
*/


package graszlandry.business;


import java.io.Serializable;
import java.text.NumberFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lexagrasz
 */
public class User implements Serializable {
    
    private double investment;
    private double interest;
    private double years;
    private double futureValue;
    
    public User() {
        investment = 0;
        interest = 0;
        years = 0;
        futureValue = 0;
        
    }
    
    public User(Double investment, Double interest, Double years) {
        this.investment = investment;
        this.interest = interest;
        this.years = years;
    }

    /**
     * @return the investment
     */
    public double getInvestment() {
        return investment;
    }
    
     public String getInvestmentCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currencyInvestment = currency.format(this.getInvestment());
        return currencyInvestment;
    }

    /**
     * @param investment the investment to set
     */
    public void setInvestment(double investment) {
        this.investment = investment;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the years
     */
    public double getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(double years) {
        this.years = years;
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
    
}
