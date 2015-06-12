//这一题的关键是hashset
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        int res = 1;
        for(int i : nums){
            set.add(i);
        }
        for(int i : nums){
            int count = 1;
            int left = i - 1;
            int right = i + 1;
            set.remove(i);
            while(set.contains(left)){
                set.remove(left);
                left--;
                count++;
            }
            while(set.contains(right)){
                set.remove(right);
                right++;
                count++;
            }
            if(count > res){
                res = count;
            }
        }
        return res;
    }
}