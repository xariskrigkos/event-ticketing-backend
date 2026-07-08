# Event Ticketing Backend

A backend REST API for an event ticketing system built with Java, Spring Boot, and PostgreSQL.

This project was created to deepen my understanding of backend software engineering beyond basic CRUD applications by implementing business logic, entity relationships, and database persistence.

> Current release: **V1**

---

## Current Features

- RESTful API built with Spring Boot
- CRUD operations for Users, Events, Venues, Reservations, and Tickets
- Optimistic locking to prevent ticket overselling during concurrent reservations
- Multi-ticket reservation support
- DTO-based API responses
- Pagination for collection endpoints
- OpenAPI / Swagger documentation
- k6 load testing for concurrent reservation validation
- Global exception handling
- Spring Data JPA + PostgreSQL
---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman
- k6
- Git

---

## Project Structure

```
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

The application follows a layered architecture separating HTTP handling, business logic, and data access.

---

## Current Business Flow

```
User
    ↓
Creates Reservation
    ↓
Reservation stored as PENDING
    ↓
Available tickets updated
    ↓
Reservation fulfilled
    ↓
Tickets automatically generated
```

---

## V1 Highlights

- RESTful API
- DTOs
- Validation
- Exception handling
- Entity relationships
- PostgreSQL persistence
- Business logic implementation
- End-to-end testing with Postman

---

## Roadmap

### V2 Highlights
- Transactions
- Optimistic/Pessimistic locking
- Concurrency handling
- Prevent ticket overselling
- k6 Stress testing
- Response DTOs
- Pagination

### V3
- Authentication & Authorization
- JWT
- Filtering & searching
- React frontend

### V4
- Docker
- CI/CD
- Unit & Integration testing
- Monitoring
- Production deployment

---

## Status


This project is actively being developed and improved as I continue learning backend software engineering.

Feedback and suggestions are always welcome and suggested as I am trying to improve constantly.
