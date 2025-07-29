package com.khamis.quiz_service.Controller;


import com.khamis.quiz_service.Model.QuestionWep;
import com.khamis.quiz_service.Model.QuizDTO;
import com.khamis.quiz_service.Model.Response;
import com.khamis.quiz_service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestBody QuizDTO quizDTO){
        quizService.createQUIZ(quizDTO.getCategory(),quizDTO.getNumQ(),quizDTO.getTitle());
        return new  ResponseEntity<>("Secuess",HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWep>> findQuizById(@PathVariable int id){

        return quizService.getQuiz(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitAnswers(@PathVariable int id, @RequestBody   List<Response>responses){
        return quizService.SubmitAnswer(id,responses);
    }

}
