public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[r]){
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(target < nums[mid] && target >= nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}