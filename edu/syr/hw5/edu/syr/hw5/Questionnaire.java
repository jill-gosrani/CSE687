// Name: Pavan Pandya
// Net Id: pjpandya
// SU ID: 340197894


package edu.syr.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Question {
    static enum QUESTION_PROMPT_CONSTANT{
        ADMINISTER ("True or False: "),
        LIEKERT ("Rate between 1-5 where \n5 is Strongly Agree\n4 is Somewhat Agree\n3 is Neutral\n2 is Somewhat Disagree\n1 is Strong Disagree");

        private final String prompt;
        QUESTION_PROMPT_CONSTANT(String prompt){
            this.prompt = prompt;
        }

        public String getPrompt(){
            return this.prompt;
        }
    }
    private String q;
    private String prompt;
    private List<String> acceptableAnswers;
    private QUESTION_PROMPT_CONSTANT type;
    public Question(String q, String prompt, List<String> acceptable, QUESTION_PROMPT_CONSTANT qpc) {
        this.q = q;
        this.prompt = prompt;
        this.acceptableAnswers = acceptable;
        this.type = qpc;
    }
    public void render(PrintStream p) {
        p.println(q);
        p.println(prompt);
    }

    public String getPrompt(){
        return this.prompt;
    }

    public QUESTION_PROMPT_CONSTANT getType(){
        return this.type;
    }
    public boolean isAcceptableAnswer(String s) {
        return acceptableAnswers.contains(s);
    }
}

public class Questionnaire {

    enum AGREE_LEVEL {
        Strongly_Agree("Strongly Agree"),
        Somewhat_Agree("Somewhat Agree"),
        Neutral("Neutral"),
        Somewhat_Disagree("Somewhat Disagree"),
        Strong_Disagree("Strong Disagree");

        private final String levelName;

        AGREE_LEVEL(String ln) {
            this.levelName = ln;
        }

        public String getLevelName() {
            return this.levelName;
        }

    }

    List<edu.syr.hw5.Question> questions;

    public Questionnaire() {
        questions = new ArrayList<>();
    }

    public void addQuestion(edu.syr.hw5.Question q) {
        questions.add(q);
    }

    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (edu.syr.hw5.Question q : questions) {
            q.render(System.out);
            String response = "";
            do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswer(response));
            if (q.getType() == edu.syr.hw5.Question.QUESTION_PROMPT_CONSTANT.LIEKERT)
                switch (response) {
                    case "1":
                        response = edu.syr.hw5.Questionnaire.AGREE_LEVEL.Strong_Disagree.getLevelName();
                        break;
                    case "2":
                        response = edu.syr.hw5.Questionnaire.AGREE_LEVEL.Somewhat_Disagree.getLevelName();
                        break;
                    case "3":
                        response = edu.syr.hw5.Questionnaire.AGREE_LEVEL.Neutral.getLevelName();
                        break;
                    case "4":
                        response = edu.syr.hw5.Questionnaire.AGREE_LEVEL.Somewhat_Agree.getLevelName();
                        break;
                    case "5":
                        response = edu.syr.hw5.Questionnaire.AGREE_LEVEL.Strongly_Agree.getLevelName();
                        break;
                    default:
                        response = "Wrong choice";
                        break;
                }
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        edu.syr.hw5.Questionnaire q = new edu.syr.hw5.Questionnaire();
        q.addQuestion(new edu.syr.hw5.Question("Are you awake?", Question.QUESTION_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"), Question.QUESTION_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("Have you had coffee?", Question.QUESTION_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"), Question.QUESTION_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("Are you ready to get to work?", Question.QUESTION_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"),Question.QUESTION_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("CSE 687 is awesome.", Question.QUESTION_PROMPT_CONSTANT.LIEKERT.getPrompt(), Arrays.asList("1","2","3","4","5"),Question.QUESTION_PROMPT_CONSTANT.LIEKERT));
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}