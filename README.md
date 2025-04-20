# 📧 Email Notification Service

The **Email Notification Service** is responsible for sending automated email notifications for various user actions such as account registration, order updates, and payment confirmations. It integrates with **Kafka** for event-driven communication and supports SMTP for email delivery.

---

## ⚙️ Core Functionalities

### 1. Email Notifications
- Sends email notifications to users for key events:
    - **Account registration** 
    - **Order status updates**
    - **Payment confirmations**
- Supports dynamic email content based on user actions.

### 2. Event-Driven Communication
- Integrates with **Kafka** to listen for events from other services.
- Consumes events like:
    - **User SignUp**
  

### 3. SMTP Integration
- Uses **SMTP** protocol to send emails.
- Supports customizable email templates.

---

## 🔒 Security

- **Authentication and Authorization**:
  - Uses **OAuth2** for secure API access.
  - Only authorized services can trigger email events.

---

## 🧩 Technologies Used

- **Java / Spring Boot** for service development.
- **Kafka** for event-driven architecture.
- **SMTP** for email delivery.

---

## 🌐 Microservice Architecture

The **Email Notification Service** is part of a larger **microservice ecosystem** with **API Gateway** integration, managed through **Eureka** for service discovery.

---

## 🚀 How to Run

1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```

2. Build and run the service:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Access the service through the API Gateway for communication with other microservices.

---

## 🧑‍💻 Contributors

- [Ridhim Singh Raizada]


