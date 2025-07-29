package com.khamis.question_service.Service;


import com.khamis.question_service.Model.Question;
import com.khamis.question_service.Model.QuestionWep;
import com.khamis.question_service.Model.Response;
import com.khamis.question_service.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<List<Question>>getallquestions(){
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> findByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategoryIgnoreCase(category),HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepo.findByCategoryIgnoreCase(category),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String>  addQuestion(Question question) {
        questionRepo.save(question);
        try {
            return new ResponseEntity<>("Sucess",HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Faild",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Integer>> generateQuestions(String category, int numbQu) {
        List<Integer>questionsids=questionRepo.findRandomQuestionsByCategoryIgnoreCase(category,numbQu);
        return new ResponseEntity<>(questionsids,HttpStatus.OK);
    }

    public List<QuestionWep> getQuestionsByID(List<Integer> questionsIds) {
        List<QuestionWep>weps=new ArrayList<>();
        List<Question>questions=new ArrayList<>();
        for(Integer id:questionsIds){
            questions.add(questionRepo.findById(id).get());
        }
        for(Question q:questions){
            QuestionWep questionWep=new QuestionWep(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            weps.add(questionWep);
        }
        return weps;
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int rights=0;
        for (Response response:responses){
            Question question=questionRepo.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer())){
                rights++;
            }
        }
        return new  ResponseEntity<>(rights,HttpStatus.OK);
    }
}
