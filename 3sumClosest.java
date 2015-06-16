public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        int closest = Integer.MAX_VALUE;//min diff
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int tmp = helper(nums,i+1,target-nums[i]);
            if(Math.abs(tmp) < Math.abs(closest)){
                closest = tmp;
            }
        }
        return target + closest;
    }
    //数组从left开始,返回的是和target的最小差...
    private int helper(int[] nums, int left, int target){
        int right = nums.length - 1;
        int min_Diff = Integer.MAX_VALUE;
        while(left < right){
            int diff = nums[left] + nums[right] - target;
            if(Math.abs(diff) < Math.abs(min_Diff)){
                min_Diff = diff;
            }
            if(diff == 0){
                return 0;//没有差别
            }else if(diff > 0){
                right--;
            }else{
                left++;
            }
        }
        return min_Diff;
    }
}