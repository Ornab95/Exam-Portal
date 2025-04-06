# 🎓 Quiz Application - Spring Boot REST API


## Overview
This is a Spring Boot-based Quiz Application that provides REST APIs for managing questions, creating quizzes, and evaluating responses.

## 🚀 Features

- 📚 Question Management (CRUD)
- 📝 Quiz Creation by Subject with Random Questions
- 🧠 Quiz Attempt Functionality
- 📊 Automatic Result Evaluation
- 🔒 RESTful APIs with Clean Architecture
- 📄 Swagger UI for API Testing

## 🛠 Technologies Used

- ☕ **Java 21**
- 🧰 **Spring Boot 3.4.4**
- 🗃️ **Spring Data JPA**
- 🐬 **MySQL**
- 🦾 **Lombok**
- 📦 **Maven**
- 📜 **Swagger** (Springdoc OpenAPI)

## 📁 Project Structure

com.exam
├── controller
│   ├── QuizController.java
│   └── QuestionController.java
├── model
│   ├── Question.java
│   ├── Quiz.java
│   ├── QuestionWrapper.java
│   └── Responses.java
├── repository
│   ├── QuestionRepository.java
│   └── QuizRepository.java
├── service
│   ├── QuestionService.java
│   └── QuizService.java

## API Endpoints

### Question Management
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/question/allQuestion` | GET | Get all questions |
| `/question/subject/{subject}` | GET | Get questions by subject |
| `/question/addQuestion` | POST | Add new question |
| `/question/deleteQuestion/{id}` | DELETE | Delete question |

### Quiz Operations
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/quiz/create?subject=X&namQ=Y&title=Z` | POST | Create new quiz |
| `/quiz/getQuiz/{id}` | GET | Get quiz questions |
| `/quiz/submit/{id}` | POST | Submit quiz answers |

### 📌Sample Usage

## ➕Add Question
http://localhost:8080/question/addQuestion

curl -X POST -H "Content-Type: application/json" -d '{
    "questionTitle": "What is Java?",
    "option1": "Programming Language",
    "option2": "Coffee",
    "option3": "Island",
    "option4": "Car",
    "answer": "Programming Language",
    "dificulty": "Easy",
    "subject": "java"
}' 
Response is 201 Created and Question added successfully

### 📋Get All Questions
GET http://localhost:8080/question/allQuestion
[
  {
    "questionTitle": "What is Java?",
    "option1": "Programming Language",
    "option2": "Coffee",
    "option3": "Island",
    "option4": "Car",
    "answer": "Programming Language",
    "dificulty": "Easy",
    "subject": "java"
  }
]
### 📂Get Questions By Subject
GET http://localhost:8080/question/subject/{subject}
[
  {
    "id": 1,
    "questionTitle": "What is the capital of France?",
    "option1": "Berlin",
    "option2": "Madrid",
    "option3": "Paris",
    "option4": "Rome",
    "answer": "Paris",
    "dificulty": "Easy",
    "subject": "Geography"
  },
  {
    "id": 2,
    "questionTitle": "Which data structure uses FIFO?",
    "option1": "Stack",
    "option2": "Queue",
    "option3": "Tree",
    "option4": "Graph",
    "answer": "Queue",
    "dificulty": "Medium",
    "subject": "Data Structure"
  }
]
### ❌Delete Question
DELETE http://localhost:8080/question/deleteQuestion/{id}

## 🧩Create Quiz
POST "http://localhost:8080/quiz/create?subject=java&namQ=5&title=JavaQuiz"

### 📥Get Quiz Questions
GET http://localhost:8080/quiz/getQuiz/{id}
[
  {
    "id": 1,
    "questionTitle": "What is the capital of France?",
    "option1": "Berlin",
    "option2": "Madrid",
    "option3": "Paris",
    "option4": "Rome",
    "dificulty": "Easy",
    "subject": "Geography"
  }
]
### ✅Submit Quiz
POST http://localhost:8080/quiz/submit/{id}
[
  {
    "id": 1,
    "response": "Programming Language"
  }
]
Swagger API http://localhost:8080/swagger-ui/index.html
## 🧑‍💻 Developer

**Ornab Biswass**  
📧 [ornabbiswass@gmail.com](mailto:ornabbiswass@gmail.com)  
🌐 [GitHub – Ornab95](https://github.com/Ornab95)
