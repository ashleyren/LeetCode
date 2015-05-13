public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i< n; i++){
            if(A[i] <= n && A[i] > 0 && A[i] != A[A[i] -1]){
                int temp = A[A[i]-1];  
                A[A[i]-1] = A[i];  
                A[i] = temp; 
                i--;
            }
        }
        int j = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != (i+1)) return i+1;
        }
        return n+1;
    }
}