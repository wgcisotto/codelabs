# Count Elements Greater Than Previous Average

**Category:** Arrays / Basic Problem Solving  
**Platform:** HackerRank (Custom Practice Setup)

---

## 🧩 Problem Description

Given an array of positive integers, return the number of elements that are **strictly greater** than the average of all **previous elements**.  
Skip the first element since it has no previous elements.

## 💡 Approach

1. Initialize a running sum with the first element.
2. For each subsequent element:
    - Compute the average of all previous elements.
    - Compare the current element with that average.
    - Increment `count` if greater.
3. Return `count`.

---

## 🧮 Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## ✅ Example Implementation
See [`Solution.java`](./Solution.java) for full implementation.