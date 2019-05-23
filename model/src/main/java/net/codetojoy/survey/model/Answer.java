package net.codetojoy.survey.model;

import java.io.Serializable;

public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String content;

    public Answer() {
       this.id = -999L;
       this.content = "";
    }

    public Answer(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // getters, setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
