import models.Question;
import store.QuestionStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Runner {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static final QuestionStore store = new QuestionStore();

    public static int inputUserChoice() {
        while (true) { // keep asking till valid input is added.
            System.out.println("\nEnter your choice (1. GET questions, 2. POST question, 3. Exit)");
            System.out.print("Choice: ");
            try { // handling IO Exception
                return Integer.parseInt(input.readLine());
            } catch (Exception e) {
                System.out.println("Something wrong with the added information.");
            }
        }
    }

    public static Question inputQuestion() {
        while (true) { // keep asking till valid input is added.
            try { // handling IO Exception
                System.out.print("\nURL: ");
                String url = input.readLine();

                System.out.print("Importance Level (1-5): ");
                int importanceLevel = Integer.parseInt(input.readLine());

                System.out.print("Solved(yes/[no]): ");
                String solved = input.readLine();

                Question question = new Question(url, importanceLevel);
                question.setSolved(solved.equals("yes"));

                return question;
            } catch (Exception e) {
                System.out.println("Something wrong with the added information.");
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            choice = inputUserChoice();
            if (choice == 1) {
                List<Question> questions = store.getQuestions();
                if (questions.isEmpty()) {
                    System.out.println("\n======== No Questions =========");
                } else {
                    System.out.println("\n======== Questions List =========");
                    for (int i = 0; i < questions.size(); ++i) {
                        System.out.print((i + 1) + " - " + questions.get(i).url);
                        if (questions.get(i).getSolved()) {
                            System.out.print(" ✔");
                        }
                        System.out.println();
                    }
                }
            } else if (choice == 2) {
                Question question = inputQuestion();
                store.addNewQuestion(question);
            }
        } while (choice == 1 || choice == 2);
    }
}
