public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0 || A == null) return 0;
        int index = 1;
        for(int i = 1; i< A.length; i++){
            if(A[i-1] != A[i]){
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}