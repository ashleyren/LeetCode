/*
这题目的关键在于 如何取到各个位然后进行比较.
如何取到?因为不是string所以不是很容易直接用charAt指定position.
那么就要使用除法来进行了.每个位数都代表了x*10^i次方.
使用这个来进行对称比较. 拿10为例子,首先要获取到长度len = 2
然后1 和 0 分别是10的1次方和 10的0次方,所以对称位的x和为len-1.
于是使用for循环,从for 0 开始 到len/2 不用考虑奇数中间那个.
取位数的时候先除以10的i次方,再模10 在转换成为int.就可以了
*/
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