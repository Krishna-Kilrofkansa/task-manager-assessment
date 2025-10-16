# Full-Stack Task Manager Dashboard

This is a full-stack web application built as a practical assessment to demonstrate skills in frontend, backend, and database development. The application is a simple "Task Manager Dashboard" that allows users to perform CRUD operations on tasks and view an audit log of all actions.

## Screenshot
<img width="1919" height="908" alt="image" src="https://github.com/user-attachments/assets/37a7c4a4-3759-4399-94e4-57fc551bc21c" />

<img width="1919" height="911" alt="image" src="https://github.com/user-attachments/assets/e3e3a359-a930-4f44-8936-5972ef71a352" />

## Demo Video
[Link to Demo Video](https://youtu.be/XDq5qpJ8orM)

## Features

  - [cite\_start]**Full CRUD Operations:** Create, Read, Update, and Delete tasks[cite: 12].
  - [cite\_start]**Task Filtering:** A search bar to filter tasks by title or description in real-time[cite: 109].
  - [cite\_start]**Pagination:** The task list is paginated, showing 5 tasks per page[cite: 110].
  - [cite\_start]**Audit Logging:** Every create, update, and delete action is recorded in a detailed audit log for traceability[cite: 14, 195].
  - [cite\_start]**Secure API:** The backend API is protected with static Basic Authentication[cite: 216].
  - [cite\_start]**Responsive UI:** The frontend is designed to be responsive and user-friendly on desktop and tablet devices[cite: 85].
  - [cite\_start]**Form Validation:** Both frontend and backend validation are in place to ensure data integrity[cite: 150, 211].

## Tech Stack

#### **Backend**

  - **Framework:** Spring Boot
  - **Language:** Java (JDK 17)
  - **Database:** H2 In-Memory Database
  - **Security:** Spring Security (Basic Authentication)
  - **Data Access:** Spring Data JPA / Hibernate
  - **Build Tool:** Maven

#### **Frontend**

  - **Framework:** Angular
  - **Language:** TypeScript
  - **Styling:** SCSS
  - **API Client:** Angular `HttpClient`
  - **Icons:** Font Awesome

## Getting Started

To run this project locally, you will need two separate terminals: one for the backend and one for the frontend.

### Prerequisites

  - Java JDK 17 or later
  - IntelliJ IDEA or another Java IDE
  - Node.js and npm
  - Angular CLI (`npm install -g @angular/cli`)
  - Git

### 1\. Backend Setup

```bash
# Clone the repository
git clone https://github.com/your-username/task-manager-assessment.git

# Navigate to the project directory
cd task-manager-assessment

# Open the 'backend' folder in your preferred Java IDE (e.g., IntelliJ IDEA).
# The IDE will automatically resolve the Maven dependencies.

# Run the main application file:
# src/main/java/com/taskmanager/backend/BackendApplication.java
```

The backend server will start on `http://localhost:8080`.

### 2\. Frontend Setup

```bash
# Open a new terminal and navigate to the project directory
cd task-manager-assessment/frontend

# Install the necessary npm packages
npm install

# Start the Angular development server
ng serve
```

The frontend application will be available at `http://localhost:4200`.

## API Authentication

All API endpoints are protected. To access them, use the following static credentials with Basic Authentication:

  - [cite\_start]**Username:** `admin` [cite: 219]
  - [cite\_start]**Password:** `password123` [cite: 220]

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/tasks` | [cite\_start]Fetch a paginated list of tasks, with optional filtering[cite: 161]. |
| `POST` | `/api/tasks` | [cite\_start]Create a new task[cite: 164]. |
| `PUT` | `/api/tasks/:id` | [cite\_start]Update an existing task[cite: 166]. |
| `DELETE` | `/api/tasks/:id` | [cite\_start]Delete a specific task[cite: 167]. |
| `GET` | `/api/logs` | [cite\_start]Fetch all audit log entries[cite: 170]. |
