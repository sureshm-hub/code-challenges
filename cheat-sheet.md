# General Framework for Solving Coding Problems in an Interview:
Mnemonic: CE-BICRE-F
    Clarify - Show you're thoughtful and avoid assumptions.
    Example - Show you're grounded and "build" intuition.
    Basic/Brute Force - Shows your thought process is transparent and structured (Outline clearly)
        Implement (if needed) - Shows communication + coding skills/Shows you're ready to move incrementally
        Complexity - Helps you decide correctness & scope for optimization
    Optimize & Refine - Shows problem-solving depth.
        Write clean, functional code in your chosen language.
        Edge Cases - Shows thoroughness and reliability.
    Follow-Ups / Improvements - Shows flexibility and seniority.

# Guidelines to get program right on first run:
- avoid java compilation errors
- Sentence ends with ;
- variable names to align with data structures like: 
  heap, min, curr, node, root, next, temp, prev, down, downRight
  const - reserved keyword in java
  if long word use  2 to 3 chars: 
    high -> hi 
    reminder -> rem
    neighbors -> nbrs, adj
  other names:
    cache: seen, visited, etc;
    set -> seen/visited
    list -> path/track
    map -> byHeight or byKey avoid rootHeights 
    String -> start/end
    window/range -> left/right/l/r
    knapsack -> take/skip
    dp -> best, bestLen, bestEnd
    dfs -> node, edges(paths between nodes)
  naming:
    consonants: size -> sz
    prefix: reminder -> rem
    single alphabets g -> graph, h -> height, n -> next
    lambda unused params  _  use underscore as a convention to show not used
- namingSmell: 
  - single char alphas, prefix 1, 2, names out of context ex: curr in DFS etc;
  - naming collision
- Java class naming/API pitfalls:
  - ## Special Names 
    - Deque
    - HashSet
    - Character.isAlphabet(c) //compiler failure use Character.isLetter(c)
    - obj1.equals(obj2) //not obj1.equalsTo(...) or obj1.equalTo(...)
  - ## No Capitalize Names
    - str.substring()
    - System.arraycopy
    - Character.isWhitespace(c)
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
  - every return should match the return type or empty when return is void
  - all Generics are for a type, no  primitives
  - casting (upcasting int to long, downcasting double to int, Generics: (int[] p))
  - read out loud program as you type
  - common gotchas: 
    - return type
    - indexes
    - type1 -> type2
    - adding elements to generics
    - using variable w/o declaration/initialization 

# Guidelines for debugging the program
- go over logically
- isolate sections where program is not working
- connect output of one section to another
- avoid hallucination/lazy thinking traps
- look at the output vs expected to get better understanding

# Guidelines on reconnecting after pause
- look for continuation with awareness
- look for closure
- leave the program in better state
- let the thought/pause server you

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

Find Minimum in Rotated Sorted Array:
    - Binary Search by iteration
    - compare mid & hi to find the range where lo is located instead of mid + 1
    - converge when lo = hi

ExcelSheetTitle:
    - instead of a map use 'A' + rem
    - edge cases when reminder = 0 -> Z
    - when rem == 0 you must also reduce the quotient by 1, otherwise multi letter case breaks
    - sb.append((char)('A'+rem - 1)) // <- note the char casting
    - tags: L3 interview question

BSTIterator:
    - Use ArrayDeque instead of LinkedList

Reverse Bits:
    - Integer.toString(n, base) - higher order zero bits are ignored
    - Integer.parseInt(str, base) -  causes overflow or throw NumberFormatException for long length strings
    - reverse & pad with zeros to make 32 bits

Basic Calculator II:
    - use Character.isDigit()
    - when applying +-*/ order left to right matters along with precedence (*/ are same precedence hence apply left to right)
    - use Stack for clarity & avoid StringBuilders & complex parse/collecting logic by using Character.isDigit()

Additive Number:
    - problem with lots of edge cases
    - boundary errors
    - offset errors
    - special cases like allow 0 but not allow 02 for num2 & num1
    - cases with large inputs

RemoveZeros: various collectors

Number of Segments in a String:
    - boundary detection
    - 2 pointer is overkill

Sum of Square Numbers:
    cast into to long instead of long to int  to avoid Overflow error

# Technique Guidelines
loops:
    for list/array where i: [0, sz-1] & j: [sz-1, 0] make loop termination condition i <= j to visit last element

BFS:
    LinkedList Queue Size
    While & for
    check new grid coordinates in bounds
    Use Marker to avoid back loops
    New Technique: 
        Use ArrayDeque instead of List with start/end pointers
        for markers if index/integer based elements avoid Set and use boolean[]

Graph:
    Use AdjacencyList instead of AdjacencyMap if index/integer based keys

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

Greedy Template:
    Approach 1:
        - "start new" at nums[i] vs "extend"
        - swapping technique to keep signs consistent after multiply
        - 
    Approach 2:
        - prefix & suffix will also work with same complexity
            - Multiplying forward finds all prefix products (subarrays ending at i).
            - Multiplying backward finds all suffix products (subarrays starting at i).
            - The combination of both directions ensures every possible subarray is implicitly checked without explicit nested loops
        - prefix & suffix reset will carry negative and positive products

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

Monotonic Stack:
    - suitable for finding montonic sequences ( 4 of them)
    - https://leetcode.com/discuss/post/2347639/a-comprehensive-guide-and-template-for-m-irii/
    - DFS "Try removing digits in different combinations / recursively decide keep vs remove and track the minimum" 
      won't work here because of exponential combinations for large strings 2^n for a 100K long string it is astronomically 
      impossible
    
# Library Guidelines
Collections:
    Collections:
        use collection.isEmpty() instead of collection.size() != 0
        Collections.emptyList() instead of new ArrayList<>()
        Collections.sort(list)
        Collections.sort(list,Collections.reverseOrder()) // reverse sorting
        Collections.min(collection), Collections.min(collection, Comparator)
    List:
        list.add(indx, val)// overload where val is inserted at indx; It is an Insertion operation, not a replacement operation; index must be valid based on the current size
        list = new ArrayList<>(capacity); // You still have to use methods like add() or addAll() to populate the list, otherwise list.set(index, element) throws IndexOutOfBoundsException as list's size is zero
        list.sort()// Compiler Error - No such method
        list.sort(Comparator.naturalorder())
        list.sort(Comparator.reverseOrder()) // supported for Examples include Integer, String, and Date
    Arrays:
        Arrays.sort(people, Comparator.comparingInt((int[] person) -> - person[0]) // chaining comparators in reverse order 
                .thenComparingInt((int[] person) -> person[1])); // then another element; note Generic casting
        Arrays.asList(nums[1])
        Adding array elements to List
            List<List<Integer>> result = new ArrayList<>()
            ...
            result.add(Arrays.asList(nums[i], nums[left], nums[right])); // immutable
        Arrays.binarySearch(arr, key) -> index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1)
        Arrays.stream()
            - For primitive arrays int[], double[], long[] -> returns specialized primitive streams IntStream, DoubleStream, LongStream
            - For object arraysString[], Integer[], MyObject[], it returns a generic Stream<T>
        int[] nums ... 
            int sum = Arrays.stream(nums).sum();
            int max = Arrays.stream(nums).max().OrElse(0);// Optional
            boolean match = Arrays.stream(nums).AnyMatch(x -> x > 10);
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
        List.of(1,2,3) // List factory - immutable
    Array to ArrayList:
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[]{1})); // works
        res.add(Arrays.asList(new int[]{1})); // Doesn't work
    Map: 
        hashMap.getOrDefault(key, default)
        hashMap.putIfAbsent -> will return null for the first time
        hashMap.computeIfAbsent -> will return value returned by mapping function if absent or the  current value
            - Collection Value Pattern
                - replaces following pattern:
                        Set<Integer> preqCourses = preqs.getOrDefault(p[0], new HashSet<>());
                        preqCourses.add(p[1]);
                        preqs.put(p[0], preqCourses);
                - with:
                        preqs.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1])
            - for primitivie int's tracking unique values
                int[] id = {0};
                int existingOrNew = seen.computeIfAbsent(key, k -> id[0]++);
        Merge & Similars:
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            charMap.merge(key, 1, (oldVal, newVal) -> oldVal + newVal);
            charMap.merge(key, 1, Integer::sum);
            - If the key is not present in the map (or is associated with null): The merge() method adds the key with the provided value. The remappingFunction is not invoked in this scenario.
            - If the key already exists in the map: The remappingFunction is invoked. It takes the existing value associated with the key and the new value provided to the merge() method as input. The result of this remappingFunction then becomes the new value associated with the key in the map.
            - Handling null from remappingFunction: If the remappingFunction returns null, the key-value pair is removed from the map.
        ** merge is for accumulation like int, computeIfAbsent is for references (ex: Collections or primitive array's) 
        streams:
                map.keySet().stream()
                map.values().stream()
                map.entrySet().stream()
                map.entrySet().stream().filter(entry -> entry.getValue() == ...).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            hashMap.remove(key) -> remove Entry with key
            hashMap.remove(key,val) -> remove Entry only when key mapped to val
            hashMap.clear() -> clear all entries
            hashMap.isEmpty()
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
        stream.sorted()  stream.count() --> returns long
        Arrays.stream(nums).min().getAsInt() //IntStream -> returning OptionalInt || min/max on IntStream returns an optionalInt
        stream.sorted(Comparator.reverseOrder())
        primes.stream().filter(x -> x < n).count() // returns long
        stream.limit()
        words.stream().collect(Collectors.toSet())
        String joined = things.stream().map(Object::toString).collect(Collectors.joining(", "));
        stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append) //stream.collect(supplier, accumulator, combiner)
        Stream Operations: apply various intermediate and terminal operations to process in a functional and declarative manner. These operations include:
            - Intermediate operations: filter(), map(), flatMap(), distinct(), sorted(), limit(), skip(), etc.
            - Terminal operations: forEach(), collect(), reduce(), count(), min(<Comparator>), max(<Comparator>), anyMatch(<predicate>), allMatch(<predicate>), noneMatch(<predicate>), toArray(), etc.
    LinkedList:
        used as a stack and linked list
        `Queue` is usually `LinkedList` unless explicitly a `PriorityQueue`
    Deque:
        used as a stack and preferred for stack because of memory overhead
        `Deque` usually backed by `ArrayDeque`
        no direct access elements by index (like a get(index) or set(index) method), API supports efficient insertions and removals from both the front and the back.
Comparator:
        Custom comparators are usually Lambda functions: (a, b) -> a[0] - b[0]
        Comparator<int[]> c = Comparator.comparingInt(p -> p[0]);
        Comparator<int[]> c = (p1, p2) -> p1[0] - p2[0];
        Comparator<int[]> c = Comparator.comparingInt(x -> x[0]).reversed();//doesn't compile, use below options
        Comparator<int[]> c = Comparator.comparingInt(x -> x[0]); c.reversed();
        stream.max(Integer::compare)
        stream.max(Comparator.naturalOrder())
        Chaining:
            Comparator<String> byLen = (a, b) -> b.length() - a.length();
            Comparator<String> byLenByLexical = byLen.thenComparing(Comparator.naturalOrder());
            dictionary.sort(byLenByLexical);
        comparator.reversed()//non static a.k.a object method
        Comparator.reverseOrder()
    Optional:
        optional.orElse()      // used for Object Streams
        optionalInt.getAsInt() // used for IntStream
    Stack vs Queue vs Heaps
        Stack Methods (LIFO): use LinkedList or ArrayDeque as a stack
            - push(E e)  - Inserts an element at the front (top) of the deque.
            - pop() - Removes and returns the element at the front (top) of the deque.
            - peek() - Returns, but does not remove, the element at the front (top) of the deque.
        Queue Methods (FIFO): use LinkedList or ArrayDeque as a queue
            - add(E e) or offer(E e) - Inserts an element at the end (rear) of the deque
            - remove() NSEExcep or poll() - Removes and returns the element at the front (head) of the deque
            - pollLast() & getLast() - remove & get element at the end (tail) of the deque  
            - element() NSEExcep or peek()
        Heap: use PriorityQueue (Min-heap is default)
            - add(E e) / offer(E e) - Insertion (Sift-up)  - O(log N)
            - poll() - Removes and returns the head of the queue - O(log N)
            - peek() - Retrieves the highest-priority element without removing it from the queue
    Deque offers both stack & queue methods in a single class
    Iterator<T>:
        next - Advances the iterator, after returning an element
    Lambdas:
        method references:
            - Kind	Syntax	Examples
            - Reference to a static method	ContainingClass::staticMethodName	Math::abs
            - Reference to an instance method of a particular object	containingObject::instanceMethodName	str::isEmpty
            - Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName	String::compareToIgnoreCase,  String::concat
            - Reference to a constructor	ClassName::new	HashSet::new
        target typing:
            (int[]) p --> casting  and not used in lambdas
            (int[] p) --> explicit typing a lambda param used when compiler cannot infer the type of params
            Comparator.comparingInt((int[] p) -> p[1]);  -> not casting typing target param
        
Arrays
    Creation & Initialization:
        int[] numbers = new int[3] {1, 2, 3}; // ILLEGAL array creation with both dimension expression and initialization
        int[] numbers = new int[3];// Legal (Using dimension expression)
        int[] numbers = {1, 2, 3};//Legal (Using an initializer)
        int[] numbers = new int[] {1, 2, 3};//Legal (Using new type[] with an initializer)
        Object[] objectArray = {1, 2, 3}; // OK. Compiler boxes 1, 2, and 3 into Integer objects.
        Number[] numberArray = {1, 2, 3}; // OK. Compiler boxes 1, 2, and 3 into Integer objects.
    Arrays are covariant, but generics are not.
        Integer[] integerArray = {1, 2, 3};
        Number[] numberArray = integerArray; // This is allowed due to array covariance.
        // Illegal. Compiler cannot infer a non-Object type for the array.
        Number[] mixedArray = {1, 3.14}; // ILLEGAL. 1 is an Integer, 3.14 is a Double.
        // The correct way is to explicitly type the initializer for mixed types.
        Number[] correctMixedArray = {Integer.valueOf(1), Double.valueOf(3.14)};
    Array initializer can not be passed directly as an argument to a method
        pass in {1,2,3,4} to a method that takes an int[]//  illegal start of expression
        // Correct way: Pass a new anonymous array
        printArray(new int[]{1, 2, 3, 4}); 
        // Correct way: Create a named array first
        int[] myArray = {1, 2, 3, 4};
        printArray(myArray);
    Arrays.sort(int[]) // increasing order  
    Arrays.sort(int[], (a,b) -> b.compareTo(a)) // Compiler Error !!!  No overloaded primitive int[] method
    int[] → Integer[] // casting not allowed autoboxing doesn't  apply to arrays 
    Arrays.sort(object[], Comparator.comparingInt( x -> x_to_int))
    Array.sort(Integer[], (a,b) -> b.compareTo(a)) // reverse sorting
    Arrays.fill -> char[] zeros = new char[n]; Arrays.fill(zeros, '0');
        - supports [from, to) ex: char[] zeros_1_to_3 = new char[n]; Arrays.fill(zeros, 1, 3 '0');
        - supports 1 Dim only
        - For 2 Dim's:
                int[][] mem = new int[n + 1][n + 1];
                Arrays.stream(mem).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE));
    No GenerArrays in Java only raw types.
        @SuppressWarnings("unchecked")
        List<String> [][] = new ArrayList[M][N]
    List<Integer> myIntList = Arrays.asList(int1, int2, int3)
    X List<Integer> myIntList = Arrays.asList(new int[]{int1, int2, int3}) // does NOT work - converts into a single int[] element in a list
    List<Integer> primes = Arrays.stream(new int[] {2, 3, 5, 7, 11, 13, 17, 19})
                            .boxed()
                            .collect(Collectors.toList());
    Arrays.stream only supports int[], long[] & double[]
    X Arrays.stream(char[]) // this is not supported
    arr.clone() // Shallow Copy
    A subarray is a contiguous subsequence of the array.

System:
    System.arraycopy(from,fromStart,to,toStart,fromLength)

Math
    Integer.MAX_VALUE
    Integer.MIN_VALUE
    for big constants use _ like long MAX = 1000_000_000;
    option A will result in overflow error, while B will not
        option A: long curr = 1000_000_000+1000_000_000+1000_000_000+1000_000_000;// nums[i]+nums[j]+nums[k]+nums[l];
        option B: long curr = nums[i];  curr += nums[j]; curr += nums[k]; curr += +nums[l];
    exponent:
        Math.pow(2,n)  -> returns double cast for int
        java has no power operator & Math.pow returns double and casting can cause issues
            int mod = 1_000_000_007; // 1e9 + 7
    1 << n -> left shift is same as 2 power n and directly int
    Math.abs(Integer.MIN_VALUE) as an int, it would still be -2,147,483,648 due to overflow
    Math::abs  int, long, float, double
    String bits = Integer.toString(n, base); 
        - String representation of int in a different base
        - not padded to 32 bits as higher order zero bits are ignored
    Double to int:
        int val = (int) 4.3 // 4
        int val = (int) 9.9 // 10
    Double:
        Math.round()
        Math.ceil()
        Math.floor()
    Math log:
        Natural Logarithm (base e): The Math.log(double a)
        Base 10 Logarithm: The Math.log10(double a)
        Logarithm to an arbitrary base:
            double value = 64.0;
            double base = 2.0;
            double customBaseLog = Math.log(value) / Math.log(base); // Calculates log2(64)
        Special Cases:
            If the argument to Math.log() or Math.log10() is NaN or a negative number, the result is NaN.
            If the argument is positive infinity, the result is positive infinity.
            If the argument is positive or negative zero, the result is negative infinity.
    GCD:
        Euclidean Algorithm:
            private int gcd(int a, int b) {
                a = Math.abs(a);
                b = Math.abs(b);
                if(b == 0) return a;
                return gcd(b, a % b);
            }

String
    convert String to int --> Integer.parseInt(String s) or Integer.valueOf(String s) // drops leading 0 & -ve sign is taken care when converting -123
    Integer.valueOf(String s) Integer.valueOf(int i) --> overloaded valueOf Integer
    String.valueOf(int i) String.valueOf(double price) --> overloaded valueOf String
    String.valueOf() overloads --> int, long, float, double, boolean, char, char[], and Object.
    Integer.parseInt("0003") will return the decimal value 3, not octal 3 ignoring any leading 0's
    str.substring(start, end)  ~  [start, end)
     -  IndexOutOfBoundsException when (*) start > end, (*) start or end > str.length(), (*) start or end < 0
     -  allowed: 0 <= start, end <= str.length()
    str.substring(end)  ~  [0, end)
    Integer.toString(i)
    str.contains(str2)
    str.isEmpty()
    str.endsWith(str2) & str.startsWith(str1) both take string arguments 
    str.toCharArray()
    str.charAt(index)
    str.chars() -> IntStream
    ex: queryIP.chars().filter(c -> c == ':').count() == 7
    str.chars().mapToObj( i -> (char)i) ->  Stream<Character>  //mapToObj on IntStream vs map on Stream<Character>
    int digit = chat - '0'
    ",a,b,c,".split(",") -> splits into 4. First is "" while the last is c 
    \ is an escape character (special meaning to compiler) whereas / is a regular char
    ., *, +, |, ?, \, ^, $, [, ], {, }, (, )  --> special chars needing escape \\.
    "1.2".split(".") return array of size zero --> as . matches all & all are "trailing empty strings"", they are discarded, leading to an array of size zero.
    "1.2".split("\\.") return array of size 2
    substring vs subsequence: primary distinction between a subsequence and a substring lies in the requirement of contiguity.
        - A substring is a contiguous sequence of characters within a string.
        - A subsequence is a sequence of characters derived from another sequence by deleting zero or more elements without changing the order of the remaining elements.

RegEx:
    String clean = s.replaceAll("\\s+",""); // drop all spaces

Matrix
    Spiral/MinOpsForY/Rotate

StringBuilder
    stringBuilder.reverse()
    sb.deleteCharAt(i)
    sb.setLength(0) // clear string Builder
Character
    Character.toLowerCase(c)
    check if character is alphanumeric -> Character.isDigit(c) || Character.isLetter(c)
    Character.isWhitespace(c), Character.isLowerCase(c),
    char ch = '7'; int asciiDigit = ch; // asciiOfDigit will be 55
    char ch = 'A'; int asciiValue = ch; // asciiValue will be 65
    char digitChar = '7'; int numericValue = digitChar - '0';// numericValue will be 7

Enum:
    Enum names are Capitalized, enum constants are CAPITAL

java operators:
    simple ternary return 
    return and assignment
        return memo[i][partsLeft] = res;
        store res in memo[i][partsLeft] and return the result
    assignment as expression
        int x;
        System.out.println(x = 42);
    java 14+ Enhanced Switch:
        String result = switch(op) {
            case '/' -> Integer.toString(n1/n2);
            case '*' -> Integer.toString(n1*n2);
            case '-' -> Integer.toString(n1-n2);
            case '+' -> Integer.toString(n1+n2);
            default -> Integer.toString(n1+n2);
        };
        allowed types for op: byte, short, char, int (primitive/boxed), String & Enum
        case null, default ->
        values used in the case labels must be compile-time constants not run time 

Bitwise:
    left shift:
        1 << n -> left shift same as 2^n  or Math.pow(2, n)
        x << n is equivalent to x * 2^n
    right shift:
        x >> n is equivalent to floor(x / 2^n)
        i >>> 1 -> unsigned right shift
        Used in: 
            Binary trie traversal
            Bitwise comparison from MSB to LSB
            Detecting when two numbers fall into different “bit groups”
        Example:   
            x = 13 → 1101b
            xbit = x >> 1
            xbit = 6 -> 110b
    check LSB:
        x & 1  -> check if LSB is 1 or not
    num1 ^ num2 -> bitwise xor that results in int 
    Bit Manipulation solutions don't rely on standard libraries
    * "Left to Lift (multiply), Right to Reduce (divide)."
    n is a power of 2 if and only if n>0 and (n & (n - 1)) == 0
        - The key insight is that any power of 2 (e.g., 4, 8, 16) has only one bit set to '1' in its binary form. Subtracting 1 from that number flips the '1' to a '0' and all trailing '0's to '1's. This means a bitwise AND operation between a number and its predecessor will result in 0 only if the number is a power of 2.
    >> = Arithmetic right shift
        -   Preserves the sign.
        -   For negative numbers, the MSB = 1 (sign bit) is replicated on the left.
    >>> = Logical right shift
        -   Does NOT preserve sign.
        -   Zero is shifted into the MSB.

Boolean:
    ^ - Boolean version of XOR // no shortcut as both operands need eval
    DIY XOR: boolean negative = (dividend < 0) != (divisor < 0)

java.util.Random:
    random.nextInt(), nextLong(), nextDouble(), nextBoolean()
    random.nextInt(hi) [0, hi)
    random.nextDouble() // Generate random double between 0.0 and 1.0
    alternatively, Math.random() // Generate a random double between 0.0 and 1.0
    
casting:
    long to int, double to int -> explicit - narrow/lossy, possible overflow
    int to long, char to int -> auto - widening
    Gotcha's:
    When adding an int to a List<Double>, casting is required because Java cannot perform primitive widening and autoboxing in a single step. 
    While an int can automatically widen to a double when assigned to a variable, generic collections like List<Double> work only with objects, not primitives.

# Java Versions/Releases:
Java 8 additions as three parallel upgrades:
    #1  Streams API => stream(), map, filter, collect
    #2  Functional interfaces + lambdas => Function, BiFunction, Predicate
    #3  Enhanced Collections API => Map.merge, computeIfAbsent, forEach, replaceAll
        Map.merge belongs to #3, powered by #2, but not #1.
