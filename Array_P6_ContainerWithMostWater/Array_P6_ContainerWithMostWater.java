package Array_P6_ContainerWithMostWater;

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
}
