public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i])){
                map.put(num[i],map.get(num[i])+1);
            }else{
                map.put(num[i],1);
            }
        }
        for(int item: map.keySet()){
            if(map.get(item) > num.length/2){
                return item;
            }
        }
        return -1;
    }

}