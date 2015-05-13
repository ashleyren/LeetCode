public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        while(true){
            int cur = n%10;
            n = n/10;
            res += cur*cur;
            if(n == 0){
                if(res == 1){
                    return true;
                }else{
                    n = res;
                    res = 0;
                }
                if(!set.contains(n)){
                    set.add(n);
                }else{
                    return false;
                }
            }
        }
    }
}