package net.codetojoy.survey.model;

import static net.codetojoy.survey.model.Constants.*;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SurveyRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private long userId = UNKNOWN_ID;

    // getters, setters

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
