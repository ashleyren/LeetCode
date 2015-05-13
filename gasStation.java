public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0|| cost == null || cost.length == 0) return -1;
        int sum = 0;//sum of a small loop
        int index = -1;
        int total = 0;//global total
        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if(sum < 0){
                sum = 0;
                index = i;
            }
        }
        if(total < 0){
            index = -1;
        } else{
            index++;
        }
        return index;
    }
}