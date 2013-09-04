public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slow = 0;
        int fast = 0;
        int len = A.length;
        while(fast < len){
            if(A[fast] != elem){
                A[slow] = A[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
        
    }
}