/*
int 是整数类型 MAX_VALUE 是2的32次方-1， MIN_VALUE是负的2的32次方
long 也属于整数类型，在存储的时候，用8个字节存储，64位 MAX_VALUE 是2的64次方-1， MIN_VALUE是负的2的64次方
在变量初始化的时候，long类型的默认值为0L或0l，也可直接写为0
其他补充的: 
byte: 八位整数 -128——127，可用来节省内存的使用。
short: 16位整数 -32768——32,767，也比较省内存。
float: 32位浮点，如果浮点需要节省内存用这个。
Double: 64位浮点，一般非整数浮点可用这个。
记住float和double都不是精确的，如果要储存钱一类的必须精确的，用java.math.BigDecimal

好了，有了以上的前提之后，就知道为什么要使用long了，因为32位的int在位运算左移的时候，会超出范围。
当然Math.abs最Integer的范围也是会有一些更改，于是先转换成为long然后再取绝对值。
思路是：a >= b的时候, 就减掉这个b, 然后把b左移1位相当于2b, count也左移变成2,再进行减这个运算,当一直到a>=tmp(b移位之后的结果)
其中res结果就一直+count, a一直-tmp
最后符号的判断用了异或,不同的时候异或的值为1,就加上符号
还有一点重要的结果与Integer边界的判断,如果超过边界了 一律返回Integer.MAX_VALUE;
否则转换成int返回.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long res = 0;
        while(a >= b){
            for(long tmp = b, count = 1; a>=tmp; tmp<<=1, count<<=1){
                res += count;
                a -= tmp;
            }
        }
        res = (((dividend ^ divisor) >> 31) & 1) == 1 ? -res : res;
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)res;
        
    }
}