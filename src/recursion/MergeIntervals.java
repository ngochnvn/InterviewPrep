package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sort the array by the start
 * Add first to the merged interval
 * Iterate through the list and merge intervals:
 *   There are two case:
 *      start of new interval <= end of last merged interval -> set end of last merged to max of end
 *      start of new interval > end of last merged interval -> add new interval to merged.
 *
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMerged = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= lastMerged[1]) {
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                merged.add(new int[]{current[0], current[1]});
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
