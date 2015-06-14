/*
1.比较直接的想法是用一个HashMap对于出现的元素进行统计，key是元素，value是出现个数，如果元素出现三次，则从HashMap中移除.
2.上述方法的空间消耗是hashmap，和题目要求的O(1)相差。所以想到了用位运算的方法。
三个相等的数那么按位加法，每一位肯定是3的倍数。模3之后，得到说，那个剩下的肯定就是落单的数了。
*/
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
                digit[i] += (nums[j] >> i) & 1;//这里的&1代表保留i位上的1 其他的都不要不要了。
                digit[i] %= 3;
            }
            res += digit[i] << i;
        }
        return res;
    }
}