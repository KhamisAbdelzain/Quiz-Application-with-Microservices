package com.khamis.question_service.Controller;


import com.khamis.question_service.Model.Question;
import com.khamis.question_service.Model.QuestionWep;
import com.khamis.question_service.Model.Response;
import com.khamis.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("all")
    public ResponseEntity<List<Question>> getallquestions(){
        return questionService.getallquestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllCategory(@PathVariable String category){
        return questionService.findByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody  Question question){
       return questionService.addQuestion(question);
    }
    @GetMapping("generate")
    public ResponseEntity<List<Integer>>generatequestions(@RequestParam String category,@RequestParam int numbQu){

        return questionService.generateQuestions(category,numbQu);
    }
    @PostMapping("getQuestions")
    public List<QuestionWep>getQuestions(@RequestBody List<Integer>questionsIds){
        return questionService.getQuestionsByID(questionsIds);
    }
    @PostMapping("score")
    public ResponseEntity<Integer>score(@RequestBody List<Response>responses){
        return questionService.getScore(responses);
    }

}
