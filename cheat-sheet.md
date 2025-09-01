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

# Problem wise Guidelines
TwoSum:
    primitive != null
    Integer index = indexMap.get(target-nums[i]);
    if( index != null

Valid Parenthesis:
    check if stack is empty before pop()  when char is closing
    LinkedList as Stack

Longest Substring Without Repeating Characters:
    multi variable initialization in Java
    check window.contains(s);// not the whole string but just the next char

3Sum:
    guard conditions before incrementing ex: while(left < right && nums[left] == nums[left+1]) left++; vs while(lnums[left] == nums[left+1] && eft < right) left++;
    result.add(Arrays.asList(nums[i], nums[left], nums[right]));   vs    result.add(new ArrayList<>(new int[]{nums[i], nums[left], nums[right]}));
    code commenting


Binary Search:
    Handle null/empty arrays.
    Use while (lo <= hi) instead of while (nums[lo] < nums[hi]).
    Compute mid as lo + (hi - lo) / 2 to prevent overflow.
    Keep bounds updates tight (mid ± 1).

Group Anagrams/MajorityElement:
    compute/ComputeIfAbsent
    use _ for lambda if not using the param

LinkedLists:
    to return head of a new LinkedList start with Dummy LinkedListNode
    - Saves iteration
    when using multiple LinkedLists once reached the end of the LinkedList use the other one as temp and link once

Best Time to Buy and Sell Stock:
    Two pointer: find min and max profit simultaneously

LevelOrderTraversal:
    Use Queue/LinkedList for LeveL Order Traversal & size
    LinkedList: poll/offer

Set Matrix Zeroes:
    don't use marker
    using marker as 'X' for int will result in assigning 88
    use firstRowZero, firstColZero flags & row 1/col 1 for setting zero

TopKFrequent Elems:
    Java Collection Usage
    PriorityQueue - How does poll() help in TopKFrequent

WordSearch:
    BFS is great when you're finding shortest paths or any path, but not when you need path integrity, like in this problem.
    DFS with backtracking is the go-to approach for "find this sequence of steps" problems. 

BFS:
    LinkedList Queue Size
    While & for
    check new grid corrdinates in bounds
    Use Marker to avoid back loops

Collections:
    use collection.isEmpty() instead of collection.size() != 0
    Integer.MAX_VALUE
    Integer.MIN_VALUE
    Arrays.asList(nums[1])
    Adding array elements to List
        List<List<Integer>> result = new ArrayList<>()
        ...
        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
    ArrayList to Array: 
        list.stream().mapToInt(Integer::intValue).toArray();
        List<int[]> to int[][]: list.stream().mapToInt(Integer::intValue).toArray(int[][]::new);
        Object[] list.toArray()
        String[] list.toArray(new String[0])
        String[] list.toArray(new String[list.size()])

Arrays
    Arrays.sort(int[])
    Arrays.sort(object[], Comparator.comparingInt( x -> x_to_int))

System:
    System.arraycopy(from,start,to,start,fromLength)

Math
    for big constants use _ like long MAX = 1000_000_000;
    option A will result in overflow error, while B will not
        option A: long curr = 1000_000_000+1000_000_000+1000_000_000+1000_000_000;// nums[i]+nums[j]+nums[k]+nums[l];
        option B: long curr = nums[i];  curr += nums[j]; curr += nums[k]; curr += +nums[l];

Binary Search
    if nums[0] in sorted array is > target then "end" will be "-1"
    if nums[length-1] in sorted array is < target then "start" will be "length"
    mid calculation (start+end)/2 can cuse overflow
    
Product Except Self
    Prefix & Suffix productx (rolling products)

Water Search
    Rule of Thumb
    If you’re finding nearest X from multiple sources, use multi-source BFS from X.

Matrix
    Spiral/MinOpsForY/Rotate

String
    convert String to int --> Integer.parseInt(String s) or Integer.valueOf(String s)
    str.substring()
    Integer.toString(i)
    int digit = chat - '0'
    ",a,b,c,".split(",") -> splits into 4. First is "" while the last is c 
    \ is an escape charater (special meaning to compiler) where as / is a regular char

StringBuilder
    stringBuilder.reverse()

java compilation:
    Sentence ends with ;
    