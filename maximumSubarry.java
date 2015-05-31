/*
这里要注意的就是， 假设local[i]一定是包含nums[i]的，所以在去local最大的时候
local[i] = Math.max(nums[i], nums[i] + local[i-1]);理解了这个local[i]这个题目就迎刃而解了
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int global = nums[0];
        int local = nums[0];
        for(int i = 1; i < nums.length;i++){
            local = Math.max(local+nums[i],nums[i]);
            global = Math.max(global,local);
        }
        return global;
    }
}