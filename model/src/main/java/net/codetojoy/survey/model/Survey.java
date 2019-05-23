package net.codetojoy.survey.model;

import java.util.*;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Survey implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private long userId;
    private List<Question> questions = new ArrayList<>();

    public Survey() {
       this.id = Constants.UNKNOWN_ID;
       this.userId = Constants.UNKNOWN_ID;
       this.questions = new ArrayList<>();
    }

    public Survey(long id, long userId, List<Question> questions) {
        this.id = id;
        this.userId = userId;
        this.questions = questions;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("id: " + id);
        buffer.append(" userId: " + userId);
        for (Question question : questions) {
            buffer.append(question.toString());
        }
        buffer.append("\n------\n");

        return buffer.toString();
    }

    // getters, setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
