public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = numbers.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<len;i++){
            if(map.isEmpty()){
                map.put(numbers[i],i+1);
            }else{
                Integer key = new Integer(target - numbers[i]);
                if(map.containsKey(key)){
                    result[0] = map.get(key).intValue();
                    result[1] = i+1;
                   
                }else if(!map.containsKey(new Integer(numbers[i]))){
                    map.put(numbers[i],i+1);
                }
            }
        }
       
        return result;
    }
}