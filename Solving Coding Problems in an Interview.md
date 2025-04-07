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
   - Use appropriate variable names
   - Test it verbally, keep communicating!

6) Analyze Complexity
    - Time Complexity of all important steps
    - Space Complexity of all important steps
    - mention trade-offs

7) Handle Edge Cases
    - null, empty inputs
    - null, empty outputs
    - early exits

8) Discuss Follow-Ups or Improvements
    - anticipate interviewer follow-ups
    - suggest improvements

## Example Walkthrough (Two Sum)
Clarify: “Can the array have duplicates? Should I return the first pair I find?”
Test Case: “Let’s try [2, 7, 11, 15] with target = 9 → [0, 1].”
Basic Solution: “I could use two loops to check all pairs—O(n²).”
Refine: “A hash map would store target - num and give O(n).”
Implement: ...
Complexity: “O(n) time for one pass, O(n) space for the hash map.”
Edge Cases: “Empty array returns []. No solution returns [].”
Follow-Up: “If we need all pairs, I’d modify it to collect multiple results.”