/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graszlandry.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Lexa Grasz and Jack Landry
 */
public class Years implements Serializable {
  private ArrayList<Integer> years;
  private ArrayList<Double> yearValue;
  
  public Years(){
    years = new ArrayList<Integer>();
     yearValue = new ArrayList<Double>();
    
  }
  
  public int getCount() {
    return years.size();
  }
  
  public void addUser(User user, Calculator calculator) {
    Double inputYear = user.getYears();
    
    //Double futureValue = user.getFutureValue();
    //Want to start i at 0 or 1?
    for (int i = 1; i < inputYear; i++) {
      years.add(i);
      user.setYears(i);
      yearValue.add(calculator.getFutureValue());
      
    }
    System.out.println(years);
    System.out.println(yearValue);
  }
  
}
