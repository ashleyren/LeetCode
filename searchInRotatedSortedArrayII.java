public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l+r)/2;
            if(target == nums[mid]) return true;
            if(nums[l] < nums[mid]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            } else if(nums[l] > nums[mid]){//这里的条件判断写错了！
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}