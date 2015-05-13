public class Solution {
    public int mySqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        int l = 1;
        int r = x/2 + 1;
        while(l<=r){
            int m = (l+r)/2;
            if(m == x/m) return m;
            if(m < x/m){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return r;
    }
}