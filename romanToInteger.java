/*
还是对罗马数字的熟悉和罗马数字的规则
I V X L C D M 分别对应了 1 5 10 50 100 500 1000
左加右减 而且减只跨越两个数的层次
swtich case 语句别写错
*/

public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i < s.length() - 1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                        sum -= 1;
                    }else{
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i < s.length() - 1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                        sum -= 10;
                    }else{
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if(i < s.length() - 1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                        sum -= 100;
                    }else{
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return sum;
    }
}