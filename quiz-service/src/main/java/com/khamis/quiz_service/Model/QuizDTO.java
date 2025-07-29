package com.khamis.quiz_service.Model;

import lombok.Data;

@Data
public class QuizDTO {
    private String category;
    private int numQ;
    private String title;
}
