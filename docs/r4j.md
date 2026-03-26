# Resilience4j

## Core Concepts
### What is Resilience4j and why is it preferred over Hystrix?
- Lightweight, modular fault tolerance library for Java
- Built for Java 8+ (functional style, lambdas)
- No thread pool overhead (unlike Hystrix)
- Works well with Spring Boot (annotations + programmatic)
- More flexible → compose patterns (Retry + CircuitBreaker + RateLimiter)

### What failure scenarios does Resilience4j help handle?
- Transient failures (network timeouts)
- Downstream service outages
- Latency spikes
- Rate limiting / throttling
- Bulkhead isolation

## Circuit Breaker Deep Dive
### Circuit Breaker states
- CLOSED → normal flow
- OPEN → fail fast
- HALF_OPEN → test recovery
- Features:
    - Uses sliding window (count/time based)
    - Failure rate threshold triggers OPEN
    - HALF_OPEN allows limited test calls
        - CircuitBreaker is OPEN (too many failures)
        - It waits for "waitDurationInOpenState"
        - After that timeout → transitions to HALF_OPEN
            - Allows limited test calls (permittedNumberOfCallsInHalfOpenState)
            - Based on results:
                - Success → CLOSED
                - Failure → back to OPEN

### Difference between count-based vs time-based sliding window?
- Count-based → last N calls
    - Count-based predictable for load testing
- Time-based → last X seconds
    - Time-based better for uneven traffic

### What happens if CircuitBreaker + Retry are combined incorrectly?
- Retry can amplify load
- Can trip circuit faster
- Needs ordering control:
    - Retry inside CircuitBreaker → safer
    - CircuitBreaker inside Retry → risky

## Retry Pattern
### When should you NOT use retry?
- Non-idempotent operations (payments)
- Persistent failures (DB down)
- Long latency calls (worsens SLA)

### What is exponential backoff and why needed?
- Prevents retry storm
- Reduces pressure on downstream

### Multi Client backpressure
- Add jitter to avoid synchronized retries

## Bulkhead (Isolation)
### Explain Bulkhead pattern
- Limits concurrent calls to dependency
- Prevents one service from exhausting resources
- Types:
    - Semaphore-based
    - Thread pool-based

### When would you use Bulkhead vs CircuitBreaker?
- Bulkhead → **resource protection**
- CircuitBreaker → **failure detection + fast fail**
    - Bulkhead is mainly a caller-side resilience pattern, while servers use
      thread-pool or worker isolation to achieve the same principle internally.
- Bulkhead prevents cascading failures **even before** CB trips

## Rate Limiter
### How does RateLimiter work?
- Limits number of calls per time period - Fair Usage, prevent DDoS
- Uses token bucket / fixed window
- Use cases:
    - Protect downstream APIs
    - Control burst traffic
        - HTTP 429 "Too Many Requests"
- Resiliency pattern that restricts the number of requests to a service
  within a specific time window.
- Can be client side or server side + Popular as middleware component
    - API Gateway → Middleware / Edge (server-side, inbound)
    - Controller Layer → Server-side (inside your app, inbound requests)
    - Service Layer → Client-side (outbound calls to downstream services)
    - Custom Filters → Server-side cross-cutting (inbound, request pipeline)

- Inbound traffic (users → your service)
    - → Gateway, Filters, Controllers → server-side protection
- Outbound traffic (your service → other services)
    - → Service layer → client-side protection (Resilience4j typical use)

## TimeLimiter (Timeout Control)
- Cancels long-running calls
- Works with async futures
- Combine with CircuitBreaker for latency-based failures

## Composition _**VERY IMPORTANT**_
### How do you combine multiple resilience patterns?
  ```java Example:
    
    Decorators.ofSupplier(() -> service.call())
        .withCircuitBreaker(cb)
        .withRetry(retry)
        .withRateLimiter(rateLimiter)
        .get();
  ```

### What is the correct order of execution?
Typical safe order: **Logical Order** not Wrapping Order
RateLimiter → Bulkhead → TimeLimiter → CircuitBreaker → Retry
- Why:
    - Limit traffic first
    - Protect resources
    - Timeout early
    - Detect failures
    - Retry last

## Spring Boot Integration -  How to configure Resilience4j in Spring Boot?

  ```yaml
  application.yml
  
  resilience4j:
    circuitbreaker:
      instances:
        myService:
          failureRateThreshold: 50
          slidingWindowSize: 10
  ```

Usage

  ```java 
    @CircuitBreaker(name = "myService", fallbackMethod = "fallback")
    public String callService() { ... }
  ```
### What is fallback method?
- Executes when failure happens in any of the R4J patterns
    - Retry
    - RateLimiter
    - Bulkhead
    - TimeLimiter
    - CircuitBreaker
- Should be lightweight
- Must match method signature

## Observability & Metrics - monitor Resilience4j in production
- Micrometer integration
- Prometheus + Grafana dashboards
- Metrics:
    - failure rate
    - slow call rate
    - state transitions

### What alerts would you set?
- Circuit OPEN spikes
- Retry count surge
- Slow call threshold breaches

## Real System Design Scenarios _**Very Important**_
### You call a payment service — design resilience
CircuitBreaker → avoid cascading failure
_**NO retry (non-idempotent)**_
Timeout enforced
Fallback → mark transaction pending

### Kafka consumer calling external API — what patterns?
Retry with backoff - _**Requires Consumer or Business Side Dedup**_
CircuitBreaker
Bulkhead (thread isolation)
DLQ for failures

### High traffic microservice (1M users) — how to scale resilience?
- Use RateLimiter to protect microservices
    - prevent DDoS
    - enforce fair usage
    - orderly degradation
- We can achieve Distributed throttling using
    - API Gateway
    - Service-Level
- Tune CB thresholds dynamically
- Avoid retry storms (global policy)
- Add caching fallback
``` 
High-Level System Architecture Diagram - More specifically:
C4 Model → Level 2 (Container Diagram)
shows major components and interactions
In interview terms:
  - Also called a “Service Interaction / Request Flow Diagram”
  - Sometimes framed as a “Resilience Architecture Overlay”

            ┌──────────────────────┐
User -----> │   API Gateway        │
            │ (Rate Limit, Auth)   │
            └─────────┬────────────┘
                      │
            ┌─────────▼────────────┐
            │  Service (Inbound)   │
            │ Filters / Controller │  ← server-side rate limit (optional)
            └─────────┬────────────┘
                      │
            ┌─────────▼────────────┐
            │   Business Logic     │
            └─────────┬────────────┘
                      │
        ┌─────────────▼─────────────────────────┐
        │   Resilience4j (Outbound / Client)    │
        │ RateLimiter → Bulkhead → TimeLimiter  │
        │ → CircuitBreaker → Retry              │
        └─────────────┬─────────────────────────┘
                      │
            ┌─────────▼────────────┐
            │  Downstream Service  │
            └─────────┬────────────┘
                      │
               (Failure / Slow)
                      │
            ┌─────────▼────────────┐
            │     Fallback         │
            │ Cache / Default / MQ │
            └──────────────────────┘
```

## Advanced Edge Cases (L5 signal questions)
### What is slow call rate in CircuitBreaker?
- Tracks latency-based failures
- Trips CB even if responses succeed but are slow

### How do you handle partial failures in batch calls?
- Use bulkhead per partition
- Retry per item
- Aggregate failures separately

### How does Resilience4j behave in async/reactive systems?
- Works with:
    - CompletableFuture
    - Reactor (Mono/Flux)
    - Non-blocking support

## Common Pitfalls - Biggest mistakes engineers make?
- Overusing retry → cascading failure
- No timeout → thread exhaustion
- Wrong CB thresholds
- No observability
- Ignoring idempotency

## Conclusion:
Resilience4j is not just about adding annotations — it’s about controlling
failure modes in distributed systems.
The key is choosing the right combination and order of patterns based on
failure characteristics like:
latency,
error rate, or
resource exhaustion
and handling them through metrics, creating scalable backend systems

### References:
* https://medium.com/@noushka99anu/understanding-rate-limits-in-java-springboot-using-resilience4j-b7f3d9ee0715