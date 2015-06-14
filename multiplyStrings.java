/*
这道题!是这样的! 比如
385*97 那么个位(index 0) 是5*7(index 0+0)
十位(index1) 是8*7+5*9(index 1+0 和 0+1)
所以为了不溢出 我们采取按位计算.就是index 为x的 等于 num1 中index为x1 和num2中index x2相乘, 其中x= x1+ x2
为了方便进位我们从个位算起,于是先把两个string reverse了一下.
结果数组的最长是num1.length+ num2.length 因为试想99*99 < 100*100 = 10000五位.所以最多4位.
需要注意的是,最后要把开头前的0全部去掉.
*/

/*
这道题其实还有更加优的做法，就是用十大最牛的算法之一--Fast Fourier transform(FFT)。使用FFT可以在O(nlogn)时间内求出多项式的乘法，在这里只需要把变量x带入10，
然后按照求多项式的方法就可以求出两个大整数的成绩了。想了解细节的朋友搜一下快速傅里叶变换求多项式乘积就可以找到相关资料了，是比较成熟的算法。
*/

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int n = num1.length() + num2.length();
        int[] sums = new int[n];
        for(int i = 0 ; i < num1.length(); i++){
            int a = (int)(num1.charAt(i) - '0');
            for(int j = 0; j < num2.length(); j++){
                int b = (int)(num2.charAt(j) - '0');
                sums[i+j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < n; i++){
            int digit =  (sums[i] + carry)%10;
            carry = (sums[i] + carry)/10;
            sb.insert(0,digit);
        }
        if(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0":sb.toString();
    }
}

//code ganker这个厉害...开始都没有reverse 只用了一个num搞定所有.可以参考看看.
/*
一个是循环中最后有一个if判断，其实就是看最高一位是不是0（最高第二位不可能是0，除非两个源字符串最高位带有0），
如果是就不需要加入字符串中了。另一个小问题是我们是由低位到高位放入结果串的，所以最后要进行一次reverse，因为是一个O(m+n)的操作，不会影响算法复杂度。
*/
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length() + num2.length() ;i > 0; i--){
            for(int j = Math.min(i-1,num1.length()); j>0; j--){
                if(i-j <= num2.length()){
                    num += (int)(num1.charAt(j-1) - '0') * (int)(num2.charAt(i-j-1) - '0');
                }
            }
           
            if(i != 1 || num > 0){
               sb.append(num%10);
               num = num/10;
            }
            
        }
        return sb.reverse().toString();
    }
}