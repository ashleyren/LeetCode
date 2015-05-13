public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append( (char)(n % 26 + 'A') );
            n = n/26;
        }
        sb.reverse();
        return sb.toString();
    }
}