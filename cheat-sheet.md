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

- variable names to align with data structures like heap, min, curr, next, temp, prev, down, downRight -> namingSmell single char alphas, prefix 1, 2 etc
- scope variable collisions
- program struct:
  - Use member/class variables to reduce method params
  - Avoid compile errors
  - Type name;
  - meth(param1, param2, ...)
  - public Type meth(T1 p1, T2 p2, ...) {
      return typeVar;
    }
  - No copy & pasting -> introduces more compile errors
  - focus on the cursor to catch mistakes as typed
  - avoid keyword typing mistakes

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

TopKFrequent Elements:
    Java Collection Usage
    PriorityQueue - How does poll() help in TopKFrequent

WordSearch:
    BFS is great when you're finding the shortest paths or any path, but not when you need path integrity, like in this problem.
    DFS with backtracking is the go-to approach for "find this sequence of steps" problems. 

Product Except Self
    Prefix & Suffix product x (rolling products)

Water Search
    Rule of Thumb
    If you’re finding nearest X from multiple sources, use multi-source BFS from X.

Two-Sum:
    Need original indices: avoid raw sort.
    check-then-insert to avoid self-pair bugs.
    putIfAbsent vs overwrite: how to handle Duplicates
    -> sorting is possible if you use sort by val & key index

ZigZagConversion:
    Row buffer optimization/Accumulator rows
    Direction encoding & State compression

Reverse Integer:
    extract most significant PV using "divisor scaling" vs "modulo based" reversal

String To Integer:
    Edge case simplification

Unique Binary Search Trees II - Given an integer n:
    DFS doesn't work
    Use Catalan "choose-root and combine subtrees":
        - Pick each i in [lo..hi] as the root.
        - Recursively build all left trees from [lo..i-1] and right trees from [i+1..hi].
        - Cross-product them to form unique trees 
        - No duplicates arise because each shape is determined by the root split (lo..i-1 | i | i+1..hi).

Validate BST:
    Long.MIN_VALUE & Long.MAX_VALUE for allowing Integer.MIN_VALUE & Integer.MAX_VALUE

Recover BST:
    - Swapping "on the fly" with a value → node map breaks invariants
    - Collect inorder and find the 2 inversions where cur.val > next.val (the first time it happens & the last time it happens)
    - in place swap the node values
    - Common bugs to check:
        - You set second = inorder.get(i) instead of inorder.get(i+1).
        - You stopped after the first inversion (missing the non-adjacent case).
        - You built a List<Integer> and then tried to find nodes by value (breaks with equal values).
        - You modified node values before finishing the scan (changing comparisons mid-way).

Binary Tree From Preorder & Inorder: 
    - Preorder = root | left-subtree | right-subtree
    - Inorder = left-subtree | root | right-subtree
    - preorder gives you the order of root nodes visited
    - inorder is used to build the left & right subtrees
    - build an inorder map for index lookup, everything to the left is the left subtree & right is the right subtree
    - keep an "instance level" preorder index - so both left & right calls can access the correct index

Binary tree from Postorder & Inorder:
    - Postorder = left-subtree | right-subtree| root
    - After picking the root, build right subtree first, then left (because postorder is consumed from the end)

divide-two-integers:
    is quotient negative?
    long dividend & divisor
    dividend > divisor
        find largest multiple of divisor and reduce the dividend
        add the multiple to quotient
        use bit shift for multiplying by 2

next-permutation:
  - find pivot and swap with the smallest element greater than pivot
  - reverse the suffix

search-in-rotated-sorted-array:
    - find sorted half and exclude or include it

find-first-and-last-position-of-element-in-sorted-array:
    - find target and then search for first & last

search-insert-position:
    - [lo, hi) - exclude hi & start with hi = nums.length

combination-sum:
    - skip duplicates at same level by sort & skip index with same value at the given depth

Remove Duplicates from Sorted Array II:
    Two-Pointer Write Index & Sliding Window
    - One pointer iterates through the array (the “reader”).
    - Another pointer marks the position in the array where the next valid element should be written (the “writer”).

Search in Rotated Sorted Array II:
    - reduce the bounds if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) & continue from start
    - at least left or right should be sorted  hence check  nums[lo] <= nums[mid] or nums[mid] <= nums[hi]

Convert Sorted Array to Binary Search Tree:
    - can use mid or mid + 1 as mid and continue to buildBST 

Minimum Depth of Binary Tree:
    - separate tree-null vs branch-null handling

Balanced Binary Tree:
    - return height or falsy (-1)

Flatten Binary Tree to LinkedList:
    traversing is post order - recurse left, recurse right then relink current node (same as min/max Depth)
    perform in-place mutation unlike min/max depth which returns int
    To preserve preorder use splice step. This is order sensitive/commutative:
        if no left then no splice
        use rightSaved for right node
        walk to the tail of left - put's whole left list before right - O(n^2) worst case

Palindrome Partitioning:
    identify recursive structure & backtrack
    what is the base case returning (in this case an empty array list for the product to continue)
    Catalan-Like Complexity
    algo: 
        - choose a split point and combine left & right sub solutions
        - worst case "aaaaa..." -> every substring is palindrome & yeilds ~ 2^(N-1) partitions

Gas Station:
    Kadane problem - greedy "one-pass" algorithm
    feasibility test: sum(diff) >= 0
    single pass index finding: if sum(diff[start ... i]) < 0 set index as i + 1
    prefix-sum/induction can be used to prove why single pass works:
        - skip when sum(diff[start ... i]) < 0
        - index is i + 1
    
# Technique Guidelines
BFS:
    LinkedList Queue Size
    While & for
    check new grid coordinates in bounds
    Use Marker to avoid back loops

Binary Search
    if nums[0] in sorted array is > target then "end" will be "-1"
    if nums[length-1] in sorted array is < target then "start" will be "length"
    mid-calculation (start+end)/2 can cuse overflow

DFS:
    Early Pruning exit after finding result -> GraySequence
    n-ary DFS: similar to binary DFS but allows "pick one from many options at each step and avoid duplicates at the same level" like "permutations"
    binary DFS: each element can be either in or out, like subset generation, subsequences -> not good for permutations
    Solving Permutations:
        - n-ary
        - Dup skipping logic: Using while skips multiple indices at once and can step past valid choices,
            For permutations-with-duplicates, the standard rule is:
            After sorting, when you see the same value as the previous index, skip it if the previous identical value hasn’t been used in 
            the current path (same depth).
            i.e. if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
        - Simple analogy: Think of each duplicate number as siblings in line.
            Rule: the younger sibling (nums[i]) can only step forward if the older sibling (nums[i-1]) has already stepped in.
            That way, we never let “younger” go first and cause duplicate scenarios.
        - start parameter: For permutations (placing numbers in positions), you don’t need start. The stopping condition is cur.size() == N, not start >= N.
    
BinarySearchTree(BST):
    inorder traversal of a BST is increasing -> RecoverBST

Competition/Interview Programming Techniques:

DP Cheat Sheet:
    1. Identify the Problem Type
        Is it asking for min/max value (triangle min path, coin change)?
        Is it about counting ways (climbing stairs, unique paths)?
        Is it about true/false decisions (subset sum, word break)?
        - Knowing which bucket helps you anticipate the recurrence.
    2. Define the State (subproblem)
        Ask: What’s the smallest unit of the problem I can solve, and how do I index it?
        Example (triangle min path): f(r, c) = min path sum from (r, c) to bottom.
        Example (climbing stairs): f(n) = ways to reach step n.
        Example (knapsack): f(i, w) = max value using first i items with capacity w.
        - Rule of thumb: state = what changes across recursive calls/iterations.
    3. Base Case(s)
        Usually at the “edges” of input (last row, step 0, capacity 0).
        Example: in triangle, last row: f(r, c) = tri[r][c].
    4. Transition (recurrence)
        How do you move from smaller subproblems to the bigger one?
        Example (triangle):
        f(r, c) = tri[r][c] + min(f(r+1, c), f(r+1, c+1))
        Example (climb stairs):
        f(n) = f(n-1) + f(n-2)
    5. Memoization or Tabulation
        Top-down (memo): recursive function + hashmap/array cache.
            memoization changes return signature
        Bottom-up (tab): fill table iteratively (often easier to debug).
        Optimize space if only last row/column matters.
    6. Answer
        Where is the “whole problem” answer?
        Top-down: usually f(0,0) or f(n)
        Bottom-up: often dp[0][0] or dp[n].
    7. Complexity Check
        Time = #states × work per state.
        Space = memo/table size (can usually optimize).
    Mini-Example: Triangle Min Path
        * State: f(r, c) = min sum from (r, c)
        * Base: f(last row, c) = tri[last][c]
        * Transition: tri[r][c] + min(f(r+1,c), f(r+1,c+1))
        * Answer: f(0,0)

Two-Pointer:
    slow & fast pointer
    Write Index (slow) & Sliding Window:

Invariant ChecksList:
    Initialize -> Maintain -> Terminate
    State one relationship you can keep true every step. Options you’ll reuse a lot:
        Fixed gap: fast is k nodes ahead of slow.
        Window coverage: Nodes between slow (exclusive) and fast (inclusive) form the last k nodes seen.
        Prefix/suffix property: All nodes up to slow are processed; nodes after fast are unprocessed.

Invariant patterns for linked lists:
    Two pointers / deletion k-from-end: fixed gap (n+1).
    Cycle detection (Floyd): fast moves 2X, slow moves 1X; if there’s a cycle, they meet.
    Reverse sublist [m, n]: rev always points to node before the reversed block; curr is the first node not yet reversed.
    Merge two lists: All nodes up to tail are correctly merged and sorted.
    dummy is a standard invariant helper: It makes “predecessor exists” always true, so your invariant can say “slow is predecessor” without branching for head deletion.

Kadanes Algorithm:
    If currSum < 0, drop it (restart), because any future extension is hurt by a negative prefix.
    if (nums[i] > currSum) and if (currSum < 0) are just two ways of writing the same reset logic.

In-Place:
    Use constant extra space for any given input size.

choose-root and combine subtrees/Catalan recipe - It’s the general strategy whenever you see:
    - recursive combinatorial structures
    - partition into two sides
    - multiplication of possibilities
    - result count = Catalan number.
    - pseudo:
    for (int root = L; root <= R; root++) {
        for (Tree left : solve(L, root-1))
            for (Tree right : solve(root+1, R))
            combine(left, root, right);
    }
    Explosion: number of outputs ~ Catalan number C_n.
    Examples: Unique BSTs, valid parentheses, polygon triangulation
    Catalan vs Backtrack:
        Catalan = split & combine both sides.
        Backtracking = greedy prefix, recurse on suffix.
    
Plain Backtracking
    Structure: "Pick a valid piece at the current index, recurse on the remainder."
    - pseudo:
    for (int end = start; end < n; end++) {
        if (valid(start..end)) {
            path.add(s[start..end]);
            dfs(end+1);
            path.removeLast();
        }
    }
    Explosion: up to 2^(n-1) partitions (Catalan-like, but not true Catalan)
    Examples: Palindrome partitioning, word break, combination sum

# Library Guidelines
Collections:
    use collection.isEmpty() instead of collection.size() != 0
    Collections.emptyList() instead of new ArrayList<>()
    Arrays.asList(nums[1])
    Adding array elements to List
        List<List<Integer>> result = new ArrayList<>()
        ...
        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
    ArrayList to Array: 
        list.stream().mapToInt(Integer::intValue).toArray()  
            // To convert List<Integer> to int[], there is no unboxed version and you have to use mapToInt, mapToDouble etc;
        This doesn't work --> list.stream().mapToInt(Integer::intValue).toArray(new int[0]) 
            // because the overloaded toArray() doesn't exist in IntStream 
        List<int[]> to int[][]: list.stream().toArray(int[][]::new)
        Object[] list.toArray()
        String[] list.toArray(new String[0])
        String[] list.toArray(new String[list.size()])
        Collections.reverse(List) // inplace & no method on List; only works on List not on Queue or Set
    Map: 
        hashMap.getOrDefault(key, default)
        hashMap.putIfAbsent -> will return null for the first time
        hashMap.computeIfAbsent -> will return value returned by mapping function if absent or the  current value
        hashMap.compute  -> don't use beyond simple data types
    SortedMap/Set:
        TreeMap is sorted Map
        TreeSet is sorted set
    PriorityQueue:
        priorityQueue.poll()
    Stream:
        stream.collector(Collectors.toList())
        stream.toArray() --> for converting stream to Array gotcha's above in toArray
        stream.boxed().collector(Collectors.toList()) // boxing for IntStream to List<Integer>
        forEach expects a Consumer<int[]> → a void lambda & doesn’t let you short-circuit early using “break” or “return a boolean”
        Use anyMatch/allMatch (which do short-circuit) or just use normal loops.

Arrays
    Arrays.sort(int[])
    Arrays.sort(object[], Comparator.comparingInt( x -> x_to_int))
    Arrays.fill -> char[] zeros = new char[n]; Arrays.fill(zeros, '0');
    No GenerArrays in Java only raw types.
        @SuppressWarnings("unchecked")
        List<String> [][] = new ArrayList[M][N]

System:
    System.arraycopy(from,fromStart,to,toStart,fromLength)

Math
    Integer.MAX_VALUE
    Integer.MIN_VALUE
    for big constants use _ like long MAX = 1000_000_000;
    option A will result in overflow error, while B will not
        option A: long curr = 1000_000_000+1000_000_000+1000_000_000+1000_000_000;// nums[i]+nums[j]+nums[k]+nums[l];
        option B: long curr = nums[i];  curr += nums[j]; curr += nums[k]; curr += +nums[l];
    Math.pow(2,n)  -> returns double cast for int
    1 << n -> left shift is same as 2 power n and directly int
    Math.abs(Integer.MIN_VALUE) as an int, it would still be -2,147,483,648 due to overflow
    
Matrix
    Spiral/MinOpsForY/Rotate

String
    convert String to int --> Integer.parseInt(String s) or Integer.valueOf(String s)
    str.substring()
    Integer.toString(i)
    int digit = chat - '0'
    ",a,b,c,".split(",") -> splits into 4. First is "" while the last is c 
    \ is an escape character (special meaning to compiler) whereas / is a regular char

StringBuilder
    stringBuilder.reverse()
    sb.deleteCharAt(i)

Character
    Character.toLowerCase(c)
    check if character is alphanumeric -> Character.isDigit(c) || Character.isLetter(c)

java compilation:
    Sentence ends with ;
    variable naming 
        set -> seen/visibinted 
        list -> path/track
        String -> start/end

java operators:
    simple ternary return 
    return and assignment
        return memo[i][partsLeft] = res;
        store res in memo[i][partsLeft] and return the result
    assignment as expression
        int x;
        System.out.println(x = 42);

Bitwise:
    1 << n -> left shift same as 2^n  or Math.pow(2, n)
    i >>> 1 -> unsigned right shift
    num1 ^ num2 -> bitwise xor that results in int 

Boolean:
    ^ - Boolean version of XOR // no shortcut as both operands need eval
    DIY XOR: boolean negative = (dividend < 0) != (divisor < 0)