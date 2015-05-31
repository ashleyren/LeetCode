/*
这一题同样是动态规划一维的，和maximumSubarray的区别在于，这里是有负数的，
所以就每次要存下最小的因为最小的（负数）有可能在下一次的乘积负负得正,成为最大的结果。
这里要注意的是呢，要提前把max_local存为tmp，因为在第一次计算的时候，max_local的值已经刷新了。
*/
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = max_local;
            max_local = Math.max(nums[i], Math.max(nums[i]*max_local, nums[i]*min_local));
            min_local = Math.min(nums[i], Math.min(nums[i]*tmp, nums[i]*min_local));
            global = Math.max(max_local, global);
        }
        return global;
    }
}