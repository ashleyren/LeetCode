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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null) return res;
        int size = intervals.size();
        if(size == 0 || size == 1) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        Interval a = intervals.get(0);
        for(int i = 1; i < size; i++){
            Interval b = intervals.get(i);
            if(a.end >= b.start){
                a = new Interval(Math.min(a.start,b.start),Math.max(a.end,b.end));
            } else{
                res.add(a);
                a = b;
            }
        }
        res.add(a);
        return res;
    }

}
public  class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}  
