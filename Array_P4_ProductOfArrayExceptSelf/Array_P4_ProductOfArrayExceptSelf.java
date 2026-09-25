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
}
