package Array_P3_ContainsDuplicate;

import java.util.Arrays;

/**
 * Array Problem 3: 217. Contains Duplicate (LeetCode #217)
 * Link: https://leetcode.com/problems/contains-duplicate/
 *
 * Description:
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Time Complexity: Brute Force O(N^2), Sorting O(N log N), Hash Set O(N)
 * Space Complexity: Brute Force O(1), Sorting O(1) auxiliary, Hash Set O(N)
 */
public class Array_P3_ContainsDuplicate {

    public boolean validateInput(int[] nums) {
        return nums != null && nums.length >= 2;
    }

    public boolean containsDuplicateBruteForce(int[] nums) {
        if (!validateInput(nums)) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateSorting(int[] nums) {
        if (!validateInput(nums)) return false;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
