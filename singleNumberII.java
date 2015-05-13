public class Solution {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                digit[i] += (nums[j]>>i)&1;
            }
        }
        for(int i = 0; i < 32; i++){
            res += (digit[i]%3)<<i;
        }
        return res;
    }
}

//=====代码更好 才一次
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int[] digit = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                digit[i] += (nums[j] >> i) & 1;
                digit[i] %= 3;
            }
            res += digit[i] << i;
        }
        return res;
    }
}