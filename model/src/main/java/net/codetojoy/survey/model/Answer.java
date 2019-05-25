package net.codetojoy.survey.model;

import static net.codetojoy.survey.model.Constants.*;

import java.io.Serializable;

public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String desc;
    private boolean selected;
    private int score;
    private String comment;

    public Answer() {
       this.id = Constants.UNKNOWN_ID;
       this.desc = "";
       this.selected = false;
       this.score = 0;
       this.comment = "";
    }

    public Answer(long id, String desc, boolean selected, int score) {
        this.id = id;
        this.desc = desc;
        this.selected = selected;
        this.score = score;
        this.comment = "";
    }

    public Answer(long id, String desc) {
        this(id, desc, false, 0);
    }

    public void clear() {
        selected = false;
        comment = "";
    }

    public void doSelect(String comment) {
        this.selected = true;
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(SPACER + SPACER + "id: " + id);
        buffer.append(" desc: " + desc);
        buffer.append(" selected: " + selected);
        buffer.append(" score: " + score);
        buffer.append(" comment: " + comment);

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
