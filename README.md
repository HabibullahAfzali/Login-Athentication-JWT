# Authentication and Authorization Project with Spring Boot Security, Java 17, JWT, BCrypt, MySQL, Vue.js, Bootstrap, and Axios
This project is a demonstration of a full-stack web application that implements authentication and authorization using Spring Boot Security on the backend and Vue.js on the frontend. It includes CRUD operations for users, role assignment to users, login authentication, and role-based authorization.

# Technologies Used
## Backend:
Java 17
Spring Boot Security
JSON Web Tokens (JWT)
BCrypt for password hashing
MySQL for data storage
Maven for dependency management

## Frontend:
Vue.js
Bootstrap for styling
Axios for making HTTP requests to the backend
3 Features
### User Management:

Create, Read, Update, and Delete (CRUD) operations for users.
View a list of all users.
Assign roles to users.
### Authentication:

Secure user authentication using JWT tokens.
User registration and login.

### Authorization:

Role-based authorization to restrict access to certain resources and functionalities.
Example roles: User, Admin, etc.
# Backend Setup
1-Clone the Repository:

git clone <repository_url>
cd <repository_directory>

2-Configure the Database:

Create a MySQL database and update the application.properties file with the database connection information.
3-Build and Run the Backend:

- mvn clean install
- mvn spring-boot:run
The backend server should start at http://localhost:8080.

# Frontend Setup
1-Navigate to the Vue.js Frontend Directory:
cd frontend

2-Install Dependencies:
npm install

3-Run the Frontend:

npm run dev

# Usage
1-Registration:

Visit the registration page to create a new user account.
2-Login:

Use your registered credentials to log in.
3-User Management:

Once logged in, authorized users (e.g., Admin) can perform CRUD operations on users and assign roles.
4-Authorization:

Access to certain features and functionality is restricted based on user roles.
# API Endpoints
The API endpoints for user management and authentication are available at http://localhost:8080/api.

You can explore the API using tools like Postman or curl.

## Security
This project incorporates security best practices such as password hashing (BCrypt) and JWT for authentication and authorization.
## Contributing
Feel free to contribute to this project by opening issues or pull requests.

Enjoy using this Authentication and Authorization project! If you have any questions or encounter issues, please don't hesitate to reach out.





