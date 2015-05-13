public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        res.add("");
        for(int i = 0 ; i< digits.length();i++){
            String letters = getLetters(digits.charAt(i));
            ArrayList<String> cur = new ArrayList<String>();
            for(int j = 0; j < res.size();j++){
                for(int k = 0; k< letters.length();k++){
                    cur.add(res.get(j) + String.valueOf(letters.charAt(k)));//char convert to string is String.valueOf(char)
                }
            }
            res = cur;
        }
        return res;
    }
    private String getLetters(char c){
        switch(c){
            case '1':
                return "";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}