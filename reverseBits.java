public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i = 0; i < 16; i++){
            n = swap(n, i, 31-i);
        }
        return n;
    }
    private int swap(int n, int i, int j){
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if( a != b){
            n ^= (1 << i) | (1 << j);
        }
        return n;
    }
}