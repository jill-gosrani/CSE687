//Name : Pavan Pandya
//NEtId : pjpandya@syr.edu
//SU ID : 340197894

package edu.syr.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    private enum ANSWERS{
        FALSE,
        TRUE
    }
    List<String> questions;
    List<String> liekertQuestions;
    public Questionnaire() {
        questions = new ArrayList<>();
        liekertQuestions =new ArrayList<>();
    }
    public void addAdministerQuestion(String s) {
        if(s != null || s != "") {
            questions.add(s);
        }
    }

    public void addLiekertQuestion(String s) {
        if(s != null || s != "")
            liekertQuestions.add(s);
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: questions) {
            System.out.println("True or False: ");
            System.out.println(s);
            String response = "";
            boolean valid = false;
            while(!valid) {
                try {
                    response = reader.readLine();
                    if(response.length() > 0){
                        if(!response.trim().equalsIgnoreCase(ANSWERS.FALSE.name()) && !response.trim().equalsIgnoreCase(ANSWERS.TRUE.name())){
                            System.out.println("The valid answers are only true and false, please answer among them only and answer this question " + s + " again.");
                        }else{
                            valid = true;
                        }
                    }else{
                        System.out.println("Please provide an answer");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(valid) {
                    answers.add(response);
                }
            }
        }
        return answers;
    }

    public List<String> liekertQuestionnaire() {
        List<String> ans = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(String s: liekertQuestions) {
            System.out.println("Rate between 1-5 where \n 5 is Strongly Agree \n 4 is Somewhat Agree \n 3 is Neutral \n 2 is Somewhat Disagree \n 1 is Strong Disagree");
            System.out.println(s);
            String response = "";
            boolean valid = false;
            while(!valid) {
                try {
                    response = reader.readLine();
                    if(response.length() > 0){
                        try{
                            int answer = Integer.parseInt(response);
                            if(answer < 0 || answer > 5) {
                                System.out.println("You can enter the rating only between 1 to 5, please rate the following question " + s + " again.");
                            } else {
                                valid = true;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("please Enter a valid number");
                        }
                    } else {
                        System.out.println("Please Enter a number");
                    }
                }catch(IOException e) {
                    e.printStackTrace();
                }
                if(valid) ans.add(response);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addAdministerQuestion("Are you awake?");
        q.addAdministerQuestion("Have you had coffee?");
        q.addAdministerQuestion("Are you ready to get to work?");
        q.addLiekertQuestion("CSE 687 is awesome.");
        List<String> ans = q.administerQuestionnaire();
        ans.addAll(q.liekertQuestionnaire());
        System.out.println("complete!");
        System.out.println(ans);
    }
}

