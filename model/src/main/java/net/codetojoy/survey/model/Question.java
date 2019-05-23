package net.codetojoy.survey.model;

import java.util.*;
import java.io.Serializable;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String logicalName;
    private String desc;
    // private List<Answer> answers;
    // private Response response;

    public Question() {
        this.id = Constants.UNKNOWN_ID;
        this.logicalName = "";
        this.desc = "";
        // this.answers = new ArrayList<>();
    }

    public Question(long id, String logicalName, String desc) { // , List<Answer> answers) {
        this.id = id;
        this.logicalName = logicalName;
        this.desc = desc;
        // this.answers = answers;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("\n");
        buffer.append("id: " + id);
        buffer.append(" logicalName: " + logicalName);
        buffer.append(" desc: " + desc);

        return buffer.toString();
    }

    // getters, setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogicalName() {
        return logicalName;
    }

    public void setLogicalName(String logicalName) {
        this.logicalName = logicalName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /*
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    */
}