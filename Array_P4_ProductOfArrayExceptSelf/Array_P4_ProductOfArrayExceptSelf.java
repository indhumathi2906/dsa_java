package Array_P4_ProductOfArrayExceptSelf;

/**
 * Array Problem 4: 238. Product of Array Except Self (LeetCode #238)
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Description:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * You must write an algorithm that runs in O(N) time and without using the division operation.
 *
 * Time Complexity: Brute Force O(N^2), Prefix/Suffix O(N), Optimal Space O(N)
 * Space Complexity: Brute Force O(1) auxiliary, Prefix/Suffix O(N), Optimal Space O(1) auxiliary
 */
public class Array_P4_ProductOfArrayExceptSelf {

    public boolean validateInput(int[] nums) {
        return nums != null && nums.length >= 2;
    }

    public int[] productExceptSelfBruteForce(int[] nums) {
        if (!validateInput(nums)) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
}
