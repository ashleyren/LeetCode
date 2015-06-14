//使用二分法,左界限,右界限,取中位数的平方和x相比较,然后再判断是在左半边还是右半边.
//注意开始x为负数的事后要判断,这里返回了-1.
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
//改进?一点点
public int mySqrt(int x) {
    if(x < 0) return -1;
    if(x == 0) return x;
    int l = 1;
    int r = x/2+1;
    while(l <= r){
       int m = (l+r)/2;
       if(x/m >= m && x/(m+1) < (m+1)) return m;// 唯一的区别在这里,和上一个解法.
       if(x/m > m){
           l = m + 1;
       }else{
           r = m - 1;
       }
    }
    return 0;
}

//牛顿迭代法
/*
f(y)=y^2-x，其中x是我们要求平方根的数，
那么当f(y)=0时，即y^2-x=0,所以y=sqrt(x),即是我们要求的平方根。f(y)的导数f'(y)=2*y
根据牛顿法的迭代公式我们可以得到y_(n+1)=y_n-f(n)/f'(n)=(y_n+x/y_n)/2 
f(n) = y^2-x , f'(n) = 2y
*/
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        double lastY = 0;//这个初始值只要和y不一样就行,因为是要得到y和y自己收敛的结果一样就好.
        double y = 1;
        while(y != lastY){
            lastY = y;
            y = (y+x/y)/2;
        }
        return (int)y;
    }
}