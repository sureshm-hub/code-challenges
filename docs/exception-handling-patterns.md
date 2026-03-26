# Patterns for Exception Handling

1. Exception Wrapper Pattern
How: All exceptions thrown by methods in a peculiar package should be wrapped into peculiar exceptions.
When: This pattern is very useful if the code is to be shipped in the form of Java libraries
Why: Re-throwing exceptions will show implementation details to the client, which should be hidden.

2. Fault Barrier Pattern
* Faults are non-recoverable errors to be handled with unchecked exceptions.
* Contingencies are recoverable errors to be handled with checked exceptions.

How: “In the fault barrier pattern, any application component can throw a fault exception, but only the component 
acting as the ‘fault barrier’ catches them.” Source. The fault barrier component should record the information 
contained in the fault exception for future action (logging) and close out the operation in a controlled manner.

3. Exception Bouncer Pattern
* This pattern should also be called the “Validator Pattern”. It is a way of implementing the beans validations using 
exceptions, which is the best way of doing it, in my opinion.

How: It defines methods that just throw exceptions based on validations.
When: It can be used in any application that needs input validation.

4. Error Code Pattern

How: It gives a specific code number for each checked exception.
When: It can be used in any Java project that uses checked exceptions as business errors.

https://gaetanopiazzolla.github.io/java/2023/03/05/java-exception-patterns.html

# exception handling relies on four specific patterns

##  Core message:
exceptions should be rare, meaningful control-flow breaks, not a general-purpose error mechanism sprinkled across every 
method using try/catch

### Pattern 1: Validate first, catch rarely
### Pattern 2: Custom, domain exceptions
### Pattern 3: Centralized handling at boundaries
### Pattern 4: Fail fast, don’t hide errors

https://medium.com/stackademic/junior-devs-use-try-catch-everywhere-senior-devs-use-these-4-exception-handling-patterns-dcd869ed6551