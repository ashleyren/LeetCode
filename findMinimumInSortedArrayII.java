public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            if(l == r){
                return Math.min(min, nums[l]);
            }
            int mid = (l+r)/2;
            if(nums[l] == nums[mid]){
                min = Math.min(min,nums[l]);
                l++;
            }else if(nums[l] < nums[mid]){
                min = Math.min(min,nums[l]);
                l = mid + 1;
            }else{
                min = Math.min(min,nums[mid+1]);
                r = mid;
            }
        }
        return min;
    }
}