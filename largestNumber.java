public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}