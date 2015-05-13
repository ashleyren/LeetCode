public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) return res;
        helper(s,getDict(s),0,new ArrayList<String>(),res);
        return res;
    }
    private boolean[][] getDict(String s){
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--)// 这个顺序真的很重要。。。不能从前往后。。。
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j) && ((j-i<3)||dict[i+1][j-1]))
                {
                    dict[i][j] = true;
                }
            }
        }
        return dict;
    }
    private void helper(String s, boolean[][] dict, int l, ArrayList<String> item, ArrayList<ArrayList<String>> res){
        if(l == s.length()){
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i = l; i < s.length(); i++){
            if(dict[l][i]){
                item.add(s.substring(l,i+1));
                helper(s,dict,i+1,item,res);
                item.remove(item.size()-1);//这个是什么？？
            }
        }
    }
}