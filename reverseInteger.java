/*
哈哈哈哈 这道题,想想其实听厉害的.完全用的数学方法就reverse了 和string什么的没什么关系都.
主要是while循环的条件想好.开始写成x>0 不对是因为要考虑到负数的问题.最后要判断越界返回0.否则就返回结果int类型.
*/
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;//判断越界的,所以开始才把res定为long类型
        return (int)res;
    }
}

//都用int的方法
public int reverse(int x) {
    if(x==Integer.MIN_VALUE)
        return 0;
    int num = Math.abs(x);
    int res = 0;
    while(num!=0)
    {
        if(res>(Integer.MAX_VALUE-num%10)/10)
            return 0;
        res = res*10+num%10;
        num /= 10;
    }
    return x>0?res:-res;
}