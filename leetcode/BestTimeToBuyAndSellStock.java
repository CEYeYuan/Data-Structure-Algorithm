/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one
share of the stock), design an algorithm to find the maximum profit.
*/
/*
start with day 1, if the price goes down, it's a better time to buy,test if the profit grows

*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int min;
        int profit=0;
        min=prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}