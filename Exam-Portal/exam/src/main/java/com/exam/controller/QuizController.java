package com.exam.controller;

//import com.exam.model.Question;
import com.exam.model.QuestionWrapper;
import com.exam.model.Responses;
//import com.exam.repository.QuizRepository;
import com.exam.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
//    @Autowired
//    QuizRepository repository;

    @Autowired
    QuizService quizService;

    @PostMapping("/create") // http://localhost:8080/quiz/create?subject=java&namQ=10&title=javaQuiz
    public ResponseEntity<String> createQuiz(@RequestParam String subject,@RequestParam int namQ,@RequestParam String title) {
        return quizService.createQuiz(subject, namQ, title);
    }

    @GetMapping("/getQuiz/{id}") // http://localhost:8080/quiz/getQuiz/1
    public ResponseEntity<List<QuestionWrapper>> getQuestion(@PathVariable Integer id) {
        return quizService.getQuizQuestion(id);
    }
    // http://localhost:8080/quiz/submit/{id}
     @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Responses> responses) {
         return quizService.calculateResult(id, responses);
     }
}
