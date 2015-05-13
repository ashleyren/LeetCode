public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int count = 0;
        int index = 1;
        for(int i = 1; i< A.length;i++){
            if(A[i] == A[i-1]){
                count++;
            }else{
                count = 0;
            }
            if(count <= 1){
                A[index] = A[i];
                index++;
            }
        }
        return index;
        
    }
}