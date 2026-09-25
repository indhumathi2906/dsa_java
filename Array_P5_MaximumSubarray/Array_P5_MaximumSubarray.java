package Array_P5_MaximumSubarray;

/**
 * Array Problem 5: 53. Maximum Subarray (LeetCode #53)
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Description:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Time Complexity: Brute Force O(N^2), Divide & Conquer O(N log N), Kadane's Algorithm O(N)
 * Space Complexity: Brute Force O(1), Divide & Conquer O(log N) stack, Kadane's Algorithm O(1)
 */
public class Array_P5_MaximumSubarray {

    public boolean validateInput(int[] nums) {
        return nums != null && nums.length > 0;
    }

    public int maxSubArrayBruteForce(int[] nums) {
        if (!validateInput(nums)) return 0;
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
