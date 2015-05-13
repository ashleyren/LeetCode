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
public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem){
                A[len] = A[i];
                len++;
            }
        }
        return len;
    }
}
//这两个写法其实是一样的 没区别 第二次写的我觉得更好懂一些。