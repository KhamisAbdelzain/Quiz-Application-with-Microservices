package com.khamis.quiz_service.Feign;

import com.khamis.quiz_service.Model.QuestionWep;
import com.khamis.quiz_service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> generatequestions(@RequestParam String category, @RequestParam int numbQu);


    @PostMapping("questions/getQuestions")
    public List<QuestionWep>getQuestions(@RequestBody List<Integer>questionsIds);

    @PostMapping("questions/score")
    public ResponseEntity<Integer>score(@RequestBody List<Response>responses);

}
