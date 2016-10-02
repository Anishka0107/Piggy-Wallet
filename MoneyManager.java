
package piggywallet;

import java.time.LocalDate;

public class MoneyManager {
    private double currentbalance;
    public LocalDate initial;
    public int yrsspent;
    public double amtspenttot;

    public MoneyManager() {
        this.currentbalance = 0.0;
        this.initial = LocalDate.now();
        this.yrsspent = 0;
        this.amtspenttot = 0.0;
    }

    public double getCurrentBalance(){
        return currentbalance;
    }
    public void increase(double incr){
        currentbalance+=incr;
    }
    public void decrease(double decr){
        currentbalance-=decr;
    }
    public void updatedays(){
        LocalDate currentdate=LocalDate.now();
        this.yrsspent = currentdate.getYear()-initial.getYear();
    }
    
}
