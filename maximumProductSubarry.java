public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];
        for(int i = 1; i < nums.length;i++){
            int tmp = max_local;
            max_local = Math.max(Math.max(nums[i], max_local*nums[i]), min_local*nums[i]);  
            min_local = Math.min(Math.min(nums[i], tmp*nums[i]), min_local*nums[i]);
            global = Math.max(max_local, global);
        }
        return global;
    }
}