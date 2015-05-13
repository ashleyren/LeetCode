public class Solution {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) return false;
        int local;
        int global = 0;
        for(int i = 0; i< A.length; i++){
            if(i>global) return false;//if can't get the i position...
            local = A[i] + i;
            global = Math.max(local,global);
        }
        
        if(global < A.length - 1) return false;
        return true;
    }
}