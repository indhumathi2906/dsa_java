import java.util.*;

/**
 * 🚀 Master Combined Solution Suite: 7 Essential Array DSA Problems
 *
 * Contains optimal implementations for all 7 Array problems in a single executable file:
 * 1. Two Sum
 * 2. Best Time to Buy and Sell Stock
 * 3. Contains Duplicate
 * 4. Product of Array Except Self
 * 5. Maximum Subarray (Kadane's Algorithm)
 * 6. Container With Most Water
 * 7. Merge Intervals
 */
public class Arrays_Master_Solutions {

    // ==========================================
    // 1. Two Sum (LeetCode #1)
    // ==========================================
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // ==========================================
    // 2. Best Time to Buy and Sell Stock (LeetCode #121)
    // ==========================================
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // ==========================================
    // 3. Contains Duplicate (LeetCode #217)
    // ==========================================
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    // ==========================================
    // 4. Product of Array Except Self (LeetCode #238)
    // ==========================================
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightMultiplier = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightMultiplier;
            rightMultiplier *= nums[i];
        }
        return res;
    }

    // ==========================================
    // 5. Maximum Subarray (LeetCode #53)
    // ==========================================
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }

    // ==========================================
    // 6. Container With Most Water (LeetCode #11)
    // ==========================================
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minH * (right - left));
            while (left < right && height[left] <= minH) left++;
            while (left < right && height[right] <= minH) right--;
        }
        return maxArea;
    }

    // ==========================================
    // 7. Merge Intervals (LeetCode #56)
    // ==========================================
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // ==========================================
    // Master Test Suite Execution
    // ==========================================
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("🌟 Arrays Master DSA Solutions Test Suite");
        System.out.println("==================================================\n");

        // P1 Test
        int[] p1_nums = {2, 7, 11, 15};
        System.out.println("1. Two Sum (target=9): " + Arrays.toString(twoSum(p1_nums, 9)));

        // P2 Test
        int[] p2_prices = {7, 1, 5, 3, 6, 4};
        System.out.println("2. Best Time to Buy & Sell Stock: Max Profit = " + maxProfit(p2_prices));

        // P3 Test
        int[] p3_nums = {1, 2, 3, 1};
        System.out.println("3. Contains Duplicate: " + containsDuplicate(p3_nums));

        // P4 Test
        int[] p4_nums = {1, 2, 3, 4};
        System.out.println("4. Product Except Self: " + Arrays.toString(productExceptSelf(p4_nums)));

        // P5 Test
        int[] p5_nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("5. Maximum Subarray Sum (Kadane's): " + maxSubArray(p5_nums));

        // P6 Test
        int[] p6_heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("6. Container With Most Water Max Area: " + maxArea(p6_heights));

        // P7 Test
        int[][] p7_intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("7. Merge Intervals: " + Arrays.deepToString(mergeIntervals(p7_intervals)));

        System.out.println("\n==================================================");
        System.out.println("✅ All 7 Problems Executed Successfully!");
        System.out.println("==================================================");
    }
}
