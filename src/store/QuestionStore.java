package store;

import models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionStore {
    private final List<Question> questions;

    public QuestionStore() {
        questions = new ArrayList<>();
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void addNewQuestion(Question question) {
        questions.add(question);
    }
}
