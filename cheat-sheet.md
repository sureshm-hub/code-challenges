A mapping of **each program** to the **Java Standard API classes** and **specific methods** used.

| Program/Class Name | Java API Used | Specific Methods / Usage |
|:---|:---|:---|
| DailyTemperature | Stack | `push()`, `pop()`, `peek()` |
| WordLadderII | HashMap, HashSet, Deque (ArrayDeque) | `put()`, `get()`, `contains()`, `add()`, `pollFirst()`, `addLast()` |
| LRUCache | HashMap, Deque (ArrayDeque) | `put()`, `get()`, `removeLast()`, `addFirst()` |
| TopKFrequentElements | HashMap, PriorityQueue | `put()`, `get()`, `new PriorityQueue<>((a,b) -> b[1]-a[1])`, `offer()`, `poll()` |
| MergeKSortedLists | PriorityQueue | `new PriorityQueue<>((a,b) -> a.val - b.val)`, `offer()`, `poll()` |
| KthLargestElementInArray | PriorityQueue | `new PriorityQueue<>()`, `offer()`, `poll()`, `peek()` |
| MeetingRoomsII | PriorityQueue, Arrays | `sort()`, `new PriorityQueue<>()`, `offer()`, `poll()`, `peek()` |
| DesignTwitter | HashMap, HashSet, PriorityQueue, Deque | `put()`, `get()`, `add()`, `remove()`, `offer()`, `poll()` |
| FindMedianFromDataStream | PriorityQueue | `new PriorityQueue<>()`, `offer()`, `poll()`, `peek()` |
| SlidingWindowMaximum | Deque (ArrayDeque) | `addLast()`, `pollFirst()`, `peekFirst()` |
| ValidParentheses | Stack | `push()`, `pop()`, `peek()` |
| BinaryTreeLevelOrderTraversal | Queue (LinkedList) | `offer()`, `poll()`, `isEmpty()` |
| CloneGraph | HashMap, Queue (LinkedList) | `put()`, `get()`, `offer()`, `poll()` |
| CourseSchedule | HashMap, HashSet, Queue (LinkedList) | `put()`, `get()`, `contains()`, `offer()`, `poll()` |
| PacificAtlanticWaterFlow | Queue (LinkedList), HashSet | `offer()`, `poll()`, `add()`, `contains()` |
| AlienDictionary | HashMap, HashSet, Queue (LinkedList) | `put()`, `get()`, `add()`, `contains()`, `offer()`, `poll()` |
| LongestConsecutiveSequence | HashSet | `add()`, `contains()`, `remove()` |
| MinimumWindowSubstring | HashMap, HashSet | `put()`, `get()`, `contains()`, `remove()` |
| SubstringWithConcatenationOfAllWords | HashMap | `put()`, `get()`, `containsKey()` |
| GroupAnagrams | HashMap | `put()`, `get()`, `computeIfAbsent()` |
| LetterCombinationsPhoneNumber | HashMap, List (ArrayList) | `put()`, `get()`, `add()` |
| CombinationSum | List (ArrayList) | `add()`, `remove()` |
| Permutations | List (ArrayList) | `add()`, `remove()`, `addAll()` |
| UniquePathsIII | HashSet | `add()`, `remove()`, `contains()` |
| DecodeWays | HashMap | `put()`, `getOrDefault()` |
| HouseRobberIII | HashMap | `put()`, `getOrDefault()` |
| NumberOfIslands | Queue (LinkedList), HashSet | `offer()`, `poll()`, `add()`, `contains()` |
| RottingOranges | Queue (LinkedList) | `offer()`, `poll()`, `isEmpty()` |
| DijkstraShortestPath | PriorityQueue, HashMap | `new PriorityQueue<>((a,b) -> a[1]-b[1])`, `offer()`, `poll()`, `put()`, `get()` |
| ReconstructItinerary | HashMap, PriorityQueue, LinkedList | `put()`, `get()`, `new PriorityQueue<>()`, `offer()`, `poll()`, `addFirst()` |
| FindDuplicateNumber | Set (HashSet) | `add()`, `contains()` |
| TaskScheduler | PriorityQueue, HashMap | `new PriorityQueue<>((a,b) -> b - a)`, `offer()`, `poll()`, `put()`, `get()` |
| EvaluateReversePolishNotation | Stack (Deque) | `push()`, `pop()` |
| MaximalRectangle | Stack (Deque), Arrays | `push()`, `pop()`, `peek()`, `Arrays.fill()` |
| MergeIntervals | Arrays, List (ArrayList) | `sort()`, `add()` |
| InsertInterval | Arrays, List (ArrayList) | `sort()`, `add()` |
| Search2DMatrixII | Binary Search, Arrays | `sort()`, `binarySearch()` |
| SearchRotatedSortedArray | Binary Search | Manual binary search logic |
| MinStack | Stack (Deque) | `push()`, `pop()`, `peek()`, `isEmpty()` |
| ImplementTrie | HashMap | `put()`, `get()`, `containsKey()` |
| RandomizedSet | HashMap, ArrayList | `put()`, `remove()`, `get()`, `add()` |
| KClosestPointsToOrigin | PriorityQueue | `new PriorityQueue<>((a,b) -> distance(a) - distance(b))`, `offer()`, `poll()` |
| BinaryTreeRightSideView | Queue (LinkedList) | `offer()`, `poll()` |
| SumOfTwoIntegers | Bit Manipulation | No standard APIs, manual bit ops |
| SingleNumber | Bit Manipulation | No standard APIs, manual bit ops |
| MaxAreaOfIsland | Queue (LinkedList), HashSet | `offer()`, `poll()`, `add()`, `contains()` |

---

# Notes:
- `Deque` usually backed by `ArrayDeque`
- `Queue` is usually `LinkedList` unless explicitly a `PriorityQueue`
- Custom comparators are usually Lambda functions: `(a, b) -> a[0] - b[0]`
- Bit Manipulation solutions don't rely on standard libraries

---

# Guidelines to get program right on first run:

- variable names to align with data structures like heap, min, curr, next, temp
- scope variable collisions
- hashMap.putIfAbsent -> will return null for the first time
- hashMap.computeIfAbsent -> will return value returned by mapping function if absent or the  current value
- hashMap.compute  -> don't use beyond simple data types
- priorityQueue.poll() 