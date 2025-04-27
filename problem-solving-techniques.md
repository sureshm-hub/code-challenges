# Programming Techniques Cheat Sheet

Mapping of **programming techniques** to **program/class names** from the repo.

---

| Technique | Program/Class Names |
|:---|:---|
| **Sliding Window** | `SlidingWindowMaximum`, `MinimumWindowSubstring`, `SubstringWithConcatenationOfAllWords`, `LongestSubstringWithoutRepeatingCharacters` |
| **Two Pointers** | `MergeSortedArray`, `SearchRotatedSortedArray`, `MinimumWindowSubstring`, `RemoveNthNodeFromEndOfList`, `ContainerWithMostWater` |
| **BFS (Breadth-First Search)** | `WordLadderII`, `CloneGraph`, `NumberOfIslands`, `PacificAtlanticWaterFlow`, `RottingOranges`, `BinaryTreeLevelOrderTraversal`, `BinaryTreeRightSideView` |
| **DFS (Depth-First Search)** | `PacificAtlanticWaterFlow`, `AlienDictionary`, `UniquePathsIII`, `WordSearch`, `NumberOfIslands`, `MaxAreaOfIsland` |
| **Top-K / Heap (PriorityQueue)** | `TopKFrequentElements`, `KthLargestElementInArray`, `FindMedianFromDataStream`, `MeetingRoomsII`, `TaskScheduler`, `KClosestPointsToOrigin`, `DijkstraShortestPath` |
| **Dynamic Programming (DP)** | `DecodeWays`, `HouseRobberIII`, `UniquePathsIII`, `CoinChange`, `LongestIncreasingSubsequence`, `EditDistance` |
| **Greedy** | `TaskScheduler`, `MeetingRoomsII`, `MergeIntervals`, `InsertInterval`, `ReconstructItinerary` |
| **Backtracking** | `CombinationSum`, `Permutations`, `WordSearch`, `LetterCombinationsPhoneNumber`, `ReconstructItinerary` |
| **Binary Search** | `SearchRotatedSortedArray`, `Search2DMatrixII`, `FindMinimumInRotatedSortedArray`, `FirstBadVersion`, `MedianOfTwoSortedArrays` |
| **Graph (Adjacency List/Matrix)** | `CloneGraph`, `WordLadderII`, `AlienDictionary`, `CourseSchedule`, `ReconstructItinerary`, `PacificAtlanticWaterFlow` |
| **Union-Find / Disjoint Set** | `GraphValidTree`, `NumberOfConnectedComponentsInUndirectedGraph` |
| **Bit Manipulation** | `SumOfTwoIntegers`, `SingleNumber`, `MissingNumber`, `NumberOf1Bits` |
| **Stack (Monotonic Stack / Regular Stack)** | `DailyTemperature`, `ValidParentheses`, `MinStack`, `MaximalRectangle`, `LargestRectangleInHistogram`, `EvaluateReversePolishNotation` |
| **Sorting Based** | `MergeIntervals`, `InsertInterval`, `MeetingRoomsII`, `TopKFrequentElements`, `TaskScheduler`, `KClosestPointsToOrigin` |
| **Trie / Prefix Tree** | `ImplementTrie`, `WordSearchII` |

---

# Miscellany (Other Techniques)

| Program/Class Name | Notes |
|:---|:---|
| `RandomizedSet` | HashMap + ArrayList Trick for O(1) insert/delete |
| `FindDuplicateNumber` | Floyd's Tortoise and Hare (Cycle detection) |
| `SumOfTwoIntegers` | Manual Bit Manipulation (without "+") |
| `SingleNumber` | Bitwise XOR Trick |
| `MaxAreaOfIsland` | Standard DFS/BFS hybrid |
| `EvaluateReversePolishNotation` | Stack-based Arithmetic |

---

# Notes:
- Some problems belong to **multiple techniques** (e.g., Sliding Window + Two Pointers)
- **Graph** covers BFS/DFS with adjacency list/matrix representation
- **Bit Manipulation** covers clever XOR or manual bitwise tricks
- **Miscellany** contains either unique tricks or non-standard solutions

---