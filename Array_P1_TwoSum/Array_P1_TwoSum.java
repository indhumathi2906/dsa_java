package Array_P1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Array Problem 1: 1. Two Sum (LeetCode #1)
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Time Complexity: Brute Force O(N^2), Two Pointers O(N log N), Hash Map O(N)
 * Space Complexity: Brute Force O(1), Two Pointers O(N), Hash Map O(N)
 */
public class Array_P1_TwoSum {

    // Validates input boundaries to ensure non-null and at least 2 elements
    public boolean validateInput(int[] nums) {
        return nums != null && nums.length >= 2;
    }

    // Approach 1: Brute Force O(N^2) Time, O(1) Space
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (!validateInput(nums)) return new int[0];
        int n = nums.length;
        // Check all unique pairs (i, j) where j > i
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // Approach 2: Sorting & Two Pointers O(N log N) Time, O(N) Space
    public int[] twoSumTwoPointer(int[] nums, int target) {
        if (!validateInput(nums)) return new int[0];
        int n = nums.length;
        // Store value and original index pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        // Sort based on array values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) {
                return new int[]{pairs[left][1], pairs[right][1]};
            } else if (sum < target) {
                left++; // Increment left pointer to increase sum
            } else {
                right--; // Decrement right pointer to decrease sum
            }
        }
        return new int[0];
    }

    // Approach 3: Hash Map (Single Pass) O(N) Time, O(N) Space
    public int[] twoSumOptimal(int[] nums, int target) {
        if (!validateInput(nums)) return new int[0];
        // Map stores value -> original index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If complement exists in map, return indices pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Array_P1_TwoSum solver = new Array_P1_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("==================================================");
        System.out.println("Problem 1: Two Sum Test Suite");
        System.out.println("==================================================");
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Brute Force Result:     " + Arrays.toString(solver.twoSumBruteForce(nums, target)));
        System.out.println("Two Pointers Result:    " + Arrays.toString(solver.twoSumTwoPointer(nums, target)));
        System.out.println("Optimal Hash Map Result:" + Arrays.toString(solver.twoSumOptimal(nums, target)));
        System.out.println("==================================================");
    }
}
