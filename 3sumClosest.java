public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2] - target;
        for(int i = 0; i <= nums.length-3; i++){
            int tmp = helper(nums,target - nums[i], i+1);
            if(Math.abs(tmp) < Math.abs(closest)){
                closest = tmp;
            }
        }
        return closest+target;
    }
    
    private int helper(int[] nums, int target, int left){
        int right = nums.length -1;
        int closest = nums[left] + nums[right] - target;
        while(left < right){
            int tmp = nums[left] + nums[right] - target;
            if(tmp == 0){
                return 0;
            }
            if(Math.abs(tmp) < Math.abs(closest)){
                closest = tmp;
            }
            if(tmp > 0){
                right--;
            }else{
                left++;
            }
        }
        return closest;
    }
}