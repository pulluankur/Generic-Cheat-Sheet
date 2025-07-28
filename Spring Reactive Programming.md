# 📘 Reactive Types in Project Reactor

## 🚀 Reactive Types Overview

| Type      | Emits         | Description                                      |
|-----------|---------------|--------------------------------------------------|
| `Mono<T>` | 0 or 1 item   | Represents a single async value or no value      |
| `Flux<T>` | 0 to N items  | Represents a stream of multiple async values     |

---

## 🔹 `Mono<T>` – Zero or One Value

Used when you expect a **single value or none**, such as an HTTP response returning 200 OK or 404 Not Found.

### ✅ Example:

```java
Mono<String> mono = Mono.just("Hello Mono");

mono.subscribe(System.out::println); // Output: Hello Mono
🔧 Common Mono Methods:
Mono.just(T data) – creates a Mono with data.

Mono.empty() – creates a Mono with no data.

Mono.error(Throwable) – creates a Mono that signals an error.

map(), flatMap() – transform the result.

then() – chain after completion.

🔹 Flux<T> – Zero to Many Values
Used when you expect a stream of data, such as a list of users or a continuous stream from a socket.

✅ Example:
Flux<String> flux = Flux.just("A", "B", "C");

flux.subscribe(System.out::println);
// Output: A
//         B
//         C
🔧 Common Flux Methods:
Flux.just(...) – from known elements.

map(), flatMap() – transform each item.

filter() – filter values based on a condition.

concat(), merge() – combine multiple streams.

⚡ Mono vs Flux Summary
Feature	    Mono<T>	                Flux<T>
Emission	0 or 1 item	        0 to N items
Use case	Single value            multiple items
Completion	After one emit	        After all emits


🧠 Where Used in Spring WebFlux?
🧩 Controller Examples
@GetMapping("/user/{id}")
public Mono<User> getUser(@PathVariable String id) {
    return userService.findById(id);
}

@GetMapping("/users")
public Flux<User> getAllUsers() {
    return userService.findAll();
}