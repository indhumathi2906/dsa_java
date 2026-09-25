package Array_P6_ContainerWithMostWater;

import java.util.Arrays;

/**
 * Array Problem 6: 11. Container With Most Water (LeetCode #11)
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Description:
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the i-th line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Time Complexity: Brute Force O(N^2), Two Pointers O(N), Optimized Two Pointers O(N)
 * Space Complexity: Brute Force O(1), Two Pointers O(1), Optimized Two Pointers O(1)
 */
public class Array_P6_ContainerWithMostWater {

    public boolean validateHeight(int[] height) {
        return height != null && height.length >= 2;
    }

    public int maxAreaBruteForce(int[] height) {
        if (!validateHeight(height)) return 0;
        int maxArea = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                maxArea = Math.max(maxArea, h * w);
            }
        }
        return maxArea;
    }

    public int maxAreaTwoPointers(int[] height) {
        if (!validateHeight(height)) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public int maxAreaOptimizedTwoPointers(int[] height) {
        if (!validateHeight(height)) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minH * (right - left));

            while (left < right && height[left] <= minH) {
                left++;
            }
            while (left < right && height[right] <= minH) {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Array_P6_ContainerWithMostWater solver = new Array_P6_ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Problem 6: Container With Most Water Suite");
        System.out.println("Input Heights: " + Arrays.toString(height));
        System.out.println("Brute Force Result:     " + solver.maxAreaBruteForce(height));
        System.out.println("Two Pointers Result:    " + solver.maxAreaTwoPointers(height));
        System.out.println("Optimized Skip Result:  " + solver.maxAreaOptimizedTwoPointers(height));
    }
}
