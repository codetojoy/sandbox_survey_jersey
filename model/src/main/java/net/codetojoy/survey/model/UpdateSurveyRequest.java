package net.codetojoy.survey.model;

import static net.codetojoy.survey.model.Constants.*;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateSurveyRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private long userId = UNKNOWN_ID;
    private long surveyId = UNKNOWN_ID;
    private List<Answer> answers = new ArrayList<>();

    // getters, setters

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
