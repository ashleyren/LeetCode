public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-4; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
                for(int j = i+1; j <= nums.length-3; j++){
                    if(j != i+1 && nums[j] == nums[j-1]){
                        continue;
                    }
                    
                        int left = j+1;
                        int right = nums.length-1;
                        while(left < right){
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if(sum == target){
                                ArrayList<Integer> cur = new ArrayList<Integer>();
                                cur.add(nums[i]);
                                cur.add(nums[j]);
                                cur.add(nums[left]);
                                cur.add(nums[right]);
                                if(!set.contains(cur)){
                                    res.add(cur);
                                    set.add(cur);
                                }
                                left++;
                                right--;
                                while(left < right && nums[left] == nums[left-1]){
                                    left++;
                                }
                                while(left < right && nums[right] == nums[right+1]){
                                    right--;
                                }
                            }else if(sum < target){
                                left++;
                            }else{
                                right--;
                            }
                        }  
                 }  
        }
        return res;
    }
}