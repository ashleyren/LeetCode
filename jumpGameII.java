public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) return 0;
        int max = 0;
        int step = 0;
        int last = 0;
        for(int i=0; i<=max && i< A.length;i++){
            if(i > last){
                last = max;
                step++;
            }
            max = Math.max(max,A[i]+i);
        }
        if(max < A.length - 1) return 0;
        return step;
    }
}