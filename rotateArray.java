public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        int x = k % nums.length;
        swap(nums, 0, nums.length-1-x);
        swap(nums, nums.length-x, nums.length-1);
        swap(nums, 0, nums.length-1);
    }
    private void swap(int[] nums, int l, int r){
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}