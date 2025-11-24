Matchsticks to Square:  

typical -Xss is 1 - 2 MB. For "Matchsticks to Square" max depth is 16 we are no where near Xss or SO

1. What limits call depth?
    Max call depth ≈ stack size (bytes) / stack frame size per call (bytes) 
    - Where “stack frame size” depends on:
      - How many local variables you have (ints, objects, arrays, etc.).
      - How many parameters.
      - Whether the JIT inlines some calls (which removes stack frames).
      - 32-bit vs 64-bit JVM, compressed oops, etc.
    - A frame might be on the order of tens of bytes (say 32–128 bytes as a rough range).
      - Using 64 bytes as a rough mid-point:
      - 1 MB / 64 B ≈ 16,000 recursive calls.
      - 2 MB / 64 B ≈ 32,000 recursive calls.
      - So, rule of thumb:
            -Xss1m: a few thousand to maybe tens of thousands of recursive calls.
            -Xss2m: roughly double that.

2. 4 ^ 15 is ~ 1 billion total possibilities but real call depth is much lower
   - Recursion depth vs number of calls
   - Important: that’s a bound on total number of calls, not how deep the stack goes. Depth is still at most n.
    selected starts at n - 1 and goes down to -1.  With n ≤ 15, max recursion depth = n + 1 ≤ 16. 
    So stack depth is at most 16 frames. That never changes, no matter how many branches you try.
       1. Recursion depth vs number of calls
       2. Where does the 4ⁿ come from?
       3. Why you don’t actually hit ~1B calls in practice
       4. So: big branching factor in theory, shallow recursion in practice — and the pruning keeps you far away from exploring all 4¹⁵ branches.