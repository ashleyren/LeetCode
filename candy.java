public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(ratings == null || len == 0) return 0;
        int[] numbers = new int[len];
        numbers[0] = 1; 
        
        for(int i = 0; i< len -1 ; i++){
            if(ratings[i] < ratings[i+1]){
                numbers[i+1] = numbers[i] + 1;
            }else{
                numbers[i+1] = 1;
            }
        }
        numbers[len-1] = Math.max(numbers[len-1],1);
        int sum = numbers[len-1];
        for(int j = len - 1; j > 0; j--){
            int tmp = 1;
            if(ratings[j-1] > ratings[j]){
                tmp = numbers[j] + 1;
            }
            sum += Math.max(numbers[j-1],tmp);
            numbers[j-1] = Math.max(numbers[j-1],tmp);
            
        }
        return sum;
    }
}