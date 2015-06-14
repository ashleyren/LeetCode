/*
word ladder 的题目真的很经典，是BFS的变种啊~~~~
寻找BFS最短路径，取得当前的word，对当前word的每一位都从a到z的替换，如果，在字典里面，就把他入队，
为了避免环路，把入队的词从字典里面删除。一旦找到一个单词和endWord相等，就返回len+1；
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || 
        beginWord.length() != endWord.length() || wordDict.isEmpty()) return 0;
        LinkedList<String> q = new LinkedList<String>();
        q.add(beginWord);
        int len = 1;
        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i < count; i++){
                String cur = q.poll();
                for(int j = 0 ; j < cur.length(); j++){
                  for(char c = 'a'; c<= 'z'; c++){
                        if(c == cur.charAt(j)){
                            continue;
                        }
                        String tmp = replace(cur,j,c);
                        if(tmp.equals(endWord)) return len+1;
                        if(wordDict.contains(tmp)){
                            wordDict.remove(tmp);//防止环路
                            q.add(tmp);//下一层的准备
                        }
                    }
                }
            }
            len++;//这里指的是同一层的点都进行的变换匹配之后，len集体加1，注意啊一次q的弹完就代表同一层。
        }
        return 0;
    }
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);// 这个地方要注意，不能使用toString了要使用new String() 或者是 String.valueOf(chars)
    }
}

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null || 
        start.length() == 0 || end.length() == 0 || start.length() != end.length()) return 0;
        LinkedList<String> q = new LinkedList<String>();
        int len = 1;
        int count = 1;
        int nextCount = 0;
        q.add(start);
        while(!q.isEmpty()){
            String word = q.poll();
            count--;
            for(int i = 0; i < word.length();i++){
                char[] wordUnit = word.toCharArray();
                for(char j = 'a';j <= 'z';j++){
                    wordUnit[i] = j;
                    String tmp = new String(wordUnit);
                    if(tmp.equals(end)) return len+1;
                    if(dict.contains(tmp)){
                        q.add(tmp);
                        nextCount++;
                        dict.remove(tmp);
                    }
                }
            }
            
            if(count == 0){
                count = nextCount;
                nextCount = 0;
                len++;
            }
        }
        return 0;
    }
}