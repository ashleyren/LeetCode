public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int size = 1; size <= nums.length; size++){
            helper(nums, 0, size, new ArrayList<Integer>(), res);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    private void helper(int[] nums, int start, int size, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(item.size() == size){
            if(!res.contains(item)){
                res.add(new ArrayList<Integer>(item));
            }
            return;
        }
        if(start >= nums.length) return;
        for(int i = start; i < nums.length; i++){
            item.add(nums[i]);
            helper(nums, i+1, size, item, res);
            item.remove(item.size()-1);
        }
    }
}