//这题是一维动态规划，简单的就是开始想到的用一维数组想出来。
public int numDecodings(String s){
    if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    int n = s.length();
    int res[] = new int[n+1];
    res[0] = 1;//????????????? 为啥为啥是1？？？？设想如果是10.那么 res[2] = (res[0]+ isvalid) = 1;所以res[0] = 1
    if(isVaild(s.substring(0,1))){
        res[1] = 1;
    }else{
        res[1] = 0;
    }
    for(int i = 2; i <= n; i++){
        if(isVaild(s.substring(i-1,i))){
            res[i] += res[i-1];
        }
        if(isVaild(s.substring(i-2,i))){
            res[i] += res[i-2];
        }
    }
    return res[n];
}

private boolean isVaild(String s){
    if(s.charAt(0) == '0') return false;
    int num = Integer.parseInt(s);
    if(num <= 26 && num >=1) return true;
    return false;
}


//然后进一步其实还可以简化的，那就是可以不用一位数组，这里和decode ways那一题很相似，使用两个量存前两个的值，然后再获得当前的结果。
//这里和上面稍微不同的就是它直接判断了charAt(i)这一位的。要分各种情况来弄。其实按照上面那个也可以。
//是这样的
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int f0 = 1;
        int f1 = 0;

        if(isValid(s.substring(0,1))){
            f1 = 1;
        }else{
            f1 = 0;
        }
        for(int i = 2; i <= s.length(); i++){
            int f2 = 0;//注意这里哦，f2是一个临时的量，不是全局的。
            if(isValid(s.substring(i-1,i))){
                f2 += f1;
            }
            if(isValid(s.substring(i-2,i))){
                f2 += f0;
            }
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
    private boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        if(num <= 26 && num >= 1) return true;
        return false;
    }
}


//解法3
public class Solution {
    public int numDecodings(String s) {
        if(s == null||s.length() == 0||s.charAt(0)=='0'){
            return 0;
        }
        int num1 = 1;
        int num2 = 1;
        int num3 = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    num3 = num1;
                }else{
                    return 0;
                }
            }else{
                if(s.charAt(i-1) == '0' || s.charAt(i-1) >= '3'){
                    num3 = num2;
                }else{
                    if(s.charAt(i-1) == '2'&& s.charAt(i) >= '7'){
                        num3 = num2;
                    }else{
                        num3 = num2 + num1;
                    }
                }
            }
            
            num1 = num2;
            num2 = num3;
        }
        return num2;
    }
}