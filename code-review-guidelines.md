# ✅ Approach to Code Review

## 1. Understand the Context
- Start with the **purpose of the code change** (check PR description, related ticket/story).
- Ask:
    - _What problem is this solving?_
    - _Is this the right approach?_

## 2. Check for Functionality
- Does the code do what it's supposed to do?
- Test locally if needed or ask the author for **test evidence** (screenshots, logs, etc.).
- Ensure **edge cases** and **error handling** are covered.

## 3. Readability & Maintainability
- Is the code **clean**, **simple**, and **self-explanatory**?
- Are **variable/method names meaningful**?
- Is it broken into **small, focused methods**?
- Avoid **deep nesting** and **long classes/methods**.

## 4. Code Structure & Design
- Is it aligned with the project’s **design patterns and architecture**?
- Are **SOLID principles**, **DRY**, and **separation of concerns** respected?
- Is code **reusable where appropriate**?

## 5. Correctness and Edge Cases
- Any potential for **null pointers**, **race conditions**, or **data leaks**?
- Is **input validation** and **sanitization** handled?
- Is **thread safety** ensured (especially for shared/singleton resources)?

## 6. Performance
- Are there **unnecessary loops**, **nested iterations**, or **inefficient DB/API calls**?
- Is **large data** handled efficiently?

## 7. Tests
- Are there **unit**, **integration**, or **functional tests** for the changes?
- Is **code coverage adequate**?
- Do tests cover both **positive** and **negative paths**?

## 8. Version Control Hygiene
- **Small, focused commits** with meaningful messages?
- No **debug prints**, **commented code**, or **unnecessary files** committed?

## 9. How to Give Feedback
- Be constructive and specific:
❌ “This code is bad.”
✅ “This method is too long; can you break it down for readability?”

- Ask questions instead of commands:
“What do you think about using a Map here instead of multiple ifs?”

- Praise good code too! 🙌
“Nice use of Optional here—makes it very clean.”

