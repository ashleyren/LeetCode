public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                int j = map.get(target-numbers[i]);
                i++;
                result[0] = (i < j) ? i : j;
                result[1] = (i > j) ? i : j;
                return result;
            }
        }
        return result;
        
        
        
    }
}