package net.codetojoy.survey.model;

import java.io.Serializable;

public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String desc;

    public Answer() {
       this.id = Constants.UNKNOWN_ID;
       this.desc = "";
    }

    public Answer(long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("id: " + id);
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
