// 解法一：就是动态规划，注意local啊指的是当前天卖出的结果，但是呢，当前天如果买入的话，就是0，所以
// local = Math.max(local + prices[i] - prices[i-1],0);

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
//解法二：就是最大的减去之前买入的最小的时候，于是维持一个min存储之前最小的，max为当前与之前min差值的最大。个人觉得第二种方法要简单一些。
//初始的时候，min为最大值。
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; //min price
        int global = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i],min);
            global = Math.max(prices[i] - min, global);
        }
        return global;
    }
}