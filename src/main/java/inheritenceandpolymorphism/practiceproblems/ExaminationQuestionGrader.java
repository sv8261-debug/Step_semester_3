
package inheritenceandpolymorphism.practiceproblems;

import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String text, String correctAnswer,
             String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();

    abstract String getType();
}

class MCQQuestion extends Question {
    MCQQuestion(String text, String correct,
                String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    @Override
    String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String text, String correct,
                      String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    @Override
    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String text, String correct,
                  String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    double evaluate() {
        String answer = studentAnswer.toLowerCase(Locale.ROOT);
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            String word = keyword.trim().toLowerCase(Locale.ROOT);

            if (!word.isEmpty() && answer.contains(word)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    @Override
    String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    static List<String> parseFields(String line) {
        List<String> fields = new ArrayList<>();
        Matcher matcher =
                Pattern.compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (matcher.find()) {
            fields.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group(2));
        }

        return fields;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            List<String> data = parseFields(sc.nextLine());

            String type = data.get(0);
            String text = data.get(1);
            String correct = data.get(2);
            String student = data.get(3);
            double points = Double.parseDouble(data.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new MCQQuestion(
                            text, correct, student, points));
                    break;
                case "TF":
                    questions.add(new TrueFalseQuestion(
                            text, correct, student, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(
                            text, correct, student, points));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unknown question type: " + type);
            }
        }

        for (Question question : questions) {
            double score = question.evaluate();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}

