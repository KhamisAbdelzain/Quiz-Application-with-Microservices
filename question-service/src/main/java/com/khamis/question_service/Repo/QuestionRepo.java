package com.khamis.question_service.Repo;


import com.khamis.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategoryIgnoreCase(String category);
    //
    @Query(value = "SELECT q.id from question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ ",nativeQuery = true)
    List <Integer>findRandomQuestionsByCategoryIgnoreCase(String category,int numQ);

}
