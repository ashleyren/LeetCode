public class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            return 1 / pow(x,-n);
        }else{
            return pow(x,n);
        }
    }
    private double pow(double x, int n){
        if(n == 0) return 1.0;
        double v = pow(x,n/2);
        if(n % 2 == 1){
            return v*v*x;
        }else{
            return v*v;
        }
    }
}