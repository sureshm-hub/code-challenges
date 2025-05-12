1)  Ask Clarifying Questions:
   - what are the inputs
   - what are the outputs
   - restate the problem in your own words to confirm understanding.
   - are there any input, output, time or space constraints
   - come up with the API

2) Come up with an example test cases
    - happy path test case
    - Edge test cases
   
3) Come up with a basic solution
    - Straight forward approach, doesn't have to be optimal
    - Avoid coding - focus on idea
    - Acknowledge limitations
    - State time/space complexity even if it is bad

4) Optimize the basic solution
    - leverage data structures
    - walk through a test case
   
5) Implement the solution
   - Write Clean and Functional Code
     - Input Validation
     - Variable naming 
     - data structures
   - Use appropriate variable names
   - Test it verbally, keep communicating!

6) Analyze Complexity
    - Time Complexity of all important steps
    - Space Complexity of all important steps
    - **Explain** trade-offs

7) Handle Edge Cases
    - null, empty inputs
    - null, empty outputs
    - early exits

8) Discuss Follow-Ups or Improvements
    - Anticipate interviewer follow-ups
    - Suggest improvements like **Scaling** 
      - **Be Ready** to discuss scaling for large inputs (e.g., streaming lists from disk) or handling duplicate values.
    - **Highlight** Leadership Principles  like **Deep Dive** eg: by explaining heap operations, **invent & simplify** eg: by proposing dummy node approach.

## Example Walkthrough (Two Sum)
Clarify: “Can the array have duplicates? Should I return the first pair I find?”
Test Case: “Let’s try [2, 7, 11, 15] with target = 9 → [0, 1].”
Basic Solution: “I could use two loops to check all pairs—O(n²).”
Refine: “A hash map would store target - num and give O(n).”
Implement: ...
Complexity: “O(n) time for one pass, O(n) space for the hash map.”
Edge Cases: “Empty array returns []. No solution returns [].”
Follow-Up: “If we need all pairs, I’d modify it to collect multiple results.”

## Complexity Guidelines
For DFS - include recursion stack for space complexity

## solving coding problems in under 8 minutes
Time Allocation (approximate):

0:00–1:00: Clarify problem, restate, define API (1 min)
1:00–2:00: Example test cases, edge cases (1 min)
2:00–3:30: Propose basic solution, state complexity (1.5 min)
3:30–5:30: Optimize solution, walk through test case (2 min)
5:30–7:00: Write clean code, verbally test (1.5 min)
7:00–8:00: Analyze complexity, handle edge cases, mention follow-ups (1 min)

Key Tips for 8-Minute Success
**Practice Conciseness**: Skip unnecessary details (e.g., don’t over-explain test cases).
**Leverage Constraints**: For Two Sum II, the sorted array screams “two pointers” or “binary search.” Recognize patterns instantly.
**Communicate Constantly**: Narrate every step briefly (e.g., “I’m using two pointers to exploit the sorted property”).
**Prioritize Optimal Solution**: For Medium problems, brute force is rarely acceptable. Jump to the optimized approach if you recognize the pattern (e.g., two pointers for sorted arrays).
**Mock Interviews**: Practice solving Medium problems in 6–8 minutes with a timer to build speed.
**Pattern Recognition**: Memorize common patterns (e.g., two pointers, sliding window, hash maps) to skip the brute-force step.