public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int n = x;
        int len = 0;
        while(n > 0){
            len++;
            n = n/10;
        }
        for(int i = 0; i < len/2; i++){
            int r =(int) (x/Math.pow(10,i)) % 10;
            int l = (int) (x/Math.pow(10,len-1-i))%10;
            if( l != r ) return false;
        }
        return true;
    }
}