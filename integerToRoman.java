public class Solution {
    public String intToRoman(int num) {
        String s = "";
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while(num > 0){
            while(num >= nums[i]){
                num -= nums[i];
                s += symbol[i];
            }
            i++;
        }
        return s;
    }
}