# Task Manager Dashboard - Setup Instructions

## Current Status
✅ **Frontend is ready and working with mock data**
❌ **Backend has compilation issues**

## Quick Start (Frontend Only)

1. **Navigate to frontend directory:**
   ```bash
   cd frontend
   ```

2. **Install dependencies (if not already done):**
   ```bash
   npm install
   ```

3. **Start the development server:**
   ```bash
   ng serve
   ```

4. **Open your browser and go to:**
   ```
   http://localhost:4200
   ```

## What Works Now

The frontend is fully functional with a **mock backend service** that provides:

- ✅ **Task Management**: Create, edit, delete tasks
- ✅ **Search & Filter**: Real-time task filtering
- ✅ **Pagination**: Navigate through tasks (5 per page)
- ✅ **Audit Logs**: View all operations with color coding
- ✅ **Form Validation**: Title (100 chars) and description (500 chars) limits
- ✅ **Dark Theme**: Responsive design
- ✅ **Navigation**: Sidebar with Tasks and Audit Logs pages

## Backend Issues

The Spring Boot backend has compilation issues. To fix:

1. **Ensure Java 17+ is installed**
2. **Use an IDE like IntelliJ IDEA or Eclipse**
3. **Import the backend project as a Maven project**
4. **Resolve any dependency issues**
5. **Run the BackendApplication.java main method**

## Switching to Real Backend

Once the backend is running on `http://localhost:8080`:

1. **Open:** `src/app/services/task.service.ts`
2. **Change:** `private useMock = true;` to `private useMock = false;`
3. **Open:** `src/app/services/audit-log.service.ts`
4. **Change:** `private useMock = true;` to `private useMock = false;`

## Features Demonstrated

Even with mock data, you can see all the implemented features:

- **CRUD Operations**: Full task lifecycle management
- **Real-time Search**: Filter tasks as you type
- **Pagination**: Navigate through multiple pages
- **Modal Forms**: Create and edit tasks in popup dialogs
- **Audit Trail**: See all operations with timestamps and color coding
- **Responsive Design**: Works on desktop and mobile
- **Form Validation**: Proper input validation and error handling

## Architecture

- **Angular 20**: Latest Angular framework
- **Standalone Components**: Modern Angular architecture
- **HTTP Interceptor**: Automatic Basic Authentication
- **Services**: Separation of concerns with dedicated services
- **Models**: TypeScript interfaces for type safety
- **SCSS**: Modern styling with dark theme
- **Responsive Layout**: CSS Grid and Flexbox