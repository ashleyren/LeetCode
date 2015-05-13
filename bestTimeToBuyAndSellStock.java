public class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length == 0){
           return 0;
       } 
       int local = 0;
       int global = 0;
       for(int i= 1; i< prices.length; i++){
           local = Math.max(local + prices[i] - prices[i-1],0);
           global = Math.max(local,global);
       }
       return global;
    }
}