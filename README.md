# 🏠 Rental Management System – Backend

A full-featured **Rental Management Backend Application** built using **Spring Boot**.  
This system allows property owners and tenants to manage rental properties, payments, requests, reviews, and saved properties efficiently.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- DevTools
- REST APIs

---

## 📌 Project Overview

This backend provides REST APIs for:

- User Registration & Login
- Property Management
- Property Image Upload
- Tenant Rental Requests
- Rental Approval Workflow
- Payment Processing
- Owner Payment Tracking
- Saved Properties
- Reviews & Ratings
- Active Rentals Management
- Search & Filtering

The project follows a **layered architecture** with proper separation of concerns.

---

## 🏗️ Project Structure

├── dir1
│   ├── file11.ext
│   └── file12.ext
├── dir2
│   ├── file21.ext
│   ├── file22.ext
│   └── file23.ext
├── dir3
├── file_in_root.ext


---

## 🧠 Architecture

This project follows a **Layered Architecture Pattern**:

1. **Controller Layer**
   - Handles HTTP requests
   - Maps endpoints
   - Communicates with services

2. **Service Layer**
   - Contains business logic
   - Processes validation and workflows

3. **Repository Layer**
   - Handles database operations
   - Extends Spring Data JPA repositories

4. **DTO Layer**
   - Used for request and response mapping
   - Prevents direct exposure of entities

5. **Mapper Layer**
   - Converts between Entity ↔ DTO
   - Keeps controllers clean

---

## 🔑 Key Features

### 👤 User Module
- User registration
- Login authentication
- Role-based logic (Owner / Tenant)

### 🏠 Property Module
- Add property
- Upload property images
- Update & delete property
- Search & filter properties

### 📨 Tenant Request Module
- Tenant can request a property
- Owner can approve/reject
- Automatic update after approval

### 💳 Payment Module
- Record rental payments
- Owner payment tracking
- Payment history

### ⭐ Review Module
- Add review for property
- Retrieve property reviews

### ❤️ Saved Properties
- Save property
- Retrieve saved list

### 📡 WebSocket Support
- Real-time property updates (via WebSocketConfig)

---

## 🔄 Design Principles Used

- Layered Architecture
- Separation of Concerns
- DTO Pattern
- Repository Pattern
- Service Abstraction
- Clean Code Practices

---

## ▶️ How to Run

1. Clone the repository
2. Configure `application.properties`
3. Set up MySQL database
4. Run:

Or run `RentalManagementApplication.java`

---

## 📈 Future Improvements

- Spring Security with JWT
- Role-based authentication
- Payment gateway integration
- Unit & Integration testing
- Docker deployment

---

## 👨‍💻 Author

**Lokesh**  
Aspiring Java Full Stack Developer  
Spring Boot | React | MySQL | REST APIs

---


