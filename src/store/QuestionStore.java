package store;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Question;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionStore {
    private final List<Question> questions;
    private final ObjectMapper mapper = new ObjectMapper();

    public QuestionStore() {
        questions = readQuestionsFromFile();
    }


    public List<Question> getQuestions() {

        return questions.stream().sorted().toList();
    }

    private static final String DATA_STORE_FILE = "database.json";

    private void storeQuestionsInFile() throws IOException {
        mapper.writeValue(new File(DATA_STORE_FILE), questions);
    }

    private List<Question> readQuestionsFromFile() {
        try {
            File file = new File(DATA_STORE_FILE);
            if (!file.exists()) file.createNewFile();
            return mapper.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            System.out.println("Failed to read from file - initializing as empty list");
            return new ArrayList<>();
        }
    }

    public void addNewQuestion(Question question) {
        questions.add(question);
        try {
            storeQuestionsInFile();
        } catch (IOException e) {
            System.out.println("Failed to write into the file: " + DATA_STORE_FILE);
        }
    }
}
