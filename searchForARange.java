public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        if(A == null || A.length == 0) return res;
        int l1 = 0;
        int r1 = A.length-1;
        int l2 = 0;
        int r2 = A.length-1;
        
        while(l1<=r1){
            int mid = (l1+r1)/2;
            if(A[mid] < target){
                l1 = mid+1;
            }else{
                r1 = mid-1;
            }
        }
        while(l2<=r2){
            int mid = (l2+r2)/2;
            if(A[mid] <= target){
                l2 = mid+1;
            }else{
                r2 = mid-1;
            }
        }
        if(l1<=r2){
            res[0] = l1;
            res[1] = r2;
        }
        return res;
    }
}