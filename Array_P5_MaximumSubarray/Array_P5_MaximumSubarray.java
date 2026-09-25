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

    public int maxSubArrayDivideAndConquer(int[] nums) {
        if (!validateInput(nums)) return 0;
        return helperDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int helperDivideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;
        int leftMax = helperDivideAndConquer(nums, left, mid);
        int rightMax = helperDivideAndConquer(nums, mid + 1, right);
        int crossMax = maxCrossSubArray(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossSubArray(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}
