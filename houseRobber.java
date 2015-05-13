public class Solution {
    public int rob(int[] num) {
        int n = num.length;
        if(n == 0) return 0;
        if(n == 1) return num[0];
        int[] global = new int[n];
        global[0] = num[0];
        global[1] = Math.max(num[0],num[1]);
        for(int i = 2; i < n; i++){
            global[i] = Math.max(num[i] + global[i-2], global[i-1]);
        }
        return global[n-1];
    }
}

public class Solution {
    public int rob(int[] nums) {
        int oddPos = 0;
        int evenPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                evenPos += nums[i];
                evenPos = Math.max(evenPos, oddPos);
            }else{
                oddPos += nums[i];
                oddPos = Math.max(evenPos,oddPos);
            }
        }
        return Math.max(evenPos,oddPos);
    }
}