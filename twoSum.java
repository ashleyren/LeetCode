// 使用hashmap做
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!hs.containsKey(nums[i])){
                hs.put(target - nums[i],i+1);
            }else{
                res[0] = hs.get(nums[i]);
                res[1] = i+1;
                return res;
            }
        }
        return null;
    }
}
//更加简练的写法?
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
/*
第二种解法是先对数组进行排序，然后使用夹逼的方法找出满足条件的pair，原理是因为数组是有序的，
那么假设当前结果比target大，那么左端序号右移只会使两个数的和更大，反之亦然。
所以每次只会有一个选择，从而实现线性就可以求出结果。该算法的时间复杂度是O(nlogn+n)=O(nlogn)，空间复杂度取决于排序算法
*/
public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    if(numbers==null || numbers.length<2)
        return null;
    Arrays.sort(numbers);
    int l = 0;
    int r = numbers.length-1;
    while(l<r)
    {
        if(numbers[l]+numbers[r]==target)
        {
            res[0] = number[l];
            res[1] = number[r];
            return res;
        }
        else if(numbers[l]+numbers[r]>target)
        {
            r--;
        }
        else
        {
            l++;
        }
    }
    return null;
}