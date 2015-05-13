public class Solution {
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0) return;
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i]){
            i--;
        }
        if(i == 0){
            reverse(num, 0);  
            return;
        }
        int j = i;
        while(j < num.length && num[j] > num[i-1] ){
            j++;
        }
        j--;
        int swap = num[j];
        num[j] = num[i-1];
        num[i-1] = swap;
        reverse(num,i);
    }
    private void reverse(int[] num,int start){
        int l = start;
        int r = num.length-1;
        while(l<r){
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}