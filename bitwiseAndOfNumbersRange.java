public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return m << i;
    }
}
//method 2
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         while(n > m){
             n = n & n - 1;
         }
         return m & n;
    }
}