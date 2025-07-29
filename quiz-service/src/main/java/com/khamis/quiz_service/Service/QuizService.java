package com.khamis.quiz_service.Service;
import com.khamis.quiz_service.Feign.QuizInterface;
import com.khamis.quiz_service.Model.Question;
import com.khamis.quiz_service.Model.QuestionWep;
import com.khamis.quiz_service.Model.Quiz;
import com.khamis.quiz_service.Model.Response;
import com.khamis.quiz_service.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQUIZ(String category, int numQ, String title) {
        Quiz quiz=new Quiz();
        List<Integer>questionsIds=quizInterface.generatequestions(category,numQ).getBody();
        quiz.setTitle(title);
        quiz.setQuestionsId(questionsIds);
        quizRepo.save(quiz);
        return new ResponseEntity<>("good", HttpStatus.OK);
    }



    public ResponseEntity<List<QuestionWep>> getQuiz(int id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Integer>questions=quiz.getQuestionsId();
        List<QuestionWep>questionWeps=quizInterface.getQuestions(questions);


        return new  ResponseEntity<>(questionWeps,HttpStatus.OK);
    }

    public ResponseEntity<Integer> SubmitAnswer(int id, List<Response> responses) {
        int score=quizInterface.score(responses).getBody();
      return new ResponseEntity<>(score,HttpStatus.OK);
   }
}
