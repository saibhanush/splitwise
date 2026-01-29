Technical Architecture
Technology Stack:
Java with Spring Boot framework
JPA/Hibernate for ORM
RESTful API design
Maven for dependency management
JUnit 5 & Mockito for testing
Design Patterns & Best Practices:
Layered Architecture: Clear separation between Controllers, Services, DTOs, and Repositories
Dependency Injection: Leveraging Spring's IoC container
DTO Pattern: Using Data Transfer Objects (CreateExpenseDto, CreateUserDto, GetUserDto) for API communication
Repository Pattern: Data access abstraction with ExpenseRepository and UserRepository
Interface Segregation: Custom interfaces like PasswordEncoder and BCryptEncoder for security
Key Features
User Management: User creation and retrieval with secure password encoding
Expense Tracking: Individual and group expense management
Group Functionality: Support for shared expenses across multiple users
Multi-currency Support: Built-in Currency enum for international transactions
Security Implementation
Password encryption using BCrypt algorithm
Custom encoder interface for flexibility and testability
Data Modeling
Inheritance: BaseModel as abstract base class for common fields
JPA Relationships:
@ManyToOne for group associations
@OneToOne for expense linking
Testing Strategy
Unit tests with JUnit 5
Mocking dependencies with Mockito
Service layer test coverage (UserServiceTest)
Scalability Considerations
Modular service architecture
Database abstraction through repositories
Extensible design for adding features
