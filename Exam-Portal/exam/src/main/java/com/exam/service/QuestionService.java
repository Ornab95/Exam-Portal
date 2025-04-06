package com.exam.service;

import com.exam.model.Question;
import com.exam.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository ab;

    public QuestionService(QuestionRepository ab) {
        this.ab = ab;
    }

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public ResponseEntity< List<Question>> getAllQuestion() {
        try{
            return new ResponseEntity<>(ab.findAll(), HttpStatus.OK) ;
        } catch (Exception e) {
            logger.error("Error fetching all questions", e);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>>  getQuestionBySubject(String subject) {
        try {
            return new ResponseEntity<>(ab.findBySubject(subject), HttpStatus.OK);
        } catch (Exception e) {

            logger.error("Error fetching questions by subject: " ,e);
        }
        return new ResponseEntity<>(ab.findBySubject(subject), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        Question savedQuestion = ab.save(question);
        try {

                return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            logger.error("Error adding question", e);
        }
        return new ResponseEntity<>("Question added successfully", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            if (!ab.existsById(id)){
                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
            }
            ab.deleteById(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            logger.error("Error deleting question", e);
            return new ResponseEntity<>("Internal Server Error while deleting question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

