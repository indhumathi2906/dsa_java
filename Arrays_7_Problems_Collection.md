# 📊 7 Essential Array DSA Problems — Complete Java Guide

A comprehensive, production-grade collection of **7 essential Array Data Structures & Algorithms (DSA) problems** implemented in **Java**. Each problem features multiple architectural approaches transitioning from **Brute Force** to **Optimal Single-Pass / Space-Optimized Solutions**.

---

## 💡 Master Overview & Summary Table

| # | Problem Name | LeetCode Link | Solution Directory | Optimal Time | Optimal Space | Key Pattern / Technique |
|---|---|---|---|---|---|---|
| **P1** | [1. Two Sum](https://leetcode.com/problems/two-sum/) | [`Array_P1_TwoSum`](./Array_P1_TwoSum) | $O(N)$ | $O(N)$ | Hash Map Lookup / Complement Indexing |
| **P2** | [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [`Array_P2_BestTimeToBuyAndSellStock`](./Array_P2_BestTimeToBuyAndSellStock) | $O(N)$ | $O(1)$ | Single-Pass Minimum Price & Profit Tracking |
| **P3** | [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | [`Array_P3_ContainsDuplicate`](./Array_P3_ContainsDuplicate) | $O(N)$ | $O(N)$ | Hash Set Collision Detection |
| **P4** | [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | [`Array_P4_ProductOfArrayExceptSelf`](./Array_P4_ProductOfArrayExceptSelf) | $O(N)$ | $O(1)^*$ | Prefix & Suffix Product Accumulation |
| **P5** | [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | [`Array_P5_MaximumSubarray`](./Array_P5_MaximumSubarray) | $O(N)$ | $O(1)$ | Kadane's Algorithm (Dynamic Subarray Sum) |
| **P6** | [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | [`Array_P6_ContainerWithMostWater`](./Array_P6_ContainerWithMostWater) | $O(N)$ | $O(1)$ | Two Pointers Shrinking Window |
| **P7** | [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/) | [`Array_P7_MergeIntervals`](./Array_P7_MergeIntervals) | $O(N \log N)$ | $O(N)$ | Sorting Start Points & Sequential Merging |

*\*Note: Excluding output array space requirement.*

---

## 📦 Combined Executable Master File

All 7 solutions are aggregated into a single, zero-dependency, runnable Java suite:
👉 [`Arrays_Master_Solutions.java`](./Arrays_Master_Solutions.java)

To run all 7 test suites at once:
```bash
javac Arrays_Master_Solutions.java
java Arrays_Master_Solutions
```

---

## 🔍 Detailed Problem Breakdown

### Problem 1: Two Sum
- **Directory:** [`Array_P1_TwoSum`](./Array_P1_TwoSum)
- **LeetCode:** [#1](https://leetcode.com/problems/two-sum/)
- **Core Concept:** Store previously visited numbers and their indices in a `HashMap`. For each element `x`, check if `target - x` exists in $O(1)$ time.
- **Approaches Included:**
  1. Brute Force $O(N^2)$ Time, $O(1)$ Space.
  2. Element-Index Pair Sorting & Two Pointers $O(N \log N)$ Time, $O(N)$ Space.
  3. Single-Pass Hash Map $O(N)$ Time, $O(N)$ Space.

### Problem 2: Best Time to Buy and Sell Stock
- **Directory:** [`Array_P2_BestTimeToBuyAndSellStock`](./Array_P2_BestTimeToBuyAndSellStock)
- **LeetCode:** [#121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- **Core Concept:** Maintain a running minimum price seen so far as you iterate through the array. Calculate potential profit at each day.
- **Approaches Included:**
  1. Brute Force Pairwise Comparison $O(N^2)$ Time, $O(1)$ Space.
  2. 1D DP Tabulation Array $O(N)$ Time, $O(N)$ Space.
  3. Optimal Single-Pass Greedy $O(N)$ Time, $O(1)$ Space.

### Problem 3: Contains Duplicate
- **Directory:** [`Array_P3_ContainsDuplicate`](./Array_P3_ContainsDuplicate)
- **LeetCode:** [#217](https://leetcode.com/problems/contains-duplicate/)
- **Core Concept:** Utilize `HashSet.add()` which returns `false` if an element is already present in the set.
- **Approaches Included:**
  1. Brute Force Double Loop $O(N^2)$ Time, $O(1)$ Space.
  2. Sorting & Adjacent Neighbor Check $O(N \log N)$ Time, $O(1)$ Space.
  3. Single-Pass HashSet $O(N)$ Time, $O(N)$ Space.

### Problem 4: Product of Array Except Self
- **Directory:** [`Array_P4_ProductOfArrayExceptSelf`](./Array_P4_ProductOfArrayExceptSelf)
- **LeetCode:** [#238](https://leetcode.com/problems/product-of-array-except-self/)
- **Core Concept:** Compute prefix products in a forward pass, and accumulate suffix products using a running multiplier in a backward pass without using division.
- **Approaches Included:**
  1. Brute Force Product $O(N^2)$ Time, $O(1)$ Space.
  2. Explicit Prefix & Suffix Arrays $O(N)$ Time, $O(N)$ Auxiliary Space.
  3. Single Output Array + Variable Accumulator $O(N)$ Time, $O(1)$ Auxiliary Space.

### Problem 5: Maximum Subarray (Kadane's Algorithm)
- **Directory:** [`Array_P5_MaximumSubarray`](./Array_P5_MaximumSubarray)
- **LeetCode:** [#53](https://leetcode.com/problems/maximum-subarray/)
- **Core Concept:** Decide at each index whether to extend the current subarray sum or start fresh from the current element.
- **Approaches Included:**
  1. Brute Force All Subarrays $O(N^2)$ Time, $O(1)$ Space.
  2. Divide and Conquer Recursive Approach $O(N \log N)$ Time, $O(\log N)$ Space.
  3. Optimal Kadane's Algorithm $O(N)$ Time, $O(1)$ Space.

### Problem 6: Container With Most Water
- **Directory:** [`Array_P6_ContainerWithMostWater`](./Array_P6_ContainerWithMostWater)
- **LeetCode:** [#11](https://leetcode.com/problems/container-with-most-water/)
- **Core Concept:** Initialize two pointers at array extremities. Calculate area, then move the pointer pointing to the shorter vertical line inward.
- **Approaches Included:**
  1. Brute Force All Line Pairs $O(N^2)$ Time, $O(1)$ Space.
  2. Two Pointers Shrinking Window $O(N)$ Time, $O(1)$ Space.
  3. Two Pointers with Fast Skipping $O(N)$ Time, $O(1)$ Space.

### Problem 7: Merge Intervals
- **Directory:** [`Array_P7_MergeIntervals`](./Array_P7_MergeIntervals)
- **LeetCode:** [#56](https://leetcode.com/problems/merge-intervals/)
- **Core Concept:** Sort intervals by start time. Iterate through sorted intervals and merge if current interval's start $\le$ previous interval's end.
- **Approaches Included:**
  1. Naive Overlap Scanner $O(N^2)$ Time, $O(N)$ Space.
  2. Sorting + ArrayList Accumulation $O(N \log N)$ Time, $O(N)$ Space.
  3. In-Place Array Merging $O(N \log N)$ Time, $O(N)$ Space.

---

## 🛠 Compilation and Execution

Compile individual problem folders:
```bash
javac Array_P1_TwoSum/Array_P1_TwoSum.java
java Array_P1_TwoSum.Array_P1_TwoSum
```

---
*Created by [Indhumathi](https://github.com/indhumathi2906)*
