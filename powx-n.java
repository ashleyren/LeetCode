/*
用递归来解，把x的n次方划分成两个x的n/2次方相乘，然后递归求解子问题，因为是对n进行二分，算法是O(logn)。
需要注意的这个解法没有写边界判断.
*/
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

//code ganker的解法
/*
处理了很多边界情况，这也是数值计算题目比较麻烦的地方。
比如一开始为了能够求倒数，我们得判断倒数是否越界，后面在求指数的过程中我们也得检查有没有越界。所以一般来说求的时候都先转换为正数，
这样可以避免需要双向判断（就是根据符号做两种判断）
*/
public double pow(double x, int n) {
    if(n==0)
        return 1.0;
    double res = 1.0;   
    if(n<0)
    {
        if(x>=1.0/Double.MAX_VALUE||x<=1.0/-Double.MAX_VALUE)
            x = 1.0/x;
        else
            return Double.MAX_VALUE;
        if(n==Integer.MIN_VALUE)
        {
            res *= x;
            n++;
        }
    }
    n = Math.abs(n);
    boolean isNeg = false;
    if(n%2==1 && x<0)
    {
        isNeg = true;
    }
    x = Math.abs(x);
    while(n>0)
    {
        if((n&1) == 1)
        {
            if(res>Double.MAX_VALUE/x)
                return Double.MAX_VALUE;
            res *= x;
        }
        x *= x;
        n = n>>1;
    }
    return isNeg?-res:res;
}
