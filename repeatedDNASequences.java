public class Solution {
    public ArrayList<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<String>();
        HashSet<String> dna = new HashSet<String>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 9; i < s.length(); i++){
            String tmp = s.substring(i-9,i+1);
            int code = encode(tmp);
            if(hs.contains(code)){
                if(!dna.contains(tmp)){
                    dna.add(tmp);
                }
            }else{
                hs.add(code);
            }
        }
        for(String d : dna){
            res.add(d);
        }
        return res;
    }
    private int encode(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'A'){
                code = code * 4;
            }else if(str.charAt(i) == 'C'){
                code = code * 4 + 1;
            }else if(str.charAt(i) == 'G'){
                code = code * 4 + 2;
            }else{
                code = code * 4 + 3;
            }
        }
        return code;
    }
}