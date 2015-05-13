public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0; 
        int r = nums.length - 1;
        int min = nums[0];
        while(l<=r){
            if(l==r){
                min = Math.min(nums[l],min);
                break;
            }
            int mid = (l+r)/2;
            if(nums[l] < nums[mid]){
                min = Math.min(nums[l],min);
                l = mid + 1;
            }else{
                min = Math.min(nums[mid+1],min);
                r = mid;
            }
        }
        return min;
    }
}