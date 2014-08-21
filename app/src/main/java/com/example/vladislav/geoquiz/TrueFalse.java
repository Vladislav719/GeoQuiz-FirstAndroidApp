package com.example.vladislav.geoquiz;

/**
 * Created by vladislav on 19.08.14.
 */
public class TrueFalse {

    private int question;
    private boolean trueQuestion;
    private boolean answerIsShown;

    public TrueFalse(int question, boolean trueQuestion){
        this.question = question;
        this.trueQuestion = trueQuestion;
        answerIsShown = false; //default value would be false
    }

    public TrueFalse(int q, boolean trueQuestion, boolean answerIsShown){
        question = q;
        this.trueQuestion = trueQuestion;
        this.answerIsShown = answerIsShown;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isTrueQuestion() {
        return trueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        this.trueQuestion = trueQuestion;
    }

    public boolean isAnswerIsShown() {
        return answerIsShown;
    }

    public void setAnswerIsShown(boolean answerIsShown) {
        this.answerIsShown = answerIsShown;
    }
}
