/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res  = new ArrayList<Interval>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        
        int i = 0;
        while(i < intervals.size() && newInterval.start > intervals.get(i).end){
           res.add(intervals.get(i));
           i++;
        }
        if(i < intervals.size()){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        }
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        return res;
        
    }
}