# 🏠 Rental Management Application

A full-stack **Rental Management System** built using **Spring Boot, JPA, React JS, WebSockets, and MySQL**.  
This application allows **property owners** to manage listings and **tenants** to search, request, and rent properties with **real-time updates**.

---

## 🚀 Tech Stack

### Backend
- Spring Boot
- Spring Data JPA
- Spring Security
- WebSockets
- MySQL
- Hibernate
- Maven

### Frontend
- React JS
- REST APIs
- WebSocket Integration
- Responsive UI

---

## ✨ Key Features

### 👤 User Roles
**Property Owner**
- Add, edit, and remove properties
- View tenant requests
- Approve or reject rental requests

**Tenant**
- Search and filter properties
- Send rental requests
- Track request status

### 🔐 Security
- Role-based authentication & authorization
- Secure REST APIs
- JWT-based login

### ⚡ Real-Time Updates
- Instant notifications for rental requests
- Status updates using **WebSockets**

### 🗄️ Database
- Optimized MySQL schema
- Efficient entity relationships
- JPA + Hibernate ORM

---

## 🏗️ System Architecture

```text
React Frontend
      |
REST APIs / WebSockets
      |
Spring Boot Backend
      |
Spring Data JPA
      |
MySQL Database
