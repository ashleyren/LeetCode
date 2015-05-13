public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length -3; i++){
            if(i != 0 && nums[i] == nums[i-1]){ //这个千万不要忘记 因为前面有很多重复的话 就会超时。
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    left++;
                    right--;
                    if(!set.contains(tmp)){
                        set.add(tmp);
                        res.add(tmp);
                        while(left < right && nums[left-1] == nums[left]){
                            left++;
                        }
                        while(left < right && nums[right+1] == nums[right]){
                            right--;
                        }
                    }
                }else if(sum < 0){
                    left++;   
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}