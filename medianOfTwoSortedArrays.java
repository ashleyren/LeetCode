public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((m+n)%2 == 1){
            return (double)helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2 + 1);
        }else{
            double x = helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2);
            double y = helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2 + 1);
            return (double)((x+y)/2);
        }
    }
    private int helper(int[] nums1, int astart, int aend,int[] nums2,int bstart, int bend, int k){
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        
        if(m > n){
            return helper(nums2, bstart, bend, nums1, astart, aend, k);
        }
        if(m == 0){
            return nums2[bstart+k-1];
        }
        if(k == 1){
            return Math.min(nums1[astart], nums2[bstart]);
        }
        int midA = Math.min(m,k/2);
        int midB = k - midA;
        if(nums1[astart+midA-1] == nums2[bstart+midB-1]){
            return nums1[astart+midA-1];
        }else if(nums1[astart+midA-1] < nums2[bstart+midB-1]){
            return helper(nums1,astart + midA, aend, nums2, bstart, bend, k-midA);
        }else{
            return helper(nums1, astart, aend, nums2, bstart+midB, bend, k-midB);
        }
    }
}