/*
第一种最笨的方法，就是hashmap 存每个元素出现的次数，最后取出次数最多的 时间O(n) 空间 O(n)
第二种 排序 Arrays.sort()之后，取中间那个元素！绝壁是 time O(nlogn)
第三种 抵销法 假设一个结果，给它配置一个count，当当前元素和假设结果相等，count++
当当前元素和假设结果不相等，如果count不是0 count-1
如果count是0 假设结果变成当前。这样最后抵消完了 假设的结果就是真结果了 Runtime: O(n) space O(1)
*/
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
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == res){
                count++;
            }else{
                if(count == 0){
                    res = nums[i];
                }else{
                    count--;
                }
            }
        }
        return res;
    }
}