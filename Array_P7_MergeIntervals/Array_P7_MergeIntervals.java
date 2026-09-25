package Array_P7_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array Problem 7: 56. Merge Intervals (LeetCode #56)
 * Link: https://leetcode.com/problems/merge-intervals/
 *
 * Description:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Time Complexity: Brute Force O(N^2), Sorting + List O(N log N), Optimal Array Conversion O(N log N)
 * Space Complexity: Brute Force O(N), Sorting + List O(N), Optimal Array Conversion O(N)
 */
public class Array_P7_MergeIntervals {

    // Validates input intervals array
    public boolean validateIntervals(int[][] intervals) {
        return intervals != null && intervals.length > 0;
    }

    // Approach 1: Naive Overlap Scan O(N^2) Time, O(N) Space
    public int[][] mergeBruteForce(int[][] intervals) {
        if (!validateIntervals(intervals)) return new int[0][0];
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        boolean[] merged = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged[i]) continue;
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = i + 1; j < n; j++) {
                if (!merged[j] && intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                    merged[j] = true;
                }
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }

    // Approach 2: Sorting + ArrayList Accumulation O(N log N) Time, O(N) Space
    public int[][] mergeSortingList(int[][] intervals) {
        if (!validateIntervals(intervals)) return new int[0][0];
        // Sort intervals by start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If list is empty or current interval doesn't overlap with previous
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap exists: update end time of previous interval
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // Approach 3: Optimal In-Place Array Formatting O(N log N) Time, O(N) Space
    public int[][] mergeOptimal(int[][] intervals) {
        if (!validateIntervals(intervals)) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int index = 0; // Pointer to current position in merged output

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                // Overlapping condition: merge with intervals[index]
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }

    public static void main(String[] args) {
        Array_P7_MergeIntervals solver = new Array_P7_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println("Problem 7: Merge Intervals Test Suite");
        System.out.println("Input Intervals: " + Arrays.deepToString(intervals));
        System.out.println("Brute Force Result:   " + Arrays.deepToString(solver.mergeBruteForce(intervals)));
        System.out.println("Sorting List Result:  " + Arrays.deepToString(solver.mergeSortingList(intervals)));
        System.out.println("Optimal Array Result: " + Arrays.deepToString(solver.mergeOptimal(intervals)));
    }
}
