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