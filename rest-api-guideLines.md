# ✅ REST API Design Guidelines

## 🔹 1. Use Meaningful Resource URIs
- Use **nouns**, not verbs
    - ✅ `/users` → get/create users
    - ✅ `/users/{id}` → get/update/delete a user
    - ❌ `/getUser`, `/createUser`

### 📌 Example API Requests
```http
GET    /api/v1/users       → Get all users  
GET    /api/v1/users/1     → Get user by ID  
POST   /api/v1/users       → Create user  
PUT    /api/v1/users/1     → Update entire user  
PATCH  /api/v1/users/1     → Partial update  
DELETE /api/v1/users/1     → Delete user

🔹 2. Use Standard HTTP Methods
Method	Purpose
GET	Retrieve resource(s)
POST	Create a new resource
PUT	Replace entire resource
PATCH	Partially update resource
DELETE	Remove resource

🔹 3. Use Plural Resource Names
✅ /users instead of /user

🔹 4. Use Proper Status Codes
Code	Meaning
200	OK
201	Created
204	No Content
400	Bad Request
401	Unauthorized
404	Not Found
500	Server Error

🔹 5. Use Query Parameters for Filtering, Sorting, Pagination
Examples:
/users?page=2&limit=10

/products?sort=price&category=books


🔹 6. Maintain Statelessness
Each request should be independent

Must contain all necessary info (e.g., Auth token in headers)

🔹 7. Use JSON for Request/Response Format
{
  "id": 1,
  "name": "Alice"
}

🔹 8. Version Your APIs
Use URL versioning
Example: /api/v1/users

🔹 9. Handle Errors Gracefully
Return meaningful, structured error messages
{
  "timestamp": "2025-07-28T10:45:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Email is required"
}