public class Solution {
    public boolean isPalindrome(String s) {
       if(s == null || s.length() == 0) return true;
       int l = 0;
       int r = s.length() - 1;
       while(l<r){
           if(!isValid(s.charAt(l))){
               l++;
               continue;
           }
           if(!isValid(s.charAt(r))){
               r--;
               continue;
           }
           if(!isSame(s.charAt(l),s.charAt(r))){
               return false;
           }
           l++;
           r--;
       }
       return true;
    }
    private boolean isValid(char c){
        if((c>='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9')) return true;
        return false;
    }
    
    private boolean isSame(char c1, char c2){
        if(c1>='A'&&c1<='Z'){
            c1 = (char)(c1-'A'+'a');
        }
        if(c2>='A'&&c2<='Z'){
            c2 = (char)(c2-'A'+'a');
        }
        return c1==c2;
    }
}
/*这个题目有以下几点要注意：1思路很简单，从第一个与最后一个比较，往中间逼近 
2 判断当前字符是不是有效？有效则比较，无效指针移动就可以 3.判断两个字符是不是相当的要考虑到，
是忽略大小写的，所以要写一个isSame()来判断，那么转换的时候要注意啦 c1 = (char)(c1-'A'+'a');这里要强制类型转换的
4 极端情况 当s为空的时候返回true还是false？
5.还有while里面判断完，里面没有返回值代表一切顺利，外面是要返回true的
*/