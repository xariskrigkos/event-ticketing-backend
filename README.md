# Event Ticketing Backend

A backend REST API for an event ticketing system built with Java, Spring Boot, and PostgreSQL.

This project was created to deepen my understanding of backend software engineering beyond basic CRUD applications by implementing business logic, entity relationships, and database persistence.

> Current release: **V1**

---

## Features

### Users
- Create users
- Update user information
- Delete users
- Retrieve users

### Venues
- Create venues
- Update venue details
- Delete venues
- Retrieve venues

### Events
- Create events
- Update title, location, venue and start time
- Delete events
- Retrieve events

### Reservations
- Create reservations
- Automatic ticket availability validation
- Automatic ticket count updates
- Fulfill reservations
- Delete reservations

### Tickets
- Automatic ticket generation after reservation fulfillment
- Retrieve tickets by ID

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

### V2
- Transactions
- Optimistic/Pessimistic locking
- Concurrency handling
- Prevent ticket overselling
- Stress testing

### V3
- Authentication & Authorization
- JWT
- Response DTOs
- Pagination
- Filtering & searching
- API documentation (OpenAPI / Swagger)

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

This project is actively being developed and improved as I continue learning backend software engineering.

Feedback and suggestions are always welcome.
