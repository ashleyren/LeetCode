/*再一次做一遍，这是一道一维的动态规划题目，其实思想很简单，就是想来的时候如果前一步走1和前一步走2各是什么结果，总和就是结果。
值得注意的是，这里不需要用一个一位数组，因为每次就用前两位相加得到后面以为，每次只需要记录两个值就ok了，所以就用了两个变量。哈哈
还有经常会忘记就是一开始的初始的一些判断不要忘记哦。
*/
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i <= n; i++){
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return f2;
    }
}