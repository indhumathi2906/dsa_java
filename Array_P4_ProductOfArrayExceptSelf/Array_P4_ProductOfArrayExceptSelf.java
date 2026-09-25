package Array_P4_ProductOfArrayExceptSelf;

import java.util.Arrays;

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

    // Validates input array
    public boolean validateInput(int[] nums) {
        return nums != null && nums.length >= 2;
    }

    // Approach 1: Brute Force Nested Product O(N^2) Time, O(1) Space
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

    // Approach 2: Prefix and Suffix Arrays O(N) Time, O(N) Auxiliary Space
    public int[] productExceptSelfPrefixSuffix(int[] nums) {
        if (!validateInput(nums)) return new int[0];
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    // Approach 3: Optimal Single Output Array Accumulation O(N) Time, O(1) Auxiliary Space
    public int[] productExceptSelfOptimal(int[] nums) {
        if (!validateInput(nums)) return new int[0];
        int n = nums.length;
        int[] res = new int[n];

        // Pass 1: Compute prefix products directly into output array
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Pass 2: Accumulate suffix products backwards using a single variable
        int rightMultiplier = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightMultiplier;
            rightMultiplier *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Array_P4_ProductOfArrayExceptSelf solver = new Array_P4_ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};

        System.out.println("==================================================");
        System.out.println("Problem 4: Product of Array Except Self Suite");
        System.out.println("==================================================");
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Brute Force Result:     " + Arrays.toString(solver.productExceptSelfBruteForce(nums)));
        System.out.println("Prefix/Suffix Result:   " + Arrays.toString(solver.productExceptSelfPrefixSuffix(nums)));
        System.out.println("Optimal Space Result:   " + Arrays.toString(solver.productExceptSelfOptimal(nums)));
        System.out.println("==================================================");
    }
}
