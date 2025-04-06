package com.exam.controller;

import com.exam.model.Question;
import com.exam.service.QuestionService;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api(tags = "Question Management")
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")  // http://localhost:8080/question/allQuestion
    public ResponseEntity< List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("subject/{subject}")  // http://localhost:8080/question/subject
    public ResponseEntity <List<Question>> getQuestionBySubject(@PathVariable String subject) {
        return questionService.getQuestionBySubject(subject);
    }
    @PostMapping("/addQuestion")  // http://localhost:8080/question/addQuestion
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")  // http://localhost:8080/question/deleteQuestion/{id}
    public ResponseEntity <String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

}
