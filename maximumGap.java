public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int n = nums.length;
        if(n == 2){
            return Math.abs(nums[0] - nums[1]);
        }
        int min = nums[0];
        int max = min;
        for(int i = 0; i < n; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] mins = new int[n - 1];
        int[] maxs = new int[n - 1];
        Arrays.fill(mins,Integer.MAX_VALUE);
        Arrays.fill(maxs,Integer.MIN_VALUE);
        for(int i = 0; i < n; i++){
            if(nums[i] == min || nums[i] == max) continue;
            int index  = (nums[i] - min)/gap;
            mins[index] = Math.min(nums[i],mins[index]);
            maxs[index] = Math.max(nums[i],maxs[index]);
        }
        int maxGap = 0;
        int pre = min;
        for(int i = 0; i < n - 1; i++){
            if(mins[i] == Integer.MAX_VALUE && maxs[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, mins[i] - pre);
            pre = maxs[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}