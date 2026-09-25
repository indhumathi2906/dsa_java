package Array_P3_ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    // Validates input array
    public boolean validateInput(int[] nums) {
        return nums != null && nums.length >= 2;
    }

    // Approach 1: Brute Force Nested Loop Search O(N^2) Time, O(1) Space
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

    // Approach 2: Sorting Adjacent Check O(N log N) Time, O(1) Space
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

    // Approach 3: Hash Set Lookup O(N) Time, O(N) Space
    public boolean containsDuplicateOptimal(int[] nums) {
        if (!validateInput(nums)) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // set.add() returns false if element already present in set
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Array_P3_ContainsDuplicate solver = new Array_P3_ContainsDuplicate();
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("==================================================");
        System.out.println("Problem 3: Contains Duplicate Test Suite");
        System.out.println("==================================================");
        System.out.println("Input 1: " + Arrays.toString(nums1));
        System.out.println("Brute Force: " + solver.containsDuplicateBruteForce(nums1));
        System.out.println("Sorting:     " + solver.containsDuplicateSorting(nums1));
        System.out.println("Hash Set:    " + solver.containsDuplicateOptimal(nums1));
        System.out.println("--------------------------------------------------");
        System.out.println("Input 2: " + Arrays.toString(nums2));
        System.out.println("Hash Set:    " + solver.containsDuplicateOptimal(nums2));
        System.out.println("==================================================");
    }
}
