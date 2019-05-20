package net.codetojoy.survey.model;

import java.io.Serializable;

public class Greeting implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String content;

    public Greeting() {
        this.id = -999L;
        this.content = "unknown";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "id: " + id + " content: " + content;
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
